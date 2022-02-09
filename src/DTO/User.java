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
public class User {
    private int id;
    private String username;
    private String email;
    private String firstname;
    private String lastname;
    private  int type;       
    private String password;
    private String phone;
    private String subjectsList;
    private int idClass;
   private ArrayList<Course> courses = new ArrayList<Course>();
   private ArrayList<ExamsTaken> exams = new ArrayList<ExamsTaken>();
    
    public  User()
    {
        
    }
    
    
    public User (String username, String email, String firstname, String lastname, String phone, String password,int type)
    {
        this.type = type;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone= phone;
        this.email = email;
    }
    
    
    public User (String username, String email, String firstname, String lastname,String phone, String password)
    {
        this.type = 2;
        this.username = username;
        this.firstname = firstname;
        this.phone= phone;
        this.lastname = lastname;
        this.email = email;
    }
    
    public ArrayList<Course> getSubjects()
    {
        return this.courses;
    }
    
    public ArrayList<ExamsTaken> getExams()
    {
        return this.exams;
    }
    
    public int getID()
    {
        return this.id;
    }
    
    public String getSubjectsList ()
    {
        return this.subjectsList;
    }
    
    public String getUsername ()
    {
        return this.username;
    }
    
    public String getFirstName()
    {
        return this.firstname;
    }
    
    public String getLastName()
    {
        return this.lastname;
    }
    
    public String getEmail()
    {
        return this.email;
    }
    
    public int getType()
    {
        return this.type;
    }
    
    public String getPhone()
    {
        return this.phone;
    }

    
    public String getPassword()
    {
        return this.password;
    }
    
    public void setID(int id)
    {
        this.id = id;
    }
    
    public void setUsername(String Username)
    {
        this.username = Username;
    }
    
    public void setExams(ArrayList<ExamsTaken> exams)
    {
        this.exams = exams;
    }
    
    public void setFirstName( String firstname )
    {
        this.firstname= firstname;
    }
    
    public void setLastName ( String lastname)
    {
        this.lastname= lastname;
    }
    
    public void setSubjects(ArrayList<Course> list)
    {
        this.courses= list;
    }
    
    public void setPhone ( String phone)
    {
        this.phone = phone;
    }
    public void setEmail( String Email)
    {
        this.email = Email;
    }
    
    public void setType(int  type)
    {
        this.type = type;
    }
    
    
    public void setSubjectList(String list)
    {
        this.subjectsList = list;
    }
    
    public void setPassword ( String Password)
    {
        this.password= Password;
    }
    
    public void Display( User u )
    {
        System.out.println("This user is: "+this.type+"With username: "+this.username+"\n"+"First name: "+this.firstname+
                "\n"+"Last name: "+this.lastname+"\n"+"Email: "+this.email+"\n");
    }

    public void setClassID(int id) {
        this.idClass = id;
    }

    public int  getClassID() {
        return this.idClass;
    }
    
}
