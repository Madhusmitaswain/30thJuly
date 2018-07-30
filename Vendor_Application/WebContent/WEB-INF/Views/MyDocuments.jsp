<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@include file="UserMenu.jsp"%>
	<h1>Welcome to Documents Page!!</h1>
	<form action="docUpload" method="post" enctype="multipart/form-data">

		<pre>
Enter Doc Id : <input type="text" name="docId" />
Choose File  : <input type="file" name="docData" />
<input type="submit" value="Upload" />
</pre>
	</form>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th colspan="2">OPERATION</th>
		</tr>
		<c:forEach items="${docs}" var="ob">
			<tr>
				<td><c:out value="${ob[0]}" /></td>
				<td><c:out value="${ob[1]}" /></td>
				<%-- <td><a href="docDownload?docId=${ob[0]}">
<img  src="../images/download.png" width="30" height="30"/>
<img src="../images/delete.png" height="30" width="30"/></a>

</a></td> --%>

				<td><a href="docDownload?docId=${ob[0]}"><img
						src="../images/download.png" width="30" height="30" /></a></td>

				<td><a href="deleteDocument?docId=${ob[0]}"><img
						src="../images/delete.png" height="30" width="30" /></a></td>
				<%-- <td>
<a href ="editCustomer?custId=${custmer.custId}"><img src="../images/edit.png" height="30" width="30"/></a>
</td> --%>







			</tr>
		</c:forEach>
	</table>

</body>
</html>