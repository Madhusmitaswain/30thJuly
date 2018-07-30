<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer(Seller) Order Page</title>
</head>
<body>
<%@include file="UserMenu.jsp" %>
<h1>Welcome to Customer(Seller) Order Page</h1>
<table border="1">
<tr>
	<th>ORDER ID</th>
	<th>ORDER CODE</th>
	<th>ITEM CODE</th>
	<th>CUSTOMER ID</th>
	<th>COST</th>
</tr>
<c:forEach items="${listOrder}" var="ord">
<tr>
<td><c:out value="${ord.orderId}"/></td>
<td><c:out value="${ord.orderCode}"/></td>
<td><c:out value="${ord.itemCode}"/></td>
<td><c:out value="${ord.cost}"/></td>
</tr>
</c:forEach>

</table>


	
</body>
</html>