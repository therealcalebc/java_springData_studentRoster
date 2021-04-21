<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Dorms</title>
</head>
<body>
	<div>
		<a href="/dashboard">Dashboard</a>
		<h1>Edit Dorm</h1>
		<form:form action="/dorms/${dorm.id}" method="post" modelAttribute="dorm" id="editDormForm">
			<input type="hidden" name="_method" value="put">
		    <p>
		        <form:label path="name">Name</form:label>
		        <form:input path="name"/>
		        <form:errors path="name"/>
		    </p>
		    <!-- <input type="submit" value="Update"/> -->
		</form:form>
		<button type="submit" form="editDormForm">Update</button>
		<form action="/dorms/${dorm.id}" method="post" style="display: inline;">
			<input type="hidden" name="_method" value="delete">
			<input type="submit" value="Delete">
		</form>
	</div>
</body>
</html>
