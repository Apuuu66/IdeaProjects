<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Fionar
  Date: 2017/9/13
  Time: 22:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    List l = new ArrayList();
    l.add(11);
    l.add(22);
    l.add(33);
    request.setAttribute("list", l);
%>
<c:forEach items="${list}" var="n">
    ${n}
</c:forEach>
</body>
</html>
