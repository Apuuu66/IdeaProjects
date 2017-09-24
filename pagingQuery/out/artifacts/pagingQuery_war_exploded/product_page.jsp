<%--
  Created by IntelliJ IDEA.
  User: Fionar
  Date: 2017/9/24
  Time: 19:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1" align="center" width="88%">
    <tr>
        <th>pid</th>
        <th>商品图片</th>
        <th>商品名称</th>
        <th>市场价</th>
        <th>商城价</th>
        <th>商品描述</th>
    </tr>
    <c:forEach items="${pb.list}" var="p">
        <tr>
            <td width="8%">${p.pid}</td>
            <td width="8%"><img src="${p.pimage}" width="80"></td>
            <td width="8%">${p.pname}</td>
            <td width="8%">${p.shop_price}</td>
            <td width="8%">${p.market_price}</td>
            <td>${p.pdesc}</td>
        </tr>
    </c:forEach>
</table>
<center>
    <c:if test="${pb.currPage!=1}">
        <a href="${pageContext.request.contextPath}/showProductsByPage?currPage=1">[首页]</a>
        <a href="${pageContext.request.contextPath}/showProductsByPage?currPage=${pb.currPage-1}">[上一页]</a>
    </c:if>

    <c:if test="${pb.currPage!=pb.totalPage}">
        <a href="${pageContext.request.contextPath}/showProductsByPage?currPage=${pb.currPage+1}">[下一页]</a>
        <a href="${pageContext.request.contextPath}/showProductsByPage?currPage=${pb.totalPage}">[尾页]</a>
    </c:if>
    &nbsp;&nbsp;&nbsp;第${pb.currPage}页/共${pb.totalPage}页
</center>
</body>
</html>
