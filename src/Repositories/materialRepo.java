/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositories;



/**
 *
 * @author Farah Z
 */
import DTO.Material;
import FileTransfer.FileClient;
import Helpers.ConnectionManager;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class materialRepo {
    
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    PreparedStatement ps = null;
    userRepo userRep = new userRepo();
    courseRepo courseRepo = new courseRepo();
    
    public materialRepo ()
    {
         con = ConnectionManager.getConnection();
    }
    
    public Material getMaterialByID(int id )
    {
        try{
            Material m = new Material();
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM material WHERE id= "+id);
            if(rs.next())
            {
                m = executeRawData(rs);
            }
            return m;
        }
        catch (SQLException e){
            System.out.println("Error form get material by id " +e);
        }
        return null;
    }
    
    public ArrayList<Material> getAllMaterial()
    {
        ArrayList<Material> material = new ArrayList<Material>();
        try{
            
            stmt = con.createStatement();
            rs = stmt.executeQuery("Select * from material");
            while ( rs.next())
            {
                material.add(executeRawData(rs));
            }
            return material;
            
        } catch (SQLException e){
            System.out.println("Error form get all material: " +e);
        }
        return null;
    }
    
    public ArrayList<Material> getAllMaterialByCourse(int idCourse)
    {
        ArrayList<Material> material = new ArrayList<Material>();
        try{
            
            stmt = con.createStatement();
            rs = stmt.executeQuery("Select * from material where idCourse= "+idCourse);
            while ( rs.next())
            {
                material.add(executeRawData(rs));
            }
            return material;
            
        } catch (SQLException e){
            System.out.println("Error form get all material: " +e);
        }
        return null;
    }
    
    
    public int addMaterial(Material m)
    {
        try{
                ps= con.prepareStatement("INSERT INTO material(idCourse,name , notes, deadline, instructorDoc) "
                        + " VALUES(?,?,?,?,?)");
                ps.setInt(1,m.getCourse().getID());
                ps.setString(2, m.getName());
                ps.setString(3, m.getNotes());
                ps.setString(4, m.getDeadline());
                ps.setString(5,m.getInstructorDoc());

                int i = ps.executeUpdate();
                if (i==1) return 1;

            
            
        }catch (SQLException e){
            System.out.println("Error form add  material: " +e);
        }
        return -1;
    }
    
    
    public int updateMaterial(Material m)
    {
        try {

                    ps= con.prepareStatement("update material set name=?, instructorDoc =? ,notes=?, deadline=? "
                            + " where id =?");
                    ps.setString(1, m.getName());
                    ps.setString(2, m.getInstructorDoc());
                    ps.setString(3, m.getNotes());
                    ps.setString(4, m.getDeadline());
                    ps.setInt(5, m.getID());
                  
                    int i = ps.executeUpdate();
                    if (i==1) return 1;
          
            
            
        }catch (SQLException e){
            System.out.println("Error form update  material: " +e);
        }
        return -1;
    }
    
    
    public int deleteAssigment( int id)
    {
         try {
                  stmt = con.createStatement();
                  int i = stmt.executeUpdate("DELETE FROM material WHERE id =" +id);
                  if (i==1) return 1;

            
            
        }catch (SQLException e){
            System.out.println("Error form delete material: " +e);
        }
        return -1;
    }
    
    public String setInstructorDoc(Material m, String filePath, String course)
    {
//        String fileComb = course+m.getName()+".pdf";
//        String dest = "C:\\Users\\Farah Z\\Desktop\\courses\\"
//                + "Third year 2020_2021\\OOP2\\Project\\SISProject\\"
//                + "src\\FileTransfer\\assigments\\instructorDocs\\"+fileComb;
        
        File file = new File(filePath);
       String dest = file.getName();
        int k;
        try {
            FileClient f = new FileClient();
            f.runClient(1,filePath,null);
            //f.runClient(3,null,null);
//            f.start(3,null, null);

            
        return dest;
        } catch (IOException ex) {
            Logger.getLogger(materialRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
       return null;
    }
    
    public int downloadAll(ArrayList<String> assignments, String filePath) throws IOException
    {
        int k;
        for (String s : assignments)
        {
            try {
                FileClient.runClient(2,s, filePath);
                FileClient.runClient(3,null , null);
                 return 1;
            } catch (IOException ex) {
                Logger.getLogger(materialRepo.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
       // FileClient.start(3,null,null);
        return 1 ;
    }
    
    
    public int addAssignment(int idM , String filePath, String username)
    {
        try {
//            String file = username+".docx";
//            String dest = "C:\\Users\\Farah Z\\Desktop\\courses\\"
//                    + "Third year 2020_2021\\OOP2\\Project\\SISProject\\"
//                    + "src\\FileTransfer\\assigments\\instructorDocs\\"+file;
            FileClient.runClient(1,filePath,null);
            FileClient.runClient(3,null,null);
                
            File file = new File(filePath);
       String dest = file.getName();
            
            try {
                
                
                ps = con.prepareStatement("insert into stdAssigment(document,idMaterial)"
                        + " values (?,?_");
                ps.setString(1, dest);
                ps.setInt(2, idM);
                
                int i = ps.executeUpdate();
                if (i==1) return 1;
                
                
                
            }catch (SQLException e){
                System.out.println("Error form add  assigment: " +e);
            }
            
        }catch (IOException ex){
            Logger.getLogger(materialRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    
    public int getInstructorDoc(int idM,String filePath )
    {
        try {
            String s = getMaterialByID(idM).getInstructorDoc();
            
            FileClient.runClient(2,s,filePath);
            return 1;
        } catch (IOException ex) {
            System.out.println("Exception from get instructir doc: "+ex);
        }
       return -1;
    }
    
    private ArrayList<String> getStudentsDoc (int id)
    {
        ArrayList<String> documents = new ArrayList<String>();
        try{
            stmt = con.createStatement();
            rs = stmt.executeQuery("Select * from stdAssigment where idMaterial = "+id);
            while (rs.next())
            {
                documents.add(rs.getString("document"));
            }
            return documents;
        }
        catch(SQLException e ){
            System.out.println("Error in get students documents");}
        return null;
    }

    private Material executeRawData(ResultSet rs) {
        Material m = new Material();
        courseRepo repoC = new courseRepo();
        userRepo repoStd = new userRepo();
        
        try{
            m.setID(rs.getInt("id"));
            m.setName(rs.getString("name"));
            m.setNotes(rs.getString("notes"));
            m.setInstructorDoc(rs.getString("instructorDoc"));
            m.setCourse(repoC.getCourseByID(rs.getInt("idCourse")));
            m.setDeadline(rs.getString("deadline"));
            
            
            return m;
        }
        catch(SQLException e )
        {
            System.out.println("Error from execute raw data from material "+e);
        }
        return null;
    }
    
}
