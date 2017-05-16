<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.io.*,java.util.*, javax.servlet.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hello DTIC - DevTools Example</title>
</head>
<body>
	<center>
        <img src="img/helloWorld.jpeg"><br>
		Hello DTIC! (last updated 14 Dec 2016 did commit work)
		Test automatic build
		<p>
			The time is now
	        <%
	        Date date = new Date();
			out.print(date.toString());
	        %>
			<br>
        <hr>
        <br> <a href="jsp/guessNumber.jsp">Want to guess a number?</a>
        <br>
        <br> <a href="/examples">Tomcat Examples</a>
        <hr>
        <br> <a href="jsp/version.jsp">Show version</a>
	</center>
</body>
</html>