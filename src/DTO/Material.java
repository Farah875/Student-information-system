/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Farah Z
 */
public class Material {
    
    private int id;
    private Course course;
    private String instructorDoc;
    private String notes;
    private ArrayList<String> studentDoc = new ArrayList<String>();
    private String deadline;
    private String name;
    
    
    
    public Material()
    {
        
    }
    
    public int getID()
    {
        return this.id;
    }
    
    
    public String getName()
    {
        return this.name;
    }
    public Course getCourse()
    {
        return this.course;
    }

    
    public String getInstructorDoc(){
        return this.instructorDoc;
    }
    
    public String getNotes(){
        return this.notes;
    }
    
    public ArrayList<String> getStudentDoc(){
        return this.studentDoc;
    }
    
    public String getDeadline()
    {
        return this.deadline;
    }
    
    
     public void setID(int id)
    {
        this.id = id;
    }
    
    public void setCourse(Course id)
    {
        this.course = id;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }


    
    public void setInstructorDoc( String n)
    {
        this.instructorDoc = n;
    }
    
    public void setNotes( String n)
    {
        this.notes = n;
    }
    
    public void setStudentDoc( ArrayList<String> n )
    {
        this.studentDoc= n;
    }
    
    public void setDeadline( String d)
    {
        this.deadline = d;
    }
}
