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


import DTO.User;
import Helpers.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;

public class userRepo {
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    PreparedStatement ps = null;
    
    public userRepo()
    {
        con = ConnectionManager.getConnection();
    }
    
    
    public int getLastID(int  type)
    {
        try {
            stmt = con.createStatement();
           rs = stmt.executeQuery("Select MAX(id) as max from user where type = "+ type);
           if ( rs.next())
           {
              return rs.getInt("max");
                
           }
           
        }catch(SQLException e)
        {
           System.out.println("Error from the get last id" +e); 
        }
        return -1;
    }
    
    public User getUserByID(int id)
    {
        User user = null;
        try{
            ps= con.prepareStatement("Select * from user where id = ?");
            ps.setInt(1,id);
            rs = ps.executeQuery();
            if(rs.next())
            {
                user = extractRawData(rs);
                return user;
            }
            
        }
        catch( SQLException e)
        {
            System.out.println("Error from the get user by username "+ e);
        }
        return null;
    }
    
    public User getUser(String username)
    {
        User user = null;
        try{
            ps= con.prepareStatement("Select * from user where username = ?");
            ps.setString(1,username);
            rs = ps.executeQuery();
            if(rs.next())
            {
                user = extractRawData(rs);
                return user;
            }
            
        }
        catch( SQLException e)
        {
            System.out.println("Error from the get user by username "+ e);
        }
        return null;
        
    }
    
    
    public ArrayList<User> getAllUsers(int  type)
    {
        ArrayList<User> users = new ArrayList<User>();
        try{
            stmt = con.createStatement();
                rs= stmt.executeQuery("SELECT * FROM user where type = " +type );
            while( rs.next())
            {
                users.add(extractRawData(rs) );
            }
            return users;
            
        }
        catch(SQLException e)
        {
            System.out.println("Error from the get all users: "+ e);
        }
        return null;    
    }
    
    public ArrayList<User> getAllStudentsByClass(int id) {
        
        ArrayList<User> users = new ArrayList<User>();
        try{
            stmt = con.createStatement();
                rs= stmt.executeQuery("SELECT * FROM user where type = 2 and idClassStd ="+id );
            while( rs.next())
            {
                users.add(extractRawData(rs) );
            }
            return users;
            
        }
        catch(SQLException e)
        {
            System.out.println("Error from the get all users: "+ e);
        }
        return null;
        
    }
    
    
    public int addUser (User logged, User user)
    {   
        if(logged.getType() == 0)
        {
            if(user.getType() == 1 || user.getType() == 0 || user.getType() == 2)
            {
                try{
                    
                    int id = getLastID(user.getType());

                        ps=con.prepareStatement("INSERT INTO user(username,firstName,lastName,email,type,password,phone) "
                            + "VALUES (?,?,?,?,?,?,?)");
                            if((user.getType()) ==0)
                                 ps.setString(1, "adm"+id);
                            else {
                                if ((user.getType()) ==1)
                                     ps.setString(1, "ins"+id);
                                else{
                                    if((user.getType()) == 2)
                                        {
                                                ps.setString(1, "std"+id);
                                        }
                                }
                            }
                    
                        
                   
                    ps.setString(2,user.getFirstName());
                    ps.setString(3,user.getLastName());
                    ps.setString(4, user.getEmail());
                    ps.setInt(5, user.getType());
                    ps.setString(6, user.getPassword());
                    ps.setString(7, user.getPhone());
                   
                   
                   int i = ps.executeUpdate();
                   if (i== 1)
                    return 0;
                }
                catch(SQLException e)
                {
                    System.out.println("Error from the add user function: "+ e);
                }
                return 1;
            }
            else {
                System.out.println("Invalid type");
                return 2;
            }
        }
        else {
                System.out.println("you don't have enough privilages");
                return 3;
            }
  
    }
    
     public int updateUser (User logged, User user)
    {   
        if(logged.getType() == 0)
        {
            if(user.getType() == 1 || user.getType() ==0|| user.getType() ==2)
            {
                try{
                    
                    ps=con.prepareStatement("UPDATE user SET firstName=?, lastName=?, email=?,password=?,phone=?"
                            + "WHERE username= ?");
                     
                   
                    
                    ps.setString(1,user.getFirstName());
                    ps.setString(2,user.getLastName());
                    ps.setString(3, user.getEmail());
                    ps.setString(4, user.getPassword());
                    ps.setString(5, user.getPhone());
                    ps.setString(6, user.getUsername());
                   int i = ps.executeUpdate();
                   if (i== 1)
                    return 0;
                }
                catch(SQLException e)
                {
                    System.out.println("Error from the update user function: "+ e);
                    return 1;
                }
                return 0;
                
            }
            else {
                System.out.println("Invalid type");
                return 2;
            }
        }
        else {
                System.out.println("you don't have enough privilages");
                return 3;
           }
    }
    
     
     public int assigntoClass( int idStd, int idClass)
     {
         try{
                stmt = con.createStatement();
                int i = stmt.executeUpdate("UPDATE user set idClassStd = " +idClass +
                        " where id = "+idStd);
                

                   if (i== 1)
                    return 0;
                }
                catch(SQLException e)
                {
                    System.out.println("Error from the assign student user function: "+ e);
                }
                return -1;
     }
     
     public int unAssignClass( int idStd)
     {
         try{
                stmt = con.createStatement();
                int i = stmt.executeUpdate("UPDATE user set idClassStd = null "+
                        " where id = "+idStd);

                   if (i== 1)
                    return 0;
                }
                catch(SQLException e)
                {
                    System.out.println("Error from the assign student user function: "+ e);
                }
                return -1;
     }
    
     public int deleteUser(User logged, String username)
     {
         if(logged.getType() == 0)
         {
                try{
                    ps=con.prepareStatement("DELETE FROM user WHERE username = ? ");
                    ps.setString(1,username);
                    int i = ps.executeUpdate();
                    if(i == 1)
                    return 0;
                }
                catch(SQLException e)
                {
                    System.out.println("Error from the delete user function: "+ e);
                    
                }
                return 1;
         }
        else {
                System.out.println("you don't have enough privilages");
                return 3;
           }
     }
     
     
     public User login(String username, String password)
     {
             User user = getUser(username);
             if(user != null)
             {
                 System.out.println(username+password+"");
                 if(user.getPassword().equals(password))
                     return user;
             }
         return null;
     }
    
    

    private User extractRawData(ResultSet rs) {
        User user = new User();
        try{
             
            user.setID(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setFirstName(rs.getString("firstName"));
            user.setLastName(rs.getString("lastName"));
            user.setType(rs.getInt("type"));
            user.setEmail(rs.getString("email"));
            user.setPassword(rs.getString("password"));
            user.setPhone(rs.getString("phone"));
            user.setClassID(rs.getInt("idClassStd"));
            
            return user;
            
        }
         catch( SQLException e)
        {
            System.out.println("Error from the rxtarct user data "+ e);
        }
        return null;
        
    }

    
}
