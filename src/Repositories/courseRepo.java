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



import DTO.Course;
import DTO.User;
import Helpers.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;


public class courseRepo {
    
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    PreparedStatement ps = null;
    
    public courseRepo()
    {
        con = ConnectionManager.getConnection();
    }
    
    public Course getCourseByID(int id)
    {
        Course c = new Course();
        try{
            ps= con.prepareStatement("Select * from course where id = ?");
            ps.setInt(1,id);
            rs = ps.executeQuery();
            if(rs.next())
            {
                c = extractRawData(rs);
            }
            System.out.println(c.toString());
            return c;
        }
         catch(SQLException e){
            System.out.println("Error from get course by id: "+e);
            return null;
        }
        
    }
    
    
     public  ArrayList<Course> getAllCourses()
    {
            ArrayList<Course> courses = new ArrayList<Course>();
            
        try{
             stmt = con.createStatement();
             rs= stmt.executeQuery("SELECT * FROM course" );
            while(rs.next())
            {
                courses.add(extractRawData(rs));
                
            }
            return courses;
        }
        catch(SQLException e)
        {
            System.out.println("Error form get all course"+e);
            return null;
        }
        
    }
     
     
     public  ArrayList<Course> getAllCoursesByType(User user )
    {
            ArrayList<Course> courses = new ArrayList<Course>();
            
            if (user.getType() == 1)
            courses = getAllCoursesInstructor(user.getID());

            else{
                
                int idClass = user.getClassID();
                classRepo enrolled = new classRepo();
                System.out.println(idClass);
                courses = enrolled.getClassByID(idClass).getCourses();
               
            }
                 return courses;
    }
     
     
      public  ArrayList<Course> getAllCoursesInstructor(int id)
    {
        ArrayList<Course> courses = new ArrayList<Course>();
            
        try{
             stmt = con.createStatement();
             rs= stmt.executeQuery("SELECT * FROM course where idTeacher = "+id );
            while(rs.next())
            {
                courses.add(extractRawData(rs));
                
            }
            return courses;
        }
        catch(SQLException e)
        {
            System.out.println("Error from get all courses by instructor: "+e);
        }
        return null;
    }
      
    public ArrayList<Course> getAllCoursesByClass(int id) {
        
         ArrayList<Course> courses = new ArrayList<Course>();
            
        try{
             stmt = con.createStatement();
             rs= stmt.executeQuery("SELECT * FROM course where idClass = "+id );
            while(rs.next())
            {
                courses.add(extractRawData(rs));
                
            }
            return courses;
        }
        catch(SQLException e)
        {
            System.out.println("Error from get coursesby class "+e);
        }
        return null;
    }
    
    public int addCourse(Course c)
    {
        try{
            ps=con.prepareStatement("insert into course(name,time,idTeacher,idClass) "
                    + " values(?,?,?,?)");
            ps.setString(1, c.getName());
            ps.setString(2,c.getTime());
            ps.setInt(3,c.getTeacher().getID());
            ps.setInt(4, c.getClassID());
            
            int i = ps.executeUpdate();
            if(i == 1)
            return 1;
            
        }catch(SQLException e)
        {
            System.out.println("Error form add course "+e);
        }
        return -1;
        
    }
    
    public int assignClass(Course c, int id)
    {
        try{
             ps=con.prepareStatement("update course set idClass = ? "
                    + " where id = ?");
            ps.setInt(1, id);
            ps.setInt(2,c.getID());
            
            int i = ps.executeUpdate();
            if(i == 1)
            return 0;
            
        }catch(SQLException e)
        {
            System.out.println("Error form assign class "+e);
        }
        return -1;
        
    }
    
     public int unAssignClass(int id)
    {
        try{
             ps=con.prepareStatement("update course set idClass = ? "
                    + " where id = ?");
            ps.setInt(1, id);
            
            int i = ps.executeUpdate();
            if(i == 1)
            return 0;
            
        }catch(SQLException e)
        {
            System.out.println("Error form assign class "+e);
        }
        return -1;
        
    }
    
    public int updateCourse(Course c)
    {
        try{
            ps=con.prepareStatement("update course set name=?,time=?,idTeacher=?, "
                    + " idClass=?  where id = ?");
            ps.setString(1, c.getName());
            ps.setString(2,c.getTime());
            ps.setInt(3,c.getTeacher().getID());
            ps.setInt(4,c.getClassID());
            ps.setInt(5,c.getID());
            int i = ps.executeUpdate();
            if(i == 1)
            return 1;
            
        }catch(SQLException e)
        {
            System.out.println("Error form update course "+e);
        }
        return -1;
        
    }
    
    public int deleteCourse(int id)
    {
        try{
            stmt = con.createStatement();
            int i = stmt.executeUpdate("delete from course where id = "+id);
            if(i == 1)
            return 1;
            
        }catch(SQLException e)
        {
            System.out.println("Error form delete course "+e);
        }
        return -1;
    }

    private Course extractRawData(ResultSet rs)
    {
        Course c = new Course();
        userRepo user = new userRepo();
        
        try{
            c.setID(rs.getInt("id"));
            c.setName(rs.getString("name"));
            c.setTeacher(user.getUserByID(rs.getInt("idTeacher")));
            c.setTime(rs.getString("time"));
            c.setClass(rs.getInt("idClass"));
            
            return c;
        }
        catch(SQLException e){
            System.out.println("Error from extract data of course: "+e);
        }
        return null;
    }

  

    
}
