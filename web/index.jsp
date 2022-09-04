<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>homepage</title>
</head>
<body>

<div style="display: flex; justify-content: space-between; width: 600px">
    <a style="text-decoration: none" href="${pageContext.request.contextPath}/author/add">Add an author</a>
    <a style="text-decoration: none" href="${pageContext.request.contextPath}/authors">Show authors</a>
    <a style="text-decoration: none" href="${pageContext.request.contextPath}/book/add">Add a book</a>
    <a style="text-decoration: none" href="${pageContext.request.contextPath}/books">Show books</a>
</div>

</body>
</html>
