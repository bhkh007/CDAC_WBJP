<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<center>
    <form method="post">
        <table cellspacing="15">
            <tr>
                <td>Name</td>
                <td><input type="text" name="name"></td>
            </tr>
            <tr>
                <td>Message</td>
                <td><textarea type="text" cols="25" rows="8" name="message"></textarea></td>
            </tr>
            <tr>
                <td>Are you human?</td>
                <td><input type="text" name="code"></td>
            </tr>
        </table>
        <br>
        <img src="CaptchaServlet" alt="Captcha Image"> 
        <br><br>
        <input type="submit" value="submit">
    </form>
    <br><br>
    <%
        String captcha = (String) session.getAttribute("captcha");
        String code = request.getParameter("code");

        if (captcha != null && code != null) {
            if (captcha.equals(code)) {
                out.print("<p class='alert'>Correct</p>");
            } else {
                out.print("<p class='alert'>Incorrect</p>");
            }
        }
    %>
</center>
</body>
</html>