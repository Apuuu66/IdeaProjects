<%--
  Created by IntelliJ IDEA.
  User: Fionar
  Date: 2017/10/11
  Time: 19:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/upload" method="post" enctype="multipart/form-data">
    用户名<input name="username"><br>
    头像 <input type="file" name="f"><br>
    <input type="submit">
</form>
</body>
</html>
