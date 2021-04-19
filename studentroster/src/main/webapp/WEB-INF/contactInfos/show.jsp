<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Contact Infos</title>
</head>
<body>
	<div>
		<a href="/dashboard">Dashboard</a>
		<br>
		<h1><c:out value="${contactInfo.student.firstName}"/> <c:out value="${contactInfo.student.lastName}"/>'s Contact Info</h1>
		<table>
			<tr><td>Address: </td><td><c:out value="${contactInfo.address}"/></td></tr>
			<tr><td>City: </td><td><c:out value="${contactInfo.city}"/></td></tr>
			<tr><td>State: </td><td><c:out value="${contactInfo.state}"/></td></tr>
		</table>
		<p><a href="/contactInfos/${contactInfo.id}/edit">Edit</a></p>
		<form action="/contactInfos/${contactInfo.id}" method="post">
			<input type="hidden" name="_method" value="delete">
			<input type="submit" value="Delete">
		</form>
	</div>
</body>
</html>