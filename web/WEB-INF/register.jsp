<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register page</title>
</head>
<body>

<%
    String message = (String) request.getAttribute("msg");
%>

<%if (message != null) {%>
<p style="color: red"><%=message%>
</p>
<%}%>

<form action="/register" method="post">
    <input type="text" name="name" placeholder="name">
    <input type="text" name="surname" placeholder="surname">
    <input type="text" name="email" placeholder="email">
    <input type="password" name="password" placeholder="password">
    <input type="submit" value="register">
</form>

</body>
</html>
