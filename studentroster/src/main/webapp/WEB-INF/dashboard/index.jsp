<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Student Roster</title>
	<link rel="stylesheet" type="text/css" href="css/dashboard.style.css" />
</head>
<body>
<div class="container">
	<!-- <header>
		<a href="/students/new">Add New Student</a>
		<a href="/contactInfos/new">Add New Contact Info</a>
		<form action="/search" style="display: inline-block;">
			<input type="search" id="searchInput" name="q" placeholder="Enter artist name...">
			<button type="submit">Search Artists</button>
		</form>
	</header> -->
	<main>
		<div>
			<p><a href="/students/new">Add New Student</a></p>
			<table>
			    <thead>
			        <tr>
			            <th>Name</th>
			            <th>actions</th>
			        </tr>
			    </thead>
			    <tbody>
			        <c:forEach items="${students}" var="student">
			        <tr>
			            <td><a href="/students/${student.id}"><c:out value="${student.firstName} ${student.lastName}"/></a></td>
			            <td>
							<a href="/students/${student.id}/edit">edit</a> | 
			            	<form action="/students/${student.id}" method="post" style="display: inline;">
								<input type="hidden" name="_method" value="delete">
								<input type="submit" value="delete">
							</form>
						</td>
			        </tr>
			        </c:forEach>
			    </tbody>
			</table>
		</div>
		<div>
			<p><a href="/contactInfos/new">Add New Contact Info</a></p>
			<table>
			    <thead>
			        <tr>
			            <th>Number</th>
			            <th>actions</th>
			        </tr>
			    </thead>
			    <tbody>
			        <c:forEach items="${contactInfos}" var="contactInfo">
			        <tr>
			            <td><a href="/contactInfos/${contactInfo.id}"><c:out value="${contactInfo.address}"/></a></td>
			            <td>
							<a href="/contactInfos/${contactInfo.id}/edit">edit</a> | 
			            	<form action="/contactInfos/${contactInfo.id}" method="post" style="display: inline;">
								<input type="hidden" name="_method" value="delete">
								<input type="submit" value="delete">
							</form>
						</td>
			        </tr>
			        </c:forEach>
			    </tbody>
			</table>
		</div>
		<div>
			<p><a href="/dorms/new">Add New Dorm</a></p>
			<table>
			    <thead>
			        <tr>
			            <th>Name</th>
			            <th>actions</th>
			        </tr>
			    </thead>
			    <tbody>
			        <c:forEach items="${dorms}" var="dorm">
			        <tr>
			            <td><a href="/dorms/${dorm.id}"><c:out value="${dorm.name}"/></a></td>
			            <td>
							<a href="/dorms/${dorm.id}/edit">edit</a> | 
			            	<form action="/dorms/${dorm.id}" method="post" style="display: inline;">
								<input type="hidden" name="_method" value="delete">
								<input type="submit" value="delete">
							</form>
						</td>
			        </tr>
			        </c:forEach>
			    </tbody>
			</table>
		</div>
	</main>
</div>
</body>
</html>
