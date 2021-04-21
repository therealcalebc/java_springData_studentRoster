<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Dorms</title>
	<link rel="stylesheet" type="text/css" href="/css/show.style.css" />
</head>
<body>
	<div class="container">
		<header>
			<p><a href="/dashboard">Dashboard</a></p>
		</header>
		<main>
			<h1><c:out value="${dorm.name}"/> Dormitory</h1>
			<div>
				<form action="/dorms/<c:out value="${dorm.id}"/>/addStudent">
					<label>Students: </label>
					<select name="studentToAddId">
						<option value="" selected disabled></option>
						<c:forEach items="${unassignedStudents}" var="stud">
							<option value="${stud.id}"><c:out value="${stud.firstName}"/> <c:out value="${stud.lastName}"/></option>
						</c:forEach>
					</select>
					<button type="submit">Add Student</button>
				</form>
			</div>
			<div>
				<table>
				    <thead>
				        <tr>
				            <th>Name</th>
				            <th>Action</th>
				        </tr>
				    </thead>
				    <tbody>
				        <c:forEach items="${dorm.students}" var="student">
					        <tr>
					            <td><c:out value="${student.firstName}"/> <c:out value="${student.lastName}"/></td>
					            <td>
					            	<form action="/dorms/<c:out value="${dorm.id}"/>/removeStudent" style="display: inline;">
										<input type="hidden" name="studentToRemoveId" value="${student.id}">
										<button type="submit">Remove</button>
									</form>
								</td>
					        </tr>
				        </c:forEach>
				    </tbody>
				</table>
				<!-- <p><a href="/dorms/${dorm.id}/edit">Edit</a></p>
				<form action="/dorms/${dorm.id}" method="post">
					<input type="hidden" name="_method" value="delete">
					<input type="submit" value="Delete">
				</form> -->
			</div>
		</main>
	</div>
</body>
</html>