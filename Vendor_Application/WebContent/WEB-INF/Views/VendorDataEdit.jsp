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
<h1 align="center">Welcome to Vendor Edit Page</h1>
<form  action="updatevendor" method="POST">
	<table align="center" border="0">
	<tr><th>ID</th>
	<td><input type="text" name="venId" value="${ven.venId}" readonly="readonly"/></td>
	</tr>
	<tr><th>Code</th>
	<td><input type="text" name="venCode" value="${ven.venCode}"></td>
	</tr>
	<tr>
	<th>Name</th>
	<td><input type="text" name="venName" value="${ven.venName}"></td>
	</tr>

	<tr>
	<%-- 
	<th>Type</th>
	<td>
	<c:choose>
	<c:when test="${'CONTRACT' eq ven.venType}">
	<input type="radio" name="venType" value="CONTRACT" checked="CONTRACT"/>CONTRACT
	<input type="radio" name="venType" value="FULLTIME" />FULLTIME
	<input type="radio" name="venType" value="PARTTIME" />PARTTIME
	</c:when>
	<c:when test="${'FULLTIME' eq ven.venType}">
	<input type="radio" name="venType" value="FULLTIME" checked="FULLTIME"/>FULLTIME
	<input type="radio" name="venType" value="CONTRACT" />CONTRACT
	<input type="radio" name="venType" value="PARTTIME" />PARTTIME
	</c:when>
	<c:otherwise>
	<input type="radio" name="venType" value="PARTTIME" checked="PARTTIME"/>PARTTIME
	<input type="radio" name="venType" value="CONTRACT" />CONTRACT
	<input type="radio" name="venType" value="FULLTIME" />FULLTIME
	</c:otherwise>
	</c:choose> --%>
	<th>Type</th>
	<td>
	<c:forEach items="${venTypesUi}" var="ob">
		 	<c:choose>
		 	<c:when test="${ven.venType eq ob}">
		 		<input type="radio" name="venType" value="${ob}" checked="checked">${ob}
		 	</c:when>
		 	<c:otherwise>
		 		<input type="radio" name="venType" value="${ob}">${ob}
		 	</c:otherwise>
		 	</c:choose>
		</c:forEach>
	</td>
	
	
	
	
	
	<tr><th>ADDRESS</th><td><input type="text" name="addr" value="${ven.addr}" ></td></tr>
	<tr>
	<th>ID PROOF</th>
	<td>
	<select name="idType">
				<option value="">--select--</option>
				<c:forEach items="${venIdTypesUi}" var="ob">
				  <c:choose>
				  	<c:when test="${ven.idType eq ob}">
				  		 <option value="${ob}" selected="selected">${ob}</option>
				  	</c:when>
				  	<c:otherwise>
				  	 	<option value="${ob}">${ob}</option>
				  	</c:otherwise>
				  </c:choose>
				  </c:forEach>
				  </select>
				 
</td>
</tr>
<tr><th>ID NUM</th><td><input type="text" name="idNum" value="${ven.idNum}" ></td></tr>
<tr><th>NOTE</th><td><textarea name="dsc" value="{ven.dsc}"></textarea></td></tr>
   <tr><td><input type="submit" name="reg" value="UPDATE"></td></tr>
	</table>
	</form>
</body>
</html>