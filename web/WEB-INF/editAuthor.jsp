<%@ page import="model.Author" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>edit author</title>
</head>
<body>

<%
    Author author = (Author) request.getAttribute("author");
%>

<form method="post" action="/author/edit" enctype="multipart/form-data">
    <input type="hidden" name="authorId" value="<%=author.getId()%>">
    <input type="text" name="name" value="<%=author.getName()%>">
    <input type="text" name="surname" value="<%=author.getSurname()%>">
    <input type="email" name="email" value="<%=author.getEmail()%>">
    <input type="number" name="age" value="<%=author.getAge()%>">
    <input type="file" name="profilePicture" value="<%=author.getProfilePicture()%>">
    <input type="submit" value="update">
</form>

</body>
</html>
