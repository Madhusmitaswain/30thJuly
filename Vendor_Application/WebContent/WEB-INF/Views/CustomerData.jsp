<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>
<h1 align="center">CUSTOMER DATA PAGE</h1>
<%-- ${cust} --%>
<table border="1" align="center">
<tr>
<th>ID</th>
<th>Name</th>
<th>Type</th>
<th>EMAIL</th>
<th>ADDRESS</th>
<th>LINK</th>
<!-- <th>PASSWORD</th>
<th>CUSTACCTOCK</th> -->
<th colspan="2">OPERATION</th>
</tr>

<c:forEach items="${cust}" var="custmer">
<tr>
<td><c:out value="${custmer.custId} "/></td>
<td><c:out value="${custmer.custName}"/></td>
<td><c:out value="${custmer.custType}"/></td>
<td><c:out value="${custmer.custEmail}"/></td>
<td><c:out value="${custmer.custAddr}"/></td>
<%-- <td><c:out value="${custmer.password}"/></td>
<td><c:out value="${custmer.custaccTock}"/></td> --%>

<td>
<a href ="deleteCustomer?custId=${custmer.custId}"><img src="../images/delete.png" height="30" width="30"/></a>
</td>
<td>
<a href ="editCustomer?custId=${custmer.custId}"><img src="../images/edit.png" height="30" width="30"/></a>
</td>
<td>
	<c:choose>
		<c:when test="${'Seller' eq c.custType}">
		  <a href="viewCustItems?custId=${c.custId}">View Items</a>
		</c:when>
		<c:otherwise>
		  <a href="getCustOrders?custId=${c.custId}">View Orders</a>
		</c:otherwise>
	</c:choose>
</td>

</tr>
</c:forEach>

</table>
<a href ="custExcelExport">Customer Excel Export</a>
<a href ="custPdfExport">Customer pdf Export</a>
</body>
</html>