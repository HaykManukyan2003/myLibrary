<%@ page import="model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>homepage</title>
</head>
<body>

<%
    User user = (User) session.getAttribute("user");
%>

<%if (user != null) {%>

<div><a style="text-decoration: none" href="/author/add">Add an author</a></div>
<div><a style="text-decoration: none" href="/book/add">Add a book</a></div>
<div><a href="/logout">Logout</a></div>

<%} else {%>

<div><a href="/login">Login</a></div>
<div><a href="/register">Register</a></div>

<%}%>

<div><a style="text-decoration: none" href="/authors">Show authors</a></div>
<div><a style="text-decoration: none" href="/books">Show books</a></div>

</body>
</html>
