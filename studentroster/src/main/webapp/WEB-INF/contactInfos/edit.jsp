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
		<h1>Edit Contact Info</h1>
		<form:form action="/contactInfos/${contactInfo.id}" method="post" modelAttribute="contactInfo" id="editContactInfoForm">
			<input type="hidden" name="_method" value="put">
		    <p>
		        <form:label path="student">Student</form:label>
		        <form:select path="student">
		        	<c:forEach items="${students}" var="s">
		        		<c:choose>
			        		<c:when test="${p.id == contactInfo.student.id}">
			        			<form:option value="${s}" selected="true" label="${s.firstName} ${s.lastName}"/>
			        		</c:when>
			        		<c:otherwise>
			        			<form:option value="${s}" label="${s.firstName} ${s.lastName}"/>
			        		</c:otherwise>
		        		</c:choose>
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
		    <!-- <input type="submit" value="Update"/> -->
		</form:form>
		<button type="submit" form="editContactInfoForm">Update</button>
		<form action="/contactInfos/${contactInfo.id}" method="post" style="display: inline;">
			<input type="hidden" name="_method" value="delete">
			<input type="submit" value="Delete">
		</form>
	</div>
</body>
</html>
