/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.ArrayList;


/**
 *
 * @author Farah Z
 */
public class Course {
    
    private int id;
    private String name;
    private ArrayList<Material> assigments = new ArrayList<Material>();
    private ArrayList<Exam> exams = new ArrayList<Exam>();
    private User teacher;
    private String time;
    private int idClass;
    
    
    public Course(){
        
    }
    
    public int getID()
    {
        return this.id;
    }
    
    public String getName()
    {
        return this.name;
    }
     
    public int getClassID()
    {
        return this.idClass;
    }
    
    
    public ArrayList<Material> getAssigments()
    {
        return this.assigments;
    }
    
    
    public ArrayList<Exam> getExams()
    {
        return this.exams;
    }
    
    public User getTeacher()
    {
        return this.teacher;
    }
    
    public String getTime()
    {
        return this.time;
    }
            
    public void setID(int id)
    {
        this.id = id;
    }
    
        public void setTeacher( User teacher)
    {
        this.teacher = teacher;
    }
        
    public void setClass( int id )
    {
        this.idClass = id;
        
    }
    
    
    public void setTime ( String time)
    {
        this.time = time;
    }
    
    public void setName(String name)
    {
        this.name= name;   
    }
    
    
    public void setAssigment( Material m)
    {
        this.assigments.add(m);
    }

    
    public void setExam(Exam e)
    {
        this.exams.add(e);
    }
    
    
}
