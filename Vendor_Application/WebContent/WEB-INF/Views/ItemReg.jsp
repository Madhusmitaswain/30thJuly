<%@page import="javax.servlet.descriptor.TaglibDescriptor"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ITEM Registration</title>
</head>
<body>
<%@include file="UserMenu.jsp" %>
<h1 align="center">Welcome to ITEM Registration</h1>
<form action="insertItem" method="POST">

<table align="center" border="0">
<tr><th>ITEMID</th><td><input type="text" name="itemId"></td></tr>
<tr><th>ITEMNAME</th><td><input type="text" name="itemName"></td></tr>
<tr><th>ITEMCODE</th><td><input type="text" name="itemCode"></td></tr>
<tr><th>ITEMMRP</th><td><input type="text" name="itemMrp"></td></tr>
<tr><th>ITEMMAXDISCOUNT</th><td><input type="text" name="maxDiscount"></td></tr>
<tr><th>ITEMMFG</th><td><input type="text" name="itemMfg"></td></tr>
<%-- <tr>
	<th>ITEMModels</th>
	<td>
	<select name="models">
	<option value="">select card</option>
    <c:forEach items="${itemTypesUi}" var="ob">
				  <option value="${ob}">${ob}</option>
	</c:forEach>
</select>
</td>
</tr>
 --%>
    <tr>
	<td><input type="submit" name="reg" value="Register"></td>
	</tr>

</table>
</form>
</body>
</html>