/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helpers;

/**
 *
 * @author Farah Z
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private static final String ConnectionString = "jdbc:mysql://localhost:3305/sisproject?user=farah&password=farah0021";
    private static Connection con = null;
    public static int NumberOfOpenedConnection =0;
    
    
    public static Connection getConnection()
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            System.out.println("Driver initiated successfully");
            if( con == null || con.isClosed())
            {
                con = DriverManager.getConnection(ConnectionString);
            }
        }
        catch(Exception e )
        {
            System.out.println("Connection could not be established  "+e);
        }
        NumberOfOpenedConnection++;
        return con;
    }
    
    public static boolean IsConnectionOpened(){
       try {
           return !con.isClosed();
       }catch(SQLException e)
       {
           System.out.println(e);
       }
      return false;
    }
    
    public static void close(){
        try {
           con.isClosed();
           NumberOfOpenedConnection --;
       }catch(SQLException e)
       {
           System.out.println(e);
       }
    }
}
