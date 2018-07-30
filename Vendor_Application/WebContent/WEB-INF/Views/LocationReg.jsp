<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Location Registration</title>
</head>
<body>
<%@include file="UserMenu.jsp" %>
<h1 align="center">Welcome to Location Registration</h1>
            ${ message}
            <!-- <a href="viewAllLocs">View All Location</a> -->
	<form action="insertLocation" method="POST">
	<table align="center" border="0">
	
	<tr><th>LOCATION ID</th><td><input type="text" name="locId"></td></tr>
	<tr><th>LOCATION Name</th><td><input type="text" name="locName"></td></tr>
	
	<tr><th>LOCATION Type</th><td><input type="radio" name="locType" value="Urban">Urban
	<input type="radio" name="locType" value="Rural">Rural</td></tr>
	<tr><th>LOCATION Code</th><td><input type="text" name="locCode"></td></tr>
	
	<tr><th>Description</th><td><textarea name="locDsc"></textarea></td></tr>
	
	<tr><th></th><td><input type="submit" name="reg" value="Register"></td></tr>
	
	</table>
	</form>
</body>
</html>