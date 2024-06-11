<%@ page language="java" contentType="text/html"; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
	String s1[] = {"100","Bhavesh","616161"};
	String s2[] = {"101","John","6546464"};
	String s3[] = {"102","David","6646616"};
	
	String students[][] = {s1,s2,s3};
%>

	<table border='1', cellpadding='10',cellspacing='0';>
	
		<tr>
			<th>Id</th>th>
			<th>Name</th>th>
			<th>Phone</th>th>
		</tr>
		<%
		for(int i=0;i<students.length;i++){
		%>
		<tr>
			<td><%= students[i][0] %> </td>
			<td><%= students[i][1] %> </td>
			<td><%= students[i][2] %> </td>
		</tr>
		<%
		}
		%>
	
	</table>



</body>
</html>