<%@ page import="web.utils.UUIDUtils" %><%--
  Created by IntelliJ IDEA.
  User: Fionar
  Date: 2017/9/21
  Time: 20:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改商品</title>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/editProduct">
    <input type="hidden" name="pid" value="${bean.pid}">
    <table border="1" align="center" width="40%">
        <tr>
            <td>商品名称</td>
            <td><input type="text" name="pname" value="${bean.pname}"></td>
        </tr>
        <tr>
            <td>市场价</td>
            <td><input type="text" name="market_price" value="${bean.market_price}"></td>
        </tr>
        <tr>
            <td>商城价</td>
            <td><input type="text" name="shop_price" value="${bean.shop_price}"></td>
        </tr>
        <tr>
            <td>商品描述</td>
            <td><input type="text" width="200" name="pdesc" value="${bean.pdesc}"></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="修改"></td>
        </tr>

    </table>
</form>
</body>
</html>

