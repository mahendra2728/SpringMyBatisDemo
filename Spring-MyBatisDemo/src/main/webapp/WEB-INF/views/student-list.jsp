<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student List</title>
</head>
<body>
<h1>Student List</h1>

<button onclick="window.location.href='showAddStudentForm.htm'"> Add Student</button> <br><br>

<div>
 <table border="1">
 
   <tr>
    <th>Full Name</th>
    <th>Email</th>
    <th>Gender</th>
    <th>Hobbies</th>
    <th>Country</th>
    <th>Address</th>
    <th>Action</th>
   </tr>
   
   <c:forEach items="${students}" var="tempStudent">
   
   
     <!-- For delete Link  -->
     <c:url var="deleteLink" value="deleteStudent">
          <c:param name="studentId" value="${tempStudent.id}"/>
     </c:url>
     
     
     <!-- For update Link  -->
     <c:url var="updateLink" value="editStudent">
          <c:param name="studentId" value="${tempStudent.id}"/>
     </c:url>
     
     
   
   
      <tr>
      	<th>${tempStudent.first_name} ${tempStudent.last_name}</th>
        <th>${tempStudent.email}</th>
      	<th>${tempStudent.gender}</th>
      	<th>${tempStudent.hobbies}</th>
      	<th>${tempStudent.country}</th>
      	<th>${tempStudent.address}</th>
      	<th><a href="${deleteLink}" onclick="if(!(confirm('Are you sure want to delete ?'))) return false;">Delete</a> ||
      	    <a href="${updateLink}">Edit</a>
      	
      	</th>
      </tr>
   
   </c:forEach>
 
 </table>
</div>
</body>
</html>