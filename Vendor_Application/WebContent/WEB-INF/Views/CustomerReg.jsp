<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <%@include file="UserMenu.jsp" %> 
<h1 align="center">Welcome to Customer Registration</h1>
 <a href="viewAllCustomer">View All Customer</a> 
	<form action="insertcust" method="POST">
	<table align="center" border="0">
	<tr>
	<th>ID:</th>
	<td><input type="text" name="custId"/></td>
	</tr>
	<tr>
	<th>NAME:</th>
	<td><input type="text" name="custName"/></td>
	</tr>
	<tr>
	<th>EMAIL:</th>
	<td><input type="text" name="custEmail"/></td>
	</tr>
	<!-- <tr>
	<th>PASSWORD:</th>
	<td><input type="password" name="password"></td>
	</tr> -->
	 <tr>
	<th>Type:</th>
	<td>
	<select name="custType">
	<option value="-1">-Select-</option>
	<c:forEach items="${custTypesUi}" var="ob">
	<option value="${ob}">${ob}</option>
	</c:forEach>
	</select>
	</td>
	</tr>
	<tr>
	<th>LOCATION</th>
	<td>
	 <select name="loc.locId">
			<option value="">--select type--</option>
			<c:forEach items="${locsUi}" var="locOb">
				<option value="${locOb.locId}">${locOb.locName}</option>
			</c:forEach>
		  </select>
	</td>
	</tr>
	<tr>
	<th>Address:</th>
	<td><input type="text" name="custAddr"/></td>
	</tr>
	
	<tr>
	<td><input type="submit" name="reg" value="Register"></td>
	</tr>
	</table>
	</form>
	${ message}
	
</body>
</html>