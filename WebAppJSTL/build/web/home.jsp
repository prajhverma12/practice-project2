<%-- 
    Document   : index
    Created on : Dec 11, 2016, 11:47:39 AM
    Author     : sony
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
            <h3>Select id to update record</h3>
        <sql:query sql="select login_id from student_info" var="result"/>
        <select id="id" onchange="form.submit()">
            <core:if test="${param.id ne null}">
                <option selected="true"><core:out value="${param.id}"/>
                </option>
            </core:if>
            <core:forEach var="data" items="${result.rows}">
               <option><core:out value="${data.login_id}"/></option>
              </core:forEach>
                    </select>
        
        </form>
    <center>
        <sql:query sql="select * from student_info where login_id='${param.id}'" var="result1" />
        <form>
        <core:forEach var="data1" items="${result1.rows}">
            User Id :<input type="text" value="${data1.login_id}" readonly="" name="id"/> <br>
            User Name:<input type="text" value="${data1.name}" name="name" /> <br>
            Address :<input type="text" value="${data1.address}" name="add"/> <br>
            Email :<input type="text" value="${data1.email}" name="email"/> <br>
            <input type="submit" value="Update" name="update" /> <br>
        </core:forEach>
        </form>
        <core:if test="${param.update ne null}">
        <core:catch var="e">
        <sql:update var="status" sql="update student_info set name='${param.name}',address='${param.add}',email='${param.email}' where login_id='${param.id}'"/>
        <core:if test="${status gt 0}">
            <core:out value="Record Updated Succefully"></core:out>
        </core:if>
        <core:remove var="status"/>
        </core:catch>
        </core:if>
        
        
    </center>
        
        
    </body>
</html>