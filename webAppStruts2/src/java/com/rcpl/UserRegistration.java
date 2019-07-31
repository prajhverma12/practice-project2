
package com.rcpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class UserRegistration 
{
    public boolean Registration(Student_info ob)
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wtp16kiit","root","password");
            PreparedStatement pst = con.prepareStatement("insert into login values(?,?,?)");
            pst.setString(1, ob.getLogin_id());
            pst.setString(2, ob.getPass());
            pst.setString(3, ob.getType());
            int status = pst.executeUpdate();
            pst = con.prepareStatement("insert into student_info values(?,?,?,?)");
            pst.setString(1, ob.getLogin_id());
            pst.setString(2, ob.getName());
            pst.setString(3, ob.getAddress());
            pst.setString(4, ob.getEmail());
            int status1 = pst.executeUpdate();
            if(status >0 && status1 > 0)
            {
                return true;
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return false ;
    }
    
}
