<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome to User Register Page!!</h1>
<form action="userInsert" method="post">
<pre>
<!-- ID : <input type="text" name="userId"/> -->
NAME : <input type="text" name="userName"/>
Email : <input type="text" name="userEmail"/>
Contact:<input type="text" name="userContact"/>
Address : <textarea name="userAddr"></textarea>
<input type="submit" value="Register"/>
</pre>
</form>
${message}
<br/>
Having account already? <a href="login">Login</a>
</body>
</html>