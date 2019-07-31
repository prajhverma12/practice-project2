<%-- 
    Document   : index
    Created on : Dec 12, 2016, 2:44:50 PM
    Author     : Prajwal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script>
            function getstate()
            { 
                
            }
        </script>
    </head>
    <body>
        <h1>Hello World!</h1>
       
            <form>
                Name : <input type="text" name="name">
                Last Name : <input type="text" name="lname">
                <input type="submit" value="submit" name="submit">
            </form>
            
        <jsp:useBean id="obj" class="BeanDemo" />
        <jsp:setProperty name="" property="" param=""/>
        <jsp:setProperty name="" property="" param=""/>
        
        <jsp:getProperty name="" property=""/>
        <jsp:getProperty name="" property=""/>
    </body>
</html>
