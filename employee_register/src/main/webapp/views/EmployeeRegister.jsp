<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h1>Employee Registration</h1>
		<form action="<%= request.getContextPath() %>/register" method="post">
		<table style="with: 80%">
			<tr>
				<td>First Name</td>
				<td><input type="text" name="firstname" /></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><input type="text" name="lastname" /></td>
			</tr>
			<tr>
				<td>User Name</td>
				<td><input type="text" name="username" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="text" name="password" /></td>
			</tr>
			<tr>
				<td>Address</td>
				<td><input type="text" name="address" /></td>
			</tr>
			<tr>
				<td>Contact</td>
				<td><input type="text" name="contact" /></td>
			</tr>
		</table>
		<input type="submit" value="Submit" />
		</form>
	</div>
</body>
</html>