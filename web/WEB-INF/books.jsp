<%@ page import="model.Book" %>
<%@ page import="java.util.List" %>
<%@ page import="manager.AuthorManager" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>books</title>
</head>
<body>

<%
    List<Book> bookList = (List<Book>) request.getAttribute("books");
    final AuthorManager authorManager = new AuthorManager();
%>

<table border="1px">

    <tr>
        <th>title</th>
        <th>description</th>
        <th>price</th>
        <th>author</th>
        <th>action</th>
    </tr>

    <%for (Book book : bookList) {%>
    <tr>
        <td><%=book.getTitle()%></td>
        <td><%=book.getDescription()%></td>
        <td><%=book.getPrice()%></td>
        <td><%=book.getAuthor()%></td>
        <td><a href="/book/remove?bookId=<%=book.getId()%>">remove</a></td>
        <td><a href="/book/edit?bookId=<%=book.getId()%>">edit</a></td>
    </tr>
    <%}%>

</table>

</body>
</html>
