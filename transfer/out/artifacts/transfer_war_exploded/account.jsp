<%--
  Created by IntelliJ IDEA.
  User: Fionar
  Date: 2017/9/17
  Time: 22:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/account">
    <table>
        <tr>
            <td>转出方</td>
            <td><input type="text" name="fromuser"></td>
        </tr>
        <tr>
            <td>转入方</td>
            <td><input type="text" name="touser"></td>
        </tr>
        <tr>
            <td>转账金额</td>
            <td><input type="text" name="money"></td>
        </tr>
        <tr>
            <td><input type="submit" value="转账"></td>
            <td></td>
        </tr>
    </table>
</form>
</body>
</html>
