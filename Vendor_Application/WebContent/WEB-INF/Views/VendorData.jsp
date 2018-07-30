<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">Welcome to Vendor Data Page</h1>
<table border="1" align="center">
<tr>
<th>ID</th>
<th>CODE</th>
<th>NAME</th>
<th>TYPE</th>
<th>ADDRESS</th>
<th>IDPROOF</th>
<th>IDNUM</th>
<th>NOTE</th>
<th colspan="2">operation</th>
</tr>
 
<c:forEach items="${vens}" var="ven">
<tr>
<td><c:out value="${ven.venId} "/></td>
<td><c:out value="${ven.venCode}"/></td>
<td><c:out value="${ven.venName}"/></td>
<td><c:out value="${ven.venType}"/></td>
<td><c:out value="${ven.addr}"  /></td>
<td><c:out value="${ven.idType}"/></td>
<td><c:out value="${ven.idNum}"/></td>
<td><c:out value="${ven.dsc}"/></td>

<td>
<a href ="deleteVendor?venId=${ven.venId}"><img src="../images/delete.png" height="30" width="30"/></a>
</td>
<td>
<a href ="editVendor?venId=${ven.venId}"><img src="../images/edit.png" height="30" width="30"/></a>
</td>
</tr>
</c:forEach>
</table>
<a href ="venExcelExport">Vendor Excel Export</a>
<a href ="venPdfExport">Vendor pdf Export</a>
</body>
</html>