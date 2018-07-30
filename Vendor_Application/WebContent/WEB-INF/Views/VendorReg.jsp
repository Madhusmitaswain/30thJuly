<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vendor Registration</title>
</head>
<body>
<%@include file="UserMenu.jsp" %>
<h1 align="center">Welcome to Vendor Registration</h1>
	<!-- <a href="viewAllvendors">View All Vendors</a> -->
	<form action="insertvendor" method="POST">
	
	<table align="center" border="0">
	<tr><th>ID</th>
	<td><input type="text" name="venId"></td>
	</tr>
	<tr><th>Code</th>
	<td><input type="text" name="venCode"></td>
	</tr>
	<tr>
	<th>Name</th>
	<td><input type="text" name="venName"></td>
	</tr>

	<tr>
	<%-- 
	<th>Type</th>
	<td><input type="radio" name="venType" value="${venTypesUi}"/></td>
	<!-- <td>
	<input type="radio" name="venType" value="CONTRACT">CONTRACT
	<input type="radio" name="venType" value="FULLTIME">FULLTIME
	<input type="radio" name="venType" value="PARTTIME">PARTTIME</td>-->
	</tr> --%>
	<!-- another way -->
	<th>Type</th>
	<td><c:forEach items="${venTypesUi}" var="ob">
	<input type="radio" name="venType" value="${ob}">${ob}
	</c:forEach>
	</td>
	<tr>
	<th>Location</th>
	<td>
	 <select name="loc.locId">
			<option value="">--select--</option>
			<c:forEach items="${locsUi}" var="locOb">
				<option value="${locOb.locId}">${locOb.locName}</option>
			</c:forEach>
		  </select>
	</td>
	</tr>

	<tr>
	<tr><th>ADDRESS</th><td><input type="text" name="addr"></td></tr> 
	<tr>
	<th>ID PROOF</th>
	<td>
	<select name="idType">
	<option value="">select card</option>
    <c:forEach items="${venIdTypesUi}" var="ob">
				  <option value="${ob}">${ob}</option>
	</c:forEach>
</select>
</td>
</tr>
<tr><th>ID NUM</th><td><input type="text" name="idNum"></td></tr>
<tr><th>NOTE</th><td><textarea name="dsc"></textarea></td></tr>
<tr><td><input type="submit" name="reg" value="Register"></td></tr>
</table>

</form>
	
</body>
</html>