<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Students</title>
</head>
<body>
	<div>
		<a href="/dashboard">Dashboard</a>
		<h1>Edit Student</h1>
		<form:form action="/students/${student.id}" method="post" modelAttribute="student" id="editStudentForm">
			<input type="hidden" name="_method" value="put">
		    <p>
		        <form:label path="firstName">First Name</form:label>
		        <form:input path="firstName"/>
		        <form:errors path="firstName"/>
		    </p>
		    <p>
		        <form:label path="lastName">Last Name</form:label>
		        <form:input path="lastName"/>
		        <form:errors path="lastName"/>
		    </p>
		    <p>
		        <form:label path="age">Age</form:label>
		        <form:input path="age" type="number"/>
		        <form:errors path="age"/>
		    </p>
		    <!-- <input type="submit" value="Update"/> -->
		</form:form>
		<button type="submit" form="editStudentForm">Update</button>
		<form action="/students/${student.id}" method="post" style="display: inline;">
			<input type="hidden" name="_method" value="delete">
			<input type="submit" value="Delete">
		</form>
	</div>
</body>
</html>
