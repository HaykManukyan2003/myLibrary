<%@ page import="java.util.List" %>
<%@ page import="model.Book" %>
<%@ page import="model.Author" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>add book</title>
</head>
<body>

<%
    List<Author> authorList = (List<Author>) request.getAttribute("authors");
%>

<form method="post" action="/book/add">
    <input type="text" name="title" placeholder="title">
    <input type="text" name="description" placeholder="description">
    <input type="number" name="price" placeholder="price">

    <select name="authorId">
        <%for (Author author : authorList) {%>
        <option value="<%=author.getId()%>"><%=author.getName() + " " + author.getSurname() + " " + author.getEmail()%></option>
        <%}%>
    </select>

    <input type="submit" value="add">
</form>

</body>
</html>
