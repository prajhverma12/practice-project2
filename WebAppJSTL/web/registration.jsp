<%-- 
    Document   : registration
    Created on : Dec 26, 2016, 8:56:47 PM
    Author     : Prajwal
--%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript">
            fuction getstate()
            {
                var xhttp = new XMLHttpRequest();
                var country = document.getElementById("country").value ;
                xhttp.open("GET","getstates.jsp?country="+country,true);
                xhttp.send();
                xhttp.onreadystatechange = fuction(){
                  var listState = document.getElementById("state");
                  listState.options.length = 0 ;
                  if(xhttp.status === 200 && xhhtp.readyState === 4)
                  {
                      var s = xhttp.responseText ;
                      var state = s.trim().split(":");
                      alert(state);
                      for(var i = 0;i<state.length;i++)
                      {
                          var opt = new Option(state[i],state[i]);
                          listState.append(opt);
                      }
                  }
                };
            }
            
        </script>
    </head>
    <body>
        <%
            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/task","root","password");
                PreparedStatement pst = con.prepareStatement("select * from country");
                ResultSet rs = pst.executeQuery();
        %>
        <center>
            <h1>Registration Form</h1><br><br>
        <form>
            User Name : <input type="text" name="uname" id="uname"/><br><br>
            Email Address : <input type="email" name="email" id="email"/><br><br>
            Contact no : <input type="text" name="contact" id="contact"/><br><br>
            Country : <select name="country" id="country" onchange="getstate()">
                <option><----Country----></option>
                <%
                    while(rs.next())
                    {
                %>
                <option><% out.println(rs.getString(1)); %></option>
                <%  }
                 }
                 catch(Exception e)
                 {
                    System.out.println(e);
                 }
                %>
            </select>
            <br><br>
            State : <select name="state" id="state" onchange="getcity()">
                <option><----state----></option>
                </select>
            <br><br>
            
            
            <input type="submit" value="Register" name="submit">
        </form>
        </center>
    </body>
</html>
