<%@ page import="web.utils.UUIDUtils" %><%--
  Created by IntelliJ IDEA.
  User: Fionar
  Date: 2017/9/20
  Time: 21:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加商品</title>
</head>
<body>
<%
    String code=UUIDUtils.getId();
    session.setAttribute("s_code",code);
    pageContext.setAttribute("p_code",code);
%>
<form method="post" action="${pageContext.request.contextPath}/addProduct">
    <input type="hidden" name="r_code" value="${p_code}">
    <table border="1" align="center" width="40%">
        <tr>
            <td>商品名称</td>
            <td><input type="text" name="pname"></td>
        </tr>
        <tr>
            <td>市场价</td>
            <td><input type="text" name="market_price"></td>
        </tr>
        <tr>
            <td>商城价</td>
            <td><input type="text" name="shop_price"></td>
        </tr>
        <tr>
            <td>商品描述</td>
            <td><input type="text" name="pdesc"></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="保存"></td>
        </tr>

    </table>
</form>
</body>
</html>
