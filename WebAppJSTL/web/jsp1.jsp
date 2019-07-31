<%-- 
    Document   : jsp1
    Created on : Dec 21, 2016, 4:50:27 AM
    Author     : Prajwal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html>
<sql:setDataSource driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/wtp16kiit" user="root" password="password"/>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form>
            <h3>Select id to update record </h3>
            <sql:query sql="select login_id from student_info" var="result"/>
            <select name="id" id="id" onsubmit="form.submit()">
                <core:if test="${param.id != null}">
                    <option selected="true"><core:out value="${param.id}"/></option>
                </core:if>
                <core:forEach var="data" items="${result.rows}">
                    <option id="id"><core:out value="${data.login_id}"/></option>
                </core:forEach>
            </select>
        </form>
    <center>
        <h1><core:out value="hello"/><core:out value="${param.id}"/></h1>
    </center>
    </body>
</html>
