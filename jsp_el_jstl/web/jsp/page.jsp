<%--
  Created by IntelliJ IDEA.
  User: Fionar
  Date: 2017/9/8
  Time: 0:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="404.jsp" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    session.setAttribute("skey", "svalue");
%>
<%=session.getAttribute("skey")%>
${sessionScope.size()}
${sessionScope.values()}
${sessionScope.get(skey)}
<%--${sessionScope.remove(skey)}--%>
</body>
</html>
