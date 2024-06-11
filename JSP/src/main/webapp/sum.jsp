<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form>

<input type ="text", placeholder="Enter first number" name="n1">
<br><br>
<input type ="text", placeholder="Enter second number" name="n2">
<br><br>
<input type ="submit", name="btn">

<%
	if(request.getParameter("btn")!=null){
		
		int a=Integer.parseInt(request.getParameter("n1"));
		int b=Integer.parseInt(request.getParameter("n2"));
		int c = a+b;
		%>
		<h1>Sum is <%= c %></h1>
		<%
	}

%>

</form>

</body>
</html>