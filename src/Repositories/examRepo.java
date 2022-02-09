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


import DTO.Exam;
import DTO.ExamsTaken;
import DTO.User;
import Helpers.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;


public class examRepo {
    
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    PreparedStatement ps = null;

    public examRepo ()
    {
        con = ConnectionManager.getConnection();
    }

    public Exam getExamByID(int id )
    {
        Exam exam = new Exam();
        try{
            stmt = con.createStatement();
            rs = stmt.executeQuery("Select * from exam where id = "+id);
            if(rs.next())
            {
                exam = extractRawData(rs);
            } 
            
            return exam;
            
            
        }catch(SQLException e)
        {
            System.out.println("Error from get exam by id: "+e);
        }
        return null;
    }
    
    public ArrayList<Exam> getExamsByCourse( int idCourse )
    {
        ArrayList<Exam> exams = new ArrayList<Exam>();
        try{
            stmt = con.createStatement();
            rs = stmt.executeQuery("Select * from exam where idCourse = "+idCourse);
            while(rs.next())
            {
                exams.add(extractRawData(rs));
            } 
            
            return exams;
            
            
        }catch(SQLException e)
        {
            System.out.println("Error from get all exams by course: "+e);
        }
        return null;
    }
    
    public int addExam (Exam exam)
    {
        try{
            
            ps = con.prepareStatement("insert into exam(name,idCourse,dateExam)"
                    + " values(?,?,?)");
            ps.setInt(2, exam.getCourse().getID());
            ps.setString(1, exam.getName());
            ps.setString(3,exam.getDate());
            
            int i = ps.executeUpdate();
            if (i == 1 ) return 1;
                    
            
        }catch(SQLException e)
        {
            System.out.println("Error from add exam: "+e);
        }
        return -1;
    }
    
     public int updateExam (Exam exam)
    {
        try{
            
            ps = con.prepareStatement("update exam set name=?, dateExam=? ");
            ps.setString(1, exam.getName());
            ps.setString(2,exam.getDate());
            
            int i = ps.executeUpdate();
            if (i == 1 ) return 1;
                    
            
        }catch(SQLException e)
        {
            System.out.println("Error from update exam: "+e);
        }
        return -1;
    }
       

    public int deleteExam ( int id )
    {
        try{
            stmt = con.createStatement();
            int i = stmt.executeUpdate("delete from exam where id = "+id);
            if (i == 1 ) return 1;
                    
            
        }catch(SQLException e)
        {
            System.out.println("Error from delete exam: "+e);
        }
        return -1;
    }
    
    
    public int assignGrade( int idExam, int idStd, double grade)
    {   
        
         try{
             stmt = con.createStatement();
             rs = stmt.executeQuery("Select * from examstaken where idStudent = "+idStd
             +" and idExam = "+idExam);
             if(rs.next())
             {
                 ps= con.prepareStatement("update examstaken set grade = ?");
                 ps.setDouble(1, grade);
             }
             else{
                 ps = con.prepareStatement("insert into examstaken(idExam, idStudent, grade)"
                    + " values(?,?,?)");
                ps.setInt(2, idStd);
                ps.setInt(1, idExam);
                ps.setDouble(3, grade);
             }
            
            
            
            int i = ps.executeUpdate();
            if (i == 1 ) return 1;
                    
            
        }catch(SQLException e)
        {
            System.out.println("Error from assign grade: "+e);
        }
        return -1;
    }
    
    
    public ExamsTaken getExamTaken(int idStudnet, int exam)
    {
        try{
            ExamsTaken e = new ExamsTaken();
            stmt = con.createStatement();
            rs = stmt.executeQuery("Select * from examstaken where idStudent = "
                    +idStudnet+" and idExam = "+exam);
            
            if( rs.next())
            {
                e =extractExamTaken(rs);
            }
            return e;
        }
        catch(SQLException e)
        {
            System.out.println("Error from get exams taken: "+e);
        }
        return null;
    }
    
    public ArrayList<ExamsTaken> getExamsTakenByStudnet (User std)
    {
        ArrayList<ExamsTaken> exams = new ArrayList<ExamsTaken>();
        try{
            
            stmt = con.createStatement();
            rs = stmt.executeQuery("Select * from examstaken where idStudent = "+std.getID());
            
            while ( rs.next())
            {
                exams.add(extractExamTaken(rs));
            }
            return exams;
        }
        catch(SQLException e)
        {
            System.out.println("Error from get exams taken: "+e);
        }
        return null;
    }
        

    private Exam extractRawData(ResultSet rs) {
        
        Exam exam = new Exam();
        courseRepo course = new courseRepo();
        try{
            
            exam.setID(rs.getInt("id"));
            exam.setCourse(course.getCourseByID(rs.getInt("idCourse")));
            exam.setName(rs.getString("name"));
            exam.setDate(rs.getString("dateExam"));
            
            return exam;
            
            
        }catch(SQLException e)
        {
            System.out.println("Error from extarct raw data of exam : "+e);
        }
        return null;
    }

    private ExamsTaken extractExamTaken(ResultSet rs) {
            
         ExamsTaken  exam = new ExamsTaken();
         userRepo user = new userRepo();
         
         
        try{
            
            exam.setID(rs.getInt("id"));
            exam.setGrade(rs.getDouble("grade"));
            exam.setStudent(user.getUserByID(rs.getInt("idStudent")));
            exam.setExam(this.getExamByID(rs.getInt("idExam")));
            
            return exam;
            
            
        }catch(SQLException e)
        {
            System.out.println("Error from extarct raw data of exams taken  : "+e);
        }
        return null;
        
    }
    
    
}
