/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rcpl;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author Prajwal
 */
public class jdbctest 
{
    public static void main( String []args)
    {
        Connection con = null ;
        int op ;
        
        do
        {
            System.out.println("1.Registration");
            System.out.println("2.Update");
            System.out.println("3.Delete");
            System.out.println("4.Select All");
            System.out.println("5.EXIT");
            System.out.println("Enter the number for the operation you want to do");
            Scanner sc1 = new Scanner(System.in);
            op = Integer.parseInt(sc1.next());
            switch(op)
            {
                case 1 : 
                    String std_id = null ;
                    String pass = null ;
                    String type = null ;
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Enter user id");
                    std_id = sc.next() ;
                    System.out.println("Enter Password");
                    pass = sc.next();
                    System.out.println("Enter type admin/student");
                    type = sc.next();
                    System.out.println("Enter name");
                    String name = sc.next();
                    System.out.println("Enter Address");
                    String address = sc.next();
                    System.out.println("Enter email");
                    String mail = sc.next();
                    try
                    {
                        Class.forName("com.mysql.jdbc.Driver");
                        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wtp16kiit","root","password");
                        con.setAutoCommit(false);
                        PreparedStatement pst = con.prepareStatement("insert into login values(?,?,?)"); //? is the placeholder.
                        pst.setString(1,std_id);
                        pst.setString(2, pass);
                        pst.setString(3,type);
                        
                        //String query = "insert into login values('"+std_id+"','"+pass+"','"+type+"')";
                        //System.out.println(query);
                        //String query1 = "insert into student_info values('"+std_id+"','"+name+"','"+address+"','"+mail+"')";
                        //System.out.println(query1);
                        int status = pst.executeUpdate();
                        pst = con.prepareStatement("insert into student_info values(?,?,?,?)");
                        pst.setString(1,std_id);
                        pst.setString(2,name);
                        pst.setString(3,address);
                        pst.setString(4,mail);
                        int status1 = pst.executeUpdate();
                        if(status > 0 && status1 > 0)
                        {
                            con.commit();
                            System.out.println("Registration Sucessful");
                        }
                        else 
                        {
                            con.rollback();
                            System.out.println("Registrstion Unsucessful");
                        }
                        if(con != null)
                        {
                        } else {
                            System.out.println("Connection ok");
                }
                    }
                    catch(Exception e)
                    {
                        
                        System.out.println(e);
                    }
                    finally
                    {
                        try
                        {
                            if(con!=null)
                            con.setAutoCommit(true);
                            con.close();
                        }
                        catch(Exception e)
                        {
                            System.out.println("Connection error"+e);
                        }
                    }; 
                    break ;
                case 2 :
                    Scanner scu = new Scanner(System.in);
                    System.out.println("Please enter the the student id for which you have to change password");
                    std_id = scu.next();
                    System.out.println("Enter the new Password");
                    pass = scu.next() ;
                    
                    
                    
                    try
                    {
                        Class.forName("com.mysql.jdbc.Driver");
                        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wtp16kiit","root","password");
                        PreparedStatement pst = con.prepareStatement("update login set password =? where login_id =?");
                        pst.setString(1, pass);
                        pst.setString(2, std_id);
                        int status = pst.executeUpdate();
                        if(status > 0)
                        {
                            System.out.println("Password changed Suceesfully");
                        }
                        else
                        {
                            System.out.println("The login id didnt match. Please try again.");
                        }
                    }
                    catch(Exception e)
                    {
                        System.out.println(e);
                    }
                      break ;
                case 3 :
                    Scanner scd = new Scanner(System.in);
                    System.out.println("Please enter the login id you want to delete");
                    std_id = scd.next();
                     
                    try
                    {
                        Class.forName("com.mysql.jdbc.Driver");
                        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wtp16kiit","root","password");
                        PreparedStatement pst = con.prepareStatement("delete from login where login_id =? ");
                        pst.setString(1, std_id);
                        int status = pst.executeUpdate();
                        if(status > 0)
                        {
                            System.out.println("Deletion Sucessful");
                        }
                        else
                        {
                            System.out.println("Login id not found.Please try again");
                        }
                        
                    }
                    catch(Exception e){System.out.println(e);}
                    break ;
                case 4 :
                    try
                    {
                        Class.forName("com.mysql.jdbc.Driver");
                        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wtp16kiit","root","password");
                         PreparedStatement pst = con.prepareStatement("select *from login");
                        ResultSet rs = pst.executeQuery();
                        while(rs.next())
                        {
                            System.out.print(rs.getString(1));
                            System.out.print("    "+rs.getString(2));
                            System.out.println("    "+rs.getString(3));
                        }
                        if(con != null){
                        System.out.println("Connection ok");}
            
                    }
                    catch(ClassNotFoundException | SQLException e)
                    {
                        System.out.println(e);
                    }
                    break ;
                case 5 :
                    break;
                default : System.out.println("Enter valid option");
            }
        }while(op != 5);
          
    }
}







/*try{
                        Class.forName("com.mysql.jdbc.Driver");
                        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wtp16kiit","root","password");
                        CallableStatement cst = null ;
                        cst = (CallableStatement) con.prepareCall("{call myprodedure(?)}");
                        //cst.setString(1, );
                        ResultSet rs = cst.executeQuery();
                        while(rs.next())
                        {
                            System.out.print(rs.getString(1));
                            System.out.print("    "+rs.getString(2));
                            System.out.println("    "+rs.getString(3));
                        }
                         
                    }
                    catch(Exception e)
                    {
                    }*/