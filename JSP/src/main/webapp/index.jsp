<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="sum.jsp">Addition</a>
<a href="table.jsp">Show table</a>
<h1>JSP Demo</h1>

<%!int a=5,b=15,sum=0; %>

<%
	sum = a+b;
if(true){
	System.out.println("sum is "+sum);
}
%>
<h3>Sum is <%=sum %></h3>
<%
	int age = 25;
if(age>=18){
	
	%>
	<h1>Eligible</h1>
	<%
}

else{
	%>
	<p>Not Eligible</p>
	<%
}

	for(int i=1;i<=10;i++){
		%>
		<p><%= i %></p>
		<%
	}
%>
</body>
</html>