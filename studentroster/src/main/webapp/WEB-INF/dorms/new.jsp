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
		<h1>New Dorm</h1>
		<form:form action="/dorms" method="post" modelAttribute="dorm">
		    <p>
		        <form:label path="name">Name</form:label>
		        <form:input path="name"/>
		        <form:errors path="name"/>
		    </p>
		    <input type="submit" value="Add Dorm"/>
		</form:form>
	</div>
</body>
</html>
