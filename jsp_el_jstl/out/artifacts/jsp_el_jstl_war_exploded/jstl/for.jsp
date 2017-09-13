<%--
  Created by IntelliJ IDEA.
  User: Fionar
  Date: 2017/9/13
  Time: 22:28
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach begin="1" end="10" step="1" var="i">
${i}
</c:forEach><br>
<hr>
<c:forEach begin="1" end="20" step="2" var="i">
    ${i}
</c:forEach><br>
<hr>
<c:forEach begin="1" end="20" step="2" var="i" varStatus="vs">
    ${i}--${vs.count}---${vs.current}<br>
</c:forEach><br>
</body>
</html>
