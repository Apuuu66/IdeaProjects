<%@ page import="javab.User" %>
<%--
  Created by IntelliJ IDEA.
  User: Fionar
  Date: 2017/9/12
  Time: 18:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    User user = new User();
    user.setId("001");
    user.setName("tom");
    request.setAttribute("user",user);
%>
获取域中javabean的id值：<br>
老方法：<%=((User)request.getAttribute("user")).getId()%><br>
${user.id}<br>
${requestScope.user.id}<br>
${user.name}
</body>
</html>
