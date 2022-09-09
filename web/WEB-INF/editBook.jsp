<%@ page import="model.Book" %>
<%@ page import="model.Author" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>edit book</title>
</head>
<body>

<%
    Book book = (Book) request.getAttribute("book");
    List<Author> authorList = (List<Author>) request.getAttribute("authors");
%>

<form method="post" action="/book/edit" enctype="multipart/form-data">
    <input type="hidden" name="bookId" value="<%=book.getId()%>">
    <input type="file" name="coverImg" value="<%=book.getCoverImg()%>">
    <input type="text" name="title" value="<%=book.getTitle()%>">
    <input type="text" name="description" value="<%=book.getDescription()%>">
    <input type="number" name="price" value="<%=book.getPrice()%>">

    <select name="authorId">
        <% for (Author author : authorList) {%>
        <option value="<%=author.getId()%>"><%=author.getName() + " " + author.getSurname() + " " + author.getEmail()%>
        </option>
        <%}%>
    </select>

    <input type="submit" value="update">
</form>

</body>
</html>
