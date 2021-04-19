<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
		<h1>New Contact Info</h1>
		<form:form action="/contactInfos" method="post" modelAttribute="contactInfo">
		    <p>
		        <form:label path="student">Student</form:label>
		        <form:select path="student">
		        	<c:forEach items="${students}" var="s">
		        		<form:option value="${s}" label="${s.firstName} ${s.lastName}"/>
			        </c:forEach>
		        </form:select>
		        <form:errors path="student"/>
		    </p>
		    <p>
		        <form:label path="address">Address</form:label>
		        <form:input path="address"/>
		        <form:errors path="address"/>
		    </p>
		    <p>
		        <form:label path="city">City</form:label>
		        <form:input path="city"/>
		        <form:errors path="city"/>
		    </p>
		    <p>
		        <form:label path="state">State</form:label>
		        <form:input path="state"/>
		        <form:errors path="state"/>
		    </p>
		    <input type="submit" value="Add Contact Info"/>
		</form:form>
	</div>
</body>
</html>
