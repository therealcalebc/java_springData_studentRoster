<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Students</title>
</head>
<body>
	<div>
		<a href="/dashboard">Dashboard</a>
		<br>
		<h1><c:out value="${student.firstName}"/> <c:out value="${student.lastName}"/></h1>
		<table>
			<tr><td>Age: </td><td><c:out value="${student.age}"/></td></tr>
			<tr><td>Address: </td><td><c:out value="${student.contactInfo.address}"/></td></tr>
			<tr><td>City: </td><td><c:out value="${student.contactInfo.city}"/></td></tr>
			<tr><td>State: </td><td><c:out value="${student.contactInfo.state}"/></td></tr>
		</table>
		<p><a href="/students/${student.id}/edit">Edit</a></p>
		<form action="/students/${student.id}" method="post">
			<input type="hidden" name="_method" value="delete">
			<input type="submit" value="Delete">
		</form>
	</div>
</body>
</html>