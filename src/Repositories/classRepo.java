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

import DTO.Class;
import Helpers.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;


public class classRepo {
    
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    PreparedStatement ps = null;
    userRepo userRep = new userRepo();
    courseRepo courseRepo = new courseRepo();
    
    public classRepo()
    {
        con = ConnectionManager.getConnection();
    }
    
    
    public Class getClassByID(int id)
    {
        Class Class = new Class();
        try{
            ps= con.prepareStatement("Select * from class where id = ?");
            ps.setInt(1,id);
            rs = ps.executeQuery();
            if(rs.next())
            {
                Class = extractRawData(rs);
                
            }
            return Class;
        }
        catch(SQLException e)
        {
            System.out.println("Error form extracting class by id "+e);
        }
        return null;
    }       
    
    
    public  ArrayList<Class> getAllClasses()
    {
            ArrayList<Class> classes = new ArrayList<Class>();
            
        try{
             stmt = con.createStatement();
             rs= stmt.executeQuery("SELECT * FROM class" );
            while(rs.next())
            {
                classes.add(extractRawData(rs));
                
            }
            return classes;
        }
        catch(SQLException e)
        {
            System.out.println("Error form get all subject: "+e);
        }
        return null;
    }
    

    
    public int addClass(Class classValue){
        try{
            
            ps=con.prepareStatement("insert into class(name)"
                    + " values(?) ");
            ps.setString(1, classValue.getName());;
            
            
            int i = ps.executeUpdate();
            if (i== 1)
            return 0;
            
            
            
        }catch(SQLException e)
        {
            System.out.println("Error form add subject: "+e);
        }
        return -1;
    }
    
    public int updateClass(Class classValue){
        try{
            
            ps=con.prepareStatement("update class set  name=?"
                    + " where id = ?");
            ps.setString(1, classValue.getName());;
            ps.setInt(2, classValue.getID());
            int i = ps.executeUpdate();
            if (i== 1)
            return 0;
            
            
            
        }catch(SQLException e)
        {
            System.out.println("Error form update subject: "+e);
        }
        return -1;
    }
    
    
    public int deleteClass(int id)
    {
        try{
            
            stmt = con.createStatement();
             int i  = stmt.executeUpdate("delete from class where id = "+id);
            if(i == 1)
            {
                return 0;
            }
            
            
        }catch(SQLException e)
        {
            System.out.println("Error form delete subject: "+e);
        }
        return -1;
    }

    
    private Class extractRawData(ResultSet rs)
    {
        Class Class = new Class();
        courseRepo repoC = new courseRepo();
        userRepo repoU = new userRepo();
        try{
            Class.setID(rs.getInt("id"));
            Class.setName(rs.getString("name"));
            Class.setCourses(repoC.getAllCoursesByClass(Class.getID()));
            Class.setStudent(repoU.getAllStudentsByClass(Class.getID()));
                 return Class;
           

        }
        catch(SQLException e)
        {
            System.out.println("Error form extracting subject data "+e);
        }
        return null;
    }
    
}
