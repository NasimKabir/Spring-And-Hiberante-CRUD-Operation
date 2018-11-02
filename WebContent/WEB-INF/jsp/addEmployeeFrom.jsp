<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<p>Please put your information</p>
	<form:form action="${pageContext.request.contextPath}/EmployeeAdded" method="post" modelAttribute="employee">
	     <form:hidden path="id"/>
		<label>Name</label><br> <form:input path="name" /><br>
		<label>Email</label><br> <form:input  path="email" /><br>
		<label>Address</label><br> <form:input  path="address" /><br>
		<label>Phone</label><br> <form:input  path="phone" /><br>
		<input type="submit" value="saveOrUpdate">
	</form:form>
</body>
</html>