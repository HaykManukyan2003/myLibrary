<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>add author</title>
</head>
<body>

<form method="post" action="/author/add">
    <input type="text" name="name" placeholder="name">
    <input type="text" name="surname" placeholder="surname">
    <input type="email" name="email" placeholder="email">
    <input type="number" name="age" placeholder="age">
    <input type="submit" value="add">
</form>

</body>
</html>
