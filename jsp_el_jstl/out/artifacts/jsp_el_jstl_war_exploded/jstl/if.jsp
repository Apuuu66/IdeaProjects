<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Fionar
  Date: 2017/9/12
  Time: 21:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${3>4}">
    <c:out value="3大于4"/>
</c:if>
<c:if test="${3>4}">
    <c:out value="3不大于4"/>
</c:if>
<c:out value="3不大于4"/>
<c:out value="dfwf"/>
</body>
</html>
