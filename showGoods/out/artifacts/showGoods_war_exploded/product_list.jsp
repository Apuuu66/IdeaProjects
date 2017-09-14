<%--
  Created by IntelliJ IDEA.
  User: Fionar
  Date: 2017/9/14
  Time: 21:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1" align="center">
    <tr>
    <td>id</td>
    <td>商品名称</td>
    <td>单价</td>
    <td>描述</td>
    </tr>
    <c:forEach items="${list}" var="p">
        <tr>
            <td>${p.id}</td>
            <td>${p.pname}</td>
            <td>${p.price}</td>
            <td>${p.pdesc}</td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
