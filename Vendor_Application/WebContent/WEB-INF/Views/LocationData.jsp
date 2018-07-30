<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Location Data Page</title>
</head>
<body>
<%@include file="UserMenu.jsp" %>
<h1 align="center">Welcome to Location Data Page</h1>
<table border="1" align="center">
<tr>
<th>ID</th>
<th>Name</th>
<th>Type</th>
<th>Code</th>
<th>Description</th>
<th colspan="2">operation</th>
</tr>
<c:forEach items="${locs}" var="loc">
<tr>
<td><c:out value="${loc.locId} "/></td>
<td><c:out value="${loc.locName}"/></td>
<td><c:out value="${loc.locType}"/></td>
<td><c:out value="${loc.locCode}"/></td>
<td><c:out value="${loc.locDsc}"/></td>
<td>
<a href ="deleteLoc?locId=${loc.locId}"><img src="../images/delete.png" height="20" width="20"/></a>
</td>
<td>
<a href ="editLoc?locId=${loc.locId}"><img src="../images/edit.png" height="20" width="20"/></a>
</td>

</tr>



</c:forEach>
</table>
<a href ="locExcelExport">Location Excel Export</a>
<a href ="locPdfExport">Location pdf Export</a>
</body>
</html>
