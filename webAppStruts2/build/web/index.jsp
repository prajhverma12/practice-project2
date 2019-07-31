<%-- 
    Document   : index
    Created on : Dec 13, 2016, 7:54:55 PM
    Author     : Prajwal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Welcome</h1><br>
        <s:form action="firstaction">
            <s:textfield label="User Name" id="name" name="name"/>
            <s:textfield label="Login ID" id="login_id" name="login_id"/>
            <s:textfield label="Type" id="type" name="type"/>
            <s:password label="Password" id="password" name="pass"/>
            <s:textfield label="Address" id="address" name="address"/>
            <s:textfield label="Email ID" id="email" name="email"/>
            <s:submit/>
        </s:form>
        ${requestScope.msg}
    </body>
</html>
