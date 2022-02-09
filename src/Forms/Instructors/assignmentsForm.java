/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms.Instructors;

import DTO.Material;
import DTO.User;
import Repositories.courseRepo;
import Repositories.materialRepo;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Farah Z
 */
public class assignmentsForm extends javax.swing.JFrame {

    /**
     * Creates new form assigmentsForm
     */
    User logged;
    materialRepo repo = new materialRepo();
    int idCourse;
    int selected;
    Material m  = new Material();
    courseRepo course = new courseRepo();
    
   
    
    public assignmentsForm(User logged, int idCourse) {
        initComponents();
        this.logged = logged;
        this.idCourse = idCourse;
        RefreshList();
    }
    
    public assignmentsForm() {
        initComponents();
        logged = new User("ins12","helo@gmail.com","helo","world","03965472","P@ssw0rd",1);
        this.idCourse = 0;
        RefreshList();
        
    }
    
    public void RefreshList()
    {
        
         DefaultListModel<String> model = new  DefaultListModel<String>();
        for( Material m : repo.getAllMaterialByCourse(idCourse) )
        {
            model.addElement(m.getID()+"-"+m.getName());
        } 
        this.jList1.setModel(model);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        deleteBtn = new javax.swing.JButton();
        downloadBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        deadlineField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        notesField = new javax.swing.JTextArea();
        uploadBtn = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();
        addBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();
        available = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        refreshItem = new javax.swing.JMenuItem();
        deleteItem = new javax.swing.JMenuItem();
        downloadItem = new javax.swing.JMenuItem();
        updateItem = new javax.swing.JMenuItem();
        addItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(249, 226, 132));
        jPanel1.setToolTipText("");

        jList1.setBackground(new java.awt.Color(249, 226, 132));
        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList1.setSelectionBackground(new java.awt.Color(156, 107, 22));
        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("Available assignments:");

        deleteBtn.setBackground(new java.awt.Color(225, 181, 70));
        deleteBtn.setText("Delete Selected Assignment");
        deleteBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteBtnMouseClicked(evt);
            }
        });

        downloadBtn.setBackground(new java.awt.Color(225, 181, 70));
        downloadBtn.setText("Download students documnets");
        downloadBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                downloadBtnMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setText("Create a new assignment:");
        jLabel2.setToolTipText("");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setText("Name:");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setText("Deadline:");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setText("Notes:");

        notesField.setColumns(20);
        notesField.setRows(5);
        jScrollPane2.setViewportView(notesField);

        uploadBtn.setBackground(new java.awt.Color(225, 181, 70));
        uploadBtn.setText("Upload document ");
        uploadBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                uploadBtnMouseClicked(evt);
            }
        });

        updateBtn.setBackground(new java.awt.Color(225, 181, 70));
        updateBtn.setText("UpdateSelected Assigment");
        updateBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateBtnMouseClicked(evt);
            }
        });

        addBtn.setBackground(new java.awt.Color(225, 181, 70));
        addBtn.setText("Add New Assignment");
        addBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addBtnMouseClicked(evt);
            }
        });

        backBtn.setBackground(new java.awt.Color(225, 181, 70));
        backBtn.setText("Back To Home");
        backBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backBtnMouseClicked(evt);
            }
        });

        available.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        available.setText("Not Available ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(downloadBtn)
                            .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(updateBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(addBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(33, 33, 33)
                                        .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel5))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(deadlineField)
                                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(uploadBtn)
                                        .addGap(34, 34, 34)
                                        .addComponent(available, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap(62, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(jLabel2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(backBtn)
                .addGap(36, 36, 36))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(deadlineField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(uploadBtn)
                    .addComponent(available, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(downloadBtn)
                    .addComponent(updateBtn))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteBtn)
                    .addComponent(addBtn))
                .addGap(18, 18, 18)
                .addComponent(backBtn)
                .addGap(24, 24, 24))
        );

        jMenu1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Farah Z\\Desktop\\courses\\Third year 2020_2021\\OOP2\\Project\\SISProject\\src\\Assests\\settings-icon-14968.png")); // NOI18N
        jMenu1.setText("Assignment");

        refreshItem.setText("Refresh List");
        refreshItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshItemActionPerformed(evt);
            }
        });
        jMenu1.add(refreshItem);

        deleteItem.setText("Delete Selected");
        deleteItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteItemActionPerformed(evt);
            }
        });
        jMenu1.add(deleteItem);

        downloadItem.setText("Download Studnet Doc");
        downloadItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                downloadItemActionPerformed(evt);
            }
        });
        jMenu1.add(downloadItem);

        updateItem.setText("UpdateSelected");
        updateItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateItemActionPerformed(evt);
            }
        });
        jMenu1.add(updateItem);

        addItem.setText("Add new");
        addItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addItemActionPerformed(evt);
            }
        });
        jMenu1.add(addItem);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void deleteBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteBtnMouseClicked
       
        if(repo.deleteAssigment(selected) == 1)
            JOptionPane.showMessageDialog(null,"Assignment deleted successfuly");
            
        else
             JOptionPane.showMessageDialog(null,"Unable to delete please try again");
    }//GEN-LAST:event_deleteBtnMouseClicked

    private void downloadBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_downloadBtnMouseClicked
        
        courseRepo courseRepo = new courseRepo();
        JFrame f=new JFrame();   
        String name=JOptionPane.showInputDialog(f,"Enter File path");
        int k;
        try {
            k = repo.downloadAll(m.getStudentDoc(), name);
            if ( k== -1)
        {
            JOptionPane.showMessageDialog(null,"Please enter a valid path");
        }
        } catch (IOException ex) {
            Logger.getLogger(assignmentsForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_downloadBtnMouseClicked

    private void uploadBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_uploadBtnMouseClicked

        courseRepo courseRepo = new courseRepo();
        JFrame f=new JFrame();   
        String name=JOptionPane.showInputDialog(f,"Enter File path");
        if ( m.getName() == null)
        {
            m.setName(this.nameField.getText());
        }
            
        String k = repo.setInstructorDoc(m, name,courseRepo.getCourseByID(idCourse).getName() );
        if ( k != null)
        {
             available.setText("Available");
             m.setInstructorDoc(k);
        }
        else 
            JOptionPane.showMessageDialog(null,"Please enter a valid path");
        
    }//GEN-LAST:event_uploadBtnMouseClicked

    private void updateBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateBtnMouseClicked
         m = repo.getMaterialByID(selected);
        m.setName(this.nameField.getText());
        m.setDeadline(this.deadlineField.getText());
        m.setNotes(this.notesField.getText());
         m.setCourse(course.getCourseByID(idCourse));
        
        if(repo.updateMaterial(m) == 1)
             JOptionPane.showMessageDialog(null,"Assignment updated successfuly");
            
        else
             JOptionPane.showMessageDialog(null,"Unable to delete please try again");
    }//GEN-LAST:event_updateBtnMouseClicked

    private void addBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addBtnMouseClicked
        m = new Material();
        m.setName(this.nameField.getText());
        m.setDeadline(this.deadlineField.getText());
        m.setNotes(this.notesField.getText());
         m.setCourse(course.getCourseByID(idCourse));
        
        if(repo.addMaterial(m) == 1)
             JOptionPane.showMessageDialog(null,"Assignment added successfuly");
            
        else
             JOptionPane.showMessageDialog(null,"Unable to delete please try again");
    }//GEN-LAST:event_addBtnMouseClicked

    private void backBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backBtnMouseClicked
        instructorMainFrame main = new instructorMainFrame (logged);
        main.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backBtnMouseClicked

    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
       String selected = this.jList1.getSelectedValue();
       String[] values = selected.split("-");
       Material m = repo.getMaterialByID(Integer.parseInt(values[0]));
       this.selected = Integer.parseInt(values[0]);
       nameField.setText(m.getName());
       deadlineField.setText(m.getDeadline());
       notesField.setText(m.getNotes());
       if (m.getInstructorDoc() != null)
          this.available.setText("Available");
    }//GEN-LAST:event_jList1MouseClicked

    private void refreshItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshItemActionPerformed
        RefreshList();
    }//GEN-LAST:event_refreshItemActionPerformed

    private void deleteItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteItemActionPerformed
         if(repo.deleteAssigment(selected) == 1)
            JOptionPane.showMessageDialog(null,"Assignment deleted successfuly");
            
        else
             JOptionPane.showMessageDialog(null,"Unable to delete please try again");
    }//GEN-LAST:event_deleteItemActionPerformed

    private void downloadItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_downloadItemActionPerformed
        try {
            courseRepo courseRepo = new courseRepo();
            JFrame f=new JFrame();
            String name=JOptionPane.showInputDialog(f,"Enter File path");
            int k = repo.downloadAll(m.getStudentDoc(), name);
            if ( k== -1)
            {
                JOptionPane.showMessageDialog(null,"Please enter a valid path");
            }
        } catch (IOException ex) {
            Logger.getLogger(assignmentsForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_downloadItemActionPerformed

    private void updateItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateItemActionPerformed
        m = repo.getMaterialByID(selected);
        m.setName(this.nameField.getText());
        m.setDeadline(this.deadlineField.getText());
        m.setNotes(this.notesField.getText());
         m.setCourse(course.getCourseByID(idCourse));
        
        if(repo.updateMaterial(m) == 1)
             JOptionPane.showMessageDialog(null,"Assignment updated successfuly");
            
        else
             JOptionPane.showMessageDialog(null,"Unable to delete please try again");
    }//GEN-LAST:event_updateItemActionPerformed

    private void addItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addItemActionPerformed
        m = new Material();
        m.setName(this.nameField.getText());
        m.setDeadline(this.deadlineField.getText());
        m.setNotes(this.notesField.getText());
         m.setCourse(course.getCourseByID(idCourse));
         
        if(repo.addMaterial(m) == 1)
             JOptionPane.showMessageDialog(null,"Assignment added successfuly");
            
        else
             JOptionPane.showMessageDialog(null,"Unable to delete please try again");
    }//GEN-LAST:event_addItemActionPerformed

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
            java.util.logging.Logger.getLogger(assignmentsForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(assignmentsForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(assignmentsForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(assignmentsForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new assignmentsForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JMenuItem addItem;
    private javax.swing.JLabel available;
    private javax.swing.JButton backBtn;
    private javax.swing.JTextField deadlineField;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JMenuItem deleteItem;
    private javax.swing.JButton downloadBtn;
    private javax.swing.JMenuItem downloadItem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JList<String> jList1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField nameField;
    private javax.swing.JTextArea notesField;
    private javax.swing.JMenuItem refreshItem;
    private javax.swing.JButton updateBtn;
    private javax.swing.JMenuItem updateItem;
    private javax.swing.JButton uploadBtn;
    // End of variables declaration//GEN-END:variables
}