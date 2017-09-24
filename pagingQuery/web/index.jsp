<%--
  Created by IntelliJ IDEA.
  User: Fionar
  Date: 2017/9/20
  Time: 17:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
</head>
<body>
<h2><a href="${pageContext.request.contextPath}/findAll">展示所有商品</a></h2>
<h2><a href="add.jsp">添加商品</a></h2>
  <h2><a href="${pageContext.request.contextPath}/showProductsByPage?currPage=1">分页展示商品</a></h2>
</body>
</html>
