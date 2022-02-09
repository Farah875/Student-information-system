/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms.admin;


import DTO.Course;
import DTO.User;
import Repositories.classRepo;
import Repositories.courseRepo;
import Repositories.userRepo;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author Farah Z
 */
public class classesForm extends javax.swing.JFrame {

    /**
     * Creates new form classesForm
     */
    
    User logged;
    courseRepo repoCourse = new courseRepo();
    userRepo userRepo = new userRepo();
    classRepo repo = new classRepo();
    DTO.Class classUsed = new DTO.Class();
    
    
    public classesForm( User logged) {
        initComponents();
        this.logged = logged;
        setTableDesign(classesTable,jScrollPane1);
        setTableDesign(coursesTable,jScrollPane2);
        setTableDesign(studentsTable,jScrollPane3);
        
        
        //filling combo boxes 
        for (User std : userRepo.getAllUsers(2))
        {
            this.StudentList.addItem(std.getUsername()+"-"+std.getFirstName());
        }
        
        for( Course c : repoCourse.getAllCourses())
        {
            this.courseList.addItem(c.getName()+"-"+repo.getClassByID(c.getClassID()));
        }
        
        
        RefreshTables(0);
    }
    
    public classesForm( ) {
        initComponents();
        this.logged = userRepo.getUserByID(1);
        setTableDesign(classesTable,jScrollPane1);
        setTableDesign(coursesTable,jScrollPane2);
        setTableDesign(studentsTable,jScrollPane3);
        
        //filling combo boxes 
        for (User std : userRepo.getAllUsers(2))
        {
            this.StudentList.addItem(std.getUsername()+"-"+std.getFirstName());
        }
        
        for( Course c : repoCourse.getAllCourses())
        {
            this.courseList.addItem(c.getName()+"-"+repo.getClassByID(c.getClassID()).getName());
        }
        
        RefreshTables(0);
    }
    
    
    public void setTableDesign(JTable jTable1, JScrollPane jScrollPane){
        
         // set background color of empty area of table
        ((DefaultTableCellRenderer)jTable1.getDefaultRenderer(Object.class))
                .setBackground(new Color (242,232,199));
        
        ((DefaultTableCellRenderer)jTable1.getDefaultRenderer(Object.class))
                      .setOpaque(false);

        jScrollPane.getViewport().setOpaque(false);
        
        //setting the text to center inside the cell
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        jTable1.setDefaultRenderer(Object.class, centerRenderer);
        
        // change table header proporties, background and foreground colors, font , text alligment
       JTableHeader tHeader = jTable1.getTableHeader();
       tHeader.setForeground(Color.BLACK);
       tHeader.setBackground(Color.BLACK);
       tHeader.setFont(new Font ("Times New Roman", Font.BOLD, 14));
       ((DefaultTableCellRenderer)tHeader.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
        
    }
    
    private void RefreshTables(int idClass) {
        
        // this.classLabel.setText(this.classLabel.getText()+ " " + repo.getClassByID(idClass).getName() );
        
        DefaultTableModel courses = new DefaultTableModel(new Object[]
                {"id","Name"},0);
        for (Course c : repoCourse.getAllCoursesByClass(idClass))
        {
            courses.addRow(new Object[] {c.getID(),c.getName()});
        }
        
        this.coursesTable.setModel(courses);
        this.coursesTable.getColumnModel().getColumn(0).setWidth(0);
        this.coursesTable.getColumnModel().getColumn(0).setMinWidth(0);
        this.coursesTable.getColumnModel().getColumn(0).setMaxWidth(0);
        
        DefaultTableModel classes = new DefaultTableModel(new Object[]
                {"id","Name"},0);
        for (DTO.Class c : repo.getAllClasses())
        {
            classes.addRow(new Object[] {c.getID(),c.getName()});
        }
        
        this.classesTable.setModel(classes);
        this.classesTable.getColumnModel().getColumn(0).setWidth(0);
        this.classesTable.getColumnModel().getColumn(0).setMinWidth(0);
        this.classesTable.getColumnModel().getColumn(0).setMaxWidth(0);
        
        DefaultTableModel students = new DefaultTableModel(new Object[]
                {"id","username-firstname"},0);
        for (User u: userRepo.getAllStudentsByClass(idClass))
        {
            students.addRow(new Object[] {u.getID(),u.getUsername()+" - "+u.getFirstName()});
        }
        
        this.studentsTable.setModel(students);
        this.studentsTable.getColumnModel().getColumn(0).setWidth(0);
        this.studentsTable.getColumnModel().getColumn(0).setMinWidth(0);
        this.studentsTable.getColumnModel().getColumn(0).setMaxWidth(0);
        
    }   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        coursesTable = new javax.swing.JTable();
        classLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        updateBtn = new javax.swing.JButton();
        addStdBtn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        deleteClassBtn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        classesTable = new javax.swing.JTable();
        home = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        studentsTable = new javax.swing.JTable();
        removeCourseBtn = new javax.swing.JButton();
        removeStdBtn = new javax.swing.JButton();
        addBtn = new javax.swing.JButton();
        addCourseBtn = new javax.swing.JButton();
        StudentList = new javax.swing.JComboBox<>();
        courseList = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        refreshItem = new javax.swing.JMenuItem();
        addClassItem = new javax.swing.JMenuItem();
        deleteClassItem = new javax.swing.JMenuItem();
        updateClassItem = new javax.swing.JMenuItem();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(249, 226, 132));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane1.setViewportBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        coursesTable.setBackground(new java.awt.Color(249, 226, 132));
        coursesTable.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        coursesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Title 1"
            }
        ));
        coursesTable.setSelectionBackground(new java.awt.Color(156, 107, 22));
        jScrollPane1.setViewportView(coursesTable);

        classLabel.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        classLabel.setText("Selected Class:");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel2.setText("Select a class to edit:");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel3.setText("<html>Enter a name to update selected class <br>or add a new class:</html>");

        nameField.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        updateBtn.setBackground(new java.awt.Color(225, 181, 70));
        updateBtn.setIcon(new javax.swing.ImageIcon("C:\\Users\\Farah Z\\Desktop\\courses\\Third year 2020_2021\\OOP2\\Project\\SISProject\\src\\Assests\\check-tick-icon-14145.png")); // NOI18N
        updateBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateBtnMouseClicked(evt);
            }
        });

        addStdBtn.setBackground(new java.awt.Color(225, 181, 70));
        addStdBtn.setIcon(new javax.swing.ImageIcon("C:\\Users\\Farah Z\\Desktop\\courses\\Third year 2020_2021\\OOP2\\Project\\SISProject\\src\\Assests\\add-icon-small.png")); // NOI18N
        addStdBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addStdBtnMouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel4.setText("Students, select a student to remove");

        deleteClassBtn.setBackground(new java.awt.Color(225, 181, 70));
        deleteClassBtn.setIcon(new javax.swing.ImageIcon("C:\\Users\\Farah Z\\Desktop\\courses\\Third year 2020_2021\\OOP2\\Project\\SISProject\\src\\Assests\\remove-icon-png-25.png")); // NOI18N
        deleteClassBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteClassBtnMouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setText("Available Classes:");

        jScrollPane2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane2.setViewportBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        classesTable.setBackground(new java.awt.Color(249, 226, 132));
        classesTable.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        classesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Title 1"
            }
        ));
        classesTable.setFillsViewportHeight(true);
        classesTable.setSelectionBackground(new java.awt.Color(156, 107, 22));
        classesTable.setShowGrid(false);
        classesTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                classesTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(classesTable);

        home.setBackground(new java.awt.Color(225, 181, 70));
        home.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        home.setText("Back to home");
        home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homeMouseClicked(evt);
            }
        });

        jScrollPane3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane3.setViewportBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        studentsTable.setBackground(new java.awt.Color(249, 226, 132));
        studentsTable.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        studentsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Title 1"
            }
        ));
        studentsTable.setSelectionBackground(new java.awt.Color(156, 107, 22));
        jScrollPane3.setViewportView(studentsTable);

        removeCourseBtn.setBackground(new java.awt.Color(225, 181, 70));
        removeCourseBtn.setIcon(new javax.swing.ImageIcon("C:\\Users\\Farah Z\\Desktop\\courses\\Third year 2020_2021\\OOP2\\Project\\SISProject\\src\\Assests\\remove-icon-png-25.png")); // NOI18N
        removeCourseBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                removeCourseBtnMouseClicked(evt);
            }
        });

        removeStdBtn.setBackground(new java.awt.Color(225, 181, 70));
        removeStdBtn.setIcon(new javax.swing.ImageIcon("C:\\Users\\Farah Z\\Desktop\\courses\\Third year 2020_2021\\OOP2\\Project\\SISProject\\src\\Assests\\remove-icon-png-25.png")); // NOI18N
        removeStdBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                removeStdBtnMouseClicked(evt);
            }
        });

        addBtn.setBackground(new java.awt.Color(225, 181, 70));
        addBtn.setIcon(new javax.swing.ImageIcon("C:\\Users\\Farah Z\\Desktop\\courses\\Third year 2020_2021\\OOP2\\Project\\SISProject\\src\\Assests\\add-icon-small.png")); // NOI18N
        addBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addBtnMouseClicked(evt);
            }
        });

        addCourseBtn.setBackground(new java.awt.Color(225, 181, 70));
        addCourseBtn.setIcon(new javax.swing.ImageIcon("C:\\Users\\Farah Z\\Desktop\\courses\\Third year 2020_2021\\OOP2\\Project\\SISProject\\src\\Assests\\add-icon-small.png")); // NOI18N
        addCourseBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addCourseBtnMouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel6.setText("Delete selected class?");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel7.setText("Courses, select a course to remove");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel8.setText("Add studnet");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel9.setText("Add course");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGap(121, 121, 121)
                                .addComponent(deleteClassBtn))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(addBtn)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(updateBtn))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(67, 67, 67)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(classLabel)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(removeStdBtn))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(courseList, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel9))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(addCourseBtn))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(StudentList, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel8))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(addStdBtn))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(removeCourseBtn))
                            .addComponent(jLabel4)
                            .addComponent(jLabel7)))
                    .addComponent(jLabel2))
                .addGap(27, 55, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(home))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addComponent(jLabel5)
                    .addContainerGap(639, Short.MAX_VALUE)))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(157, 157, 157)
                    .addComponent(jLabel6)
                    .addContainerGap(577, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(classLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(removeStdBtn)
                                .addGap(35, 35, 35)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(addBtn)
                                    .addComponent(updateBtn))
                                .addGap(54, 54, 54)
                                .addComponent(deleteClassBtn))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addComponent(removeCourseBtn)))))
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(addStdBtn)
                            .addComponent(StudentList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                        .addComponent(addCourseBtn))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(courseList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(home)
                .addContainerGap())
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(29, 29, 29)
                    .addComponent(jLabel5)
                    .addContainerGap(418, Short.MAX_VALUE)))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap(308, Short.MAX_VALUE)
                    .addComponent(jLabel6)
                    .addGap(167, 167, 167)))
        );

        jLabel3.getAccessibleContext().setAccessibleName("<html>Enter a name to update selected class <br>or add a new class:</html>");

        jMenu1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Farah Z\\Desktop\\courses\\Third year 2020_2021\\OOP2\\Project\\SISProject\\src\\Assests\\settings-icon-14968.png")); // NOI18N
        jMenu1.setText("Manage");

        refreshItem.setText("Refresh");
        refreshItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshItemActionPerformed(evt);
            }
        });
        jMenu1.add(refreshItem);

        addClassItem.setText("Add Class");
        addClassItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addClassItemActionPerformed(evt);
            }
        });
        jMenu1.add(addClassItem);

        deleteClassItem.setText("Delete Class");
        deleteClassItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteClassItemActionPerformed(evt);
            }
        });
        jMenu1.add(deleteClassItem);

        updateClassItem.setText("Update Class");
        updateClassItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateClassItemActionPerformed(evt);
            }
        });
        jMenu1.add(updateClassItem);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void updateBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateBtnMouseClicked
//        int column =0;
//        int row = this.classesTable.getSelectedRow();
//        if (row >= 0)
//        {
//            int id = Integer.parseInt(this.classesTable.getValueAt(row, column).toString());
//            classUsed = repo.getClassByID(id);
            classUsed.setName(this.nameField.getText());
            if (repo.updateClass(classUsed) == 0)
            {
                 JOptionPane.showMessageDialog(null,"Class updated successfuly");
            }
            else
             JOptionPane.showMessageDialog(null,"Error occured please try again later");
            
            RefreshTables(classUsed.getID());
//        }
//        else 
//             JOptionPane.showMessageDialog(null,"please select a class to update");
    }//GEN-LAST:event_updateBtnMouseClicked

    private void addStdBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addStdBtnMouseClicked
      
        if (classUsed.getID() >=0 )
        {
            int index = this.StudentList.getSelectedIndex();
            int idStd = userRepo.getAllUsers(2).get(index).getID();
            System.out.println(idStd);
            if (userRepo.assigntoClass(idStd,classUsed.getID() ) == 0)
            {
                 JOptionPane.showMessageDialog(null,"Student added successfuly");
            }
            else
             JOptionPane.showMessageDialog(null,"Error occured please try again later");
            
            RefreshTables(classUsed.getID());
        }
        else JOptionPane.showMessageDialog(null,"Please select a class to add studnets to.");
    }//GEN-LAST:event_addStdBtnMouseClicked

    private void deleteClassBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteClassBtnMouseClicked
        if(repo.deleteClass(classUsed.getID()) == 0)
        {
            JOptionPane.showMessageDialog(null,"Class deleted successfuly");
        }
            else
             JOptionPane.showMessageDialog(null,"Error occured please try again later");
            
            RefreshTables(0);
        
            
    }//GEN-LAST:event_deleteClassBtnMouseClicked

    private void removeCourseBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeCourseBtnMouseClicked
        int column =0;
        int row  = this.coursesTable.getSelectedRow();
        if ( row >= 0)
        {
            int idCourse = Integer.parseInt(this.coursesTable.getValueAt(row, column).toString());
            if(repoCourse.unAssignClass(idCourse) == 0)
            {
                JOptionPane.showMessageDialog(null,"Course removed successfuly");
            }
                else
            JOptionPane.showMessageDialog(null,"Error occured please try again later");

            RefreshTables(classUsed.getID());
        }
    }//GEN-LAST:event_removeCourseBtnMouseClicked

    private void removeStdBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeStdBtnMouseClicked
         int column =0;
        int row = this.studentsTable.getSelectedRow();
        if (row >=0)
        {
            int idStd = Integer.parseInt(this.studentsTable.getValueAt(row, column).toString());
            
            if (userRepo.unAssignClass(idStd ) == 0)
            {
                 JOptionPane.showMessageDialog(null,"Student removed successfuly");
            }
            else
             JOptionPane.showMessageDialog(null,"Error occured please try again later");
            
            RefreshTables(classUsed.getID());
        }
    }//GEN-LAST:event_removeStdBtnMouseClicked

    private void addBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addBtnMouseClicked
        DTO.Class toAdd = new DTO.Class();
                toAdd.setName(this.nameField.getText());
                if(repo.addClass(toAdd) == 0)
                {
                    JOptionPane.showMessageDialog(null, "Class added successfuly");
                }
                else
                    JOptionPane.showMessageDialog(null,"Error occured please try again later");
                RefreshTables(0);
    }//GEN-LAST:event_addBtnMouseClicked

    private void addCourseBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addCourseBtnMouseClicked
        
        if ( classUsed.getID() >= 0)
        {
            int idCourse = this.courseList.getSelectedIndex();
            if(repoCourse.assignClass(repoCourse.getCourseByID(idCourse),classUsed.getID()) == 0)
            {
                JOptionPane.showMessageDialog(null,"Course added successfuly");
            }
            else
            JOptionPane.showMessageDialog(null,"Error occured please try again later");

            RefreshTables(classUsed.getID());
        }
        
    }//GEN-LAST:event_addCourseBtnMouseClicked

    private void classesTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_classesTableMouseClicked
        int column = 0;
        int row = classesTable.getSelectedRow();
        if(row >= 0)
        {
            int id = Integer.parseInt(this.classesTable.getValueAt(row, column).toString());
            classUsed = repo.getClassByID(id);
            RefreshTables(id);
        }
        
    }//GEN-LAST:event_classesTableMouseClicked

    private void homeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeMouseClicked
        adminMainForm adminForm = new adminMainForm(logged);
        adminForm.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_homeMouseClicked

    private void refreshItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshItemActionPerformed
        RefreshTables(0);
    }//GEN-LAST:event_refreshItemActionPerformed

    private void deleteClassItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteClassItemActionPerformed
        if(repo.deleteClass(classUsed.getID()) == 0)
        {
            JOptionPane.showMessageDialog(null,"Class deleted successfuly");
        }
            else
             JOptionPane.showMessageDialog(null,"Error occured please try again later");
            
            RefreshTables(0);
    }//GEN-LAST:event_deleteClassItemActionPerformed

    private void addClassItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addClassItemActionPerformed
        DTO.Class toAdd = new DTO.Class();
                toAdd.setName(this.nameField.getText());
                if(repo.addClass(toAdd) == 0)
                {
                    JOptionPane.showMessageDialog(null, "Class added successfuly");
                }
                else
                    JOptionPane.showMessageDialog(null,"Error occured please try again later");
                RefreshTables(0);
    }//GEN-LAST:event_addClassItemActionPerformed

    private void updateClassItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateClassItemActionPerformed
         classUsed.setName(this.nameField.getText());
            if (repo.updateClass(classUsed) == 0)
            {
                 JOptionPane.showMessageDialog(null,"Class updated successfuly");
            }
            else
             JOptionPane.showMessageDialog(null,"Error occured please try again later");
            
            RefreshTables(classUsed.getID());
    }//GEN-LAST:event_updateClassItemActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(classesForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(classesForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(classesForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(classesForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               new classesForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> StudentList;
    private javax.swing.JButton addBtn;
    private javax.swing.JMenuItem addClassItem;
    private javax.swing.JButton addCourseBtn;
    private javax.swing.JButton addStdBtn;
    private javax.swing.JLabel classLabel;
    private javax.swing.JTable classesTable;
    private javax.swing.JComboBox<String> courseList;
    private javax.swing.JTable coursesTable;
    private javax.swing.JButton deleteClassBtn;
    private javax.swing.JMenuItem deleteClassItem;
    private javax.swing.JButton home;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField nameField;
    private javax.swing.JMenuItem refreshItem;
    private javax.swing.JButton removeCourseBtn;
    private javax.swing.JButton removeStdBtn;
    private javax.swing.JTable studentsTable;
    private javax.swing.JButton updateBtn;
    private javax.swing.JMenuItem updateClassItem;
    // End of variables declaration//GEN-END:variables

    
}
