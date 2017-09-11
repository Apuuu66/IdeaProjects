<%--
  Created by IntelliJ IDEA.
  User: Fionar
  Date: 2017/9/10
  Time: 21:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    request.setAttribute("rkey","rvalue");
    session.setAttribute("skey","svalue");
    application.setAttribute("akey","avalue");
%>
获取request中的数据：<br>
老方式：<%=request.getAttribute("rkey")%><br>
el方式：${requestScope.rkey}<br><hr>

获取sesson中的数据：<br>
老方式：<%=session.getAttribute("skey")%><br>
el方式：${sessionScope.skey}<br><hr>
获取application中的数据：<br>
老方式：<%=application.getAttribute("")%><br>
el方式：${applicationScope.akey}<br><hr>
直接获取:${skey}
</body>
</html>
