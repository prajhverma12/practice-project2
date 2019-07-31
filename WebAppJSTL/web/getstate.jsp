<%-- 
    Document   : getstate
    Created on : Dec 27, 2016, 1:47:35 PM
    Author     : Prajwal
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String country = request.getParameter("country");
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/task","root","password");
            PreparedStatement pst = con.prepareStatement("select * from states where country= ?");
            pst.setString(1,country);
            ResultSet rs = pst.executeQuery();
            String state = "";
            while(rs.next())
            {
                state = state + ":" + rs.getString(1);
            }
            out.print(state);
        %>
    </body>
</html>
