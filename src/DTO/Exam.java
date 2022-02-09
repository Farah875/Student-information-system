/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Farah Z
 */
public class Exam {
    
    private int id;
    private Course course;
    private String date;
    private String name;
    
    
    public Exam(){
        
    }
    
    public int getID()
    {
        return this.id;
    }
    
    public Course getCourse()
    {
        return this.course;
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public String getDate()
    {
        return this.date;
    }
    
    public void setID(int id)
    {
        this.id = id;
    }
    
    public void setCourse(Course c)
    {
        this.course = c;
    }
    
    public void setName (String name)
    {
        this.name = name;
    }
    
    public void setDate( String date )
    {
        this.date = date ;
    }
}
