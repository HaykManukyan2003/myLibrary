<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login page</title>
</head>
<body>

<%
    String message = (String) request.getAttribute("msg");
%>

<%if (message != null) {%>
<p style="color: red"><%=message%>
</p>
<%}%>

<form action="/login" method="post">
    <input type="email" name="email" placeholder="email"><br>
    <input type="password" name="password" placeholder="password"><br>
    <input type="submit" value="login">
</form>

</body>
</html>
