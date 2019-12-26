<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Student</title>
</head>
<body>

	<h1>Add Student</h1>

	<s:form modelAttribute="student" action="saveStudent">

  <input type="hidden" name="id" value="${student.id}"/>
  <input type="hidden" name="hobbies" value="${student.hobbies}" id="hiddenTxt"/>

 First Name: <s:input path="first_name" />
		<br>
		<br>
 Last Name:  <s:input path="last_name" />
		<br>
		<br>
 Email:      <s:input path="email" />
		<br>
		<br>
 Gender:     <s:radiobutton path="gender" value="Male" />Male  <s:radiobutton
			path="gender" value="Female" />Female<br>
		<br>
 			 
Hobbies:     <s:checkbox path="hobbies" value="Cricket" />Cricket <s:checkbox
			path="hobbies" value="Music" />Music <s:checkbox path="hobbies"
			value="Travelling" />Travelling <s:checkbox path="hobbies"
			value="Reading" />Reading<br>
		<br>
			 
Country:   <s:select path="country">
			<s:option value="India">India</s:option>
			<s:option value="US">US</s:option>
			<s:option value="Dubai">Dubai</s:option>
		</s:select>
		<br>
		<br>
		   
Address:  <s:textarea path="address" />
		<br>


		<s:button id="save">Save</s:button>
		<s:button id="update">Update</s:button>


	</s:form>



<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<script>
 
 $(document).ready(function(){
	 	 
	 var hobbies=$("#hiddenTxt").val().split(",");
	 var checkboxes=$("input[type=checkbox]");
	 
	 checkboxes.each(function(idx,element){
		 
		 if(hobbies.indexOf(element.value)!=-1)
			 {
			   element.setAttribute("checked","checked");
			   $("#save").hide();
			   $("#update").show();
			 }
		 else{
			 element.removeAttribute("checked");
			 $("#update").hide();
			 $("#save").show();
		 }
	 });
	 
	 
 });
		 
</script>

</body>
</html>