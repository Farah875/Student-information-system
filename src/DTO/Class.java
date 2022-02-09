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
public class Class {
    
    private int id;
    private String name;
    private ArrayList<Course> courses;
    private ArrayList<User> studentes;
    
    
    
    public Class(){}
    
    public int getID()
    {
        return this.id;
    }
    
    
    public ArrayList<Course> getCourses()
    {
        return this.courses;
    }
    
    public ArrayList<User> getStudent()
    {
        return this.studentes;
    }

    public String getName()
    {
        return this.name;
    }
    
    public void setID(int id)
    {
        this.id = id;
    }
    
    public void setCourses(ArrayList<Course> course)
    {
        this.courses=course;
    }
    


    public void setName ( String name )
    {
        this.name = name;
    }
    
    public void setStudent(ArrayList<User> std)
    {
        this.studentes = std;
    }
   
    
    
}
