<%@ page import="model.Author" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>authors</title>
</head>
<body>

<%
    List<Author> authorList = (List<Author>) request.getAttribute("authors");
%>

<table border="1px">
    <tr>
        <th>image</th>
        <th>id</th>
        <th>name</th>
        <th>surname</th>
        <th>email</th>
        <th>age</th>
        <th>action</th>
    </tr>

    <% for (Author author : authorList) {%>
    <tr>
        <td>
            <%if (author.getProfilePicture() == null || author.getProfilePicture().length() == 0) {%>
            <img src="/image/defaultAvatar.png" width="100px">
            <%} else { %>
            <img src="/profilePicture/get?profilePicture=<%=author.getProfilePicture()%>" width="100px">
            <%}%>
        </td>
        <td><%=author.getId()%>
        </td>
        <td><%=author.getName()%>
        </td>
        <td><%=author.getSurname()%>
        </td>
        <td><%=author.getEmail()%>
        </td>
        <td><%=author.getAge()%>
        </td>
        <td><a href="${pageContext.request.contextPath}/author/remove?authorId=<%=author.getId()%>">remove</a></td>
        <td><a href="${pageContext.request.contextPath}/author/edit?authorId=<%=author.getId()%>">edit</a></td>
    </tr>
    <% } %>

</table>

</body>
</html>
