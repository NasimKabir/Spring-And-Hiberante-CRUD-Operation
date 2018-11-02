<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Welcome to spring and hibernate.
	<div>
		<table border="1">
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Email</th>
				<th>Address</th>
				<th>Phone</th>
				<th>Operation</th>
			</tr>
			<c:forEach var="rows" items="${employee}">
				<tr>
					<td>${rows.id}</td>
					<td>${rows.name}</td>
					<td>${rows.email}</td>
					<td>${rows.address}</td>
					<td>${rows.phone}</td>
					<td><a href="${pageContext.request.contextPath}/updateform/?id=${rows.id}">update</a></td>
					<td><a href="${pageContext.request.contextPath}/deleteform/?id=${rows.id}">delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<br><br><br>
<a href="${pageContext.request.contextPath}/addEmployeeFrom">Add Employee</a>
</body>
</html>