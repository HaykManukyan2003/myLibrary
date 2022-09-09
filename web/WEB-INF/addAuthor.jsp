<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>add author</title>
</head>
<body>

<form method="post" action="${pageContext.request.contextPath}/author/add" enctype="multipart/form-data">
    <input type="text" name="name" placeholder="name">
    <input type="text" name="surname" placeholder="surname">
    <input type="email" name="email" placeholder="email">
    <input type="number" name="age" placeholder="age">
    <input type="file" name="profilePicture">
    <input type="submit" value="add">
</form>

</body>
</html>
