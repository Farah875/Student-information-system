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
public class ExamsTaken {
    
    
    private int id;
    private User student;
    private Exam exam;
    private Double grade;
    
    public ExamsTaken(){}
    
     public int getID()
    {
        return this.id;
    }
     
    public User getStudent()
    {
        return this.student;
    }
    
    public Exam getExam()
    {
        return this.exam;
    }
    
    public Double getGrade()
    {
        return this.grade;
    }
    
      
    public void setID(int id)
    {
        this.id = id;
    }
          
    public void setStudent( User std)
    {
        this.student = std;
    }
    
    public void setExam( Exam e)
    {
        this.exam = e;
    }
    
    public void setGrade(Double grade)
    {
        this.grade = grade;
        
    }
    
}
