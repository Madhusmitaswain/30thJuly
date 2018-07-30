<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Edit Page</title>
</head>
<body>
	<h1 align="center">Welcome to Customer Edit Page</h1>
	${custTypesUi}
	<form action="updatecustomer" method="POST">
		<table align="center" border="0">
			<tr>
				<th>ID</th>
				<td><input type="text" name="custId" value="${cID.custId}"
					readonly="readonly" /></td>
			</tr>
			<tr>
				<th>Name</th>
				<td><input type="text" name="custName" value="${cID.custName}"></td>
			</tr>
			<tr>
				<th>EMAIL</th>
				<td><input type="text" name="custEmail"
					value="${cID.custEmail}"></td>
			</tr>
			<tr>
				<th>ADDRESS</th>
				<td><input type="text" name="custAddr" value="${cID.custAddr}"></td>
			</tr>
			<tr>
				<th>TYPE</th>
				<td><select name="custType">
						<option value="">--select--</option>
						<c:forEach items="${custTypesUi}" var="type">
							<c:choose>
								<c:when test="${cID.custType eq type}">
									<option value="${type}" selected="selected" />${type}
								</c:when>
								<c:otherwise>
									<option value="${type}">${type}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
				</select></td>
			</tr>

			<tr>
				<td><input type="submit" name="reg" value="UPDATE"></td>
			</tr>
		</table>
	</form>
</body>
</html>