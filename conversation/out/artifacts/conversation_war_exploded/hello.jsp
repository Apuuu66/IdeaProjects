<%--
  Created by IntelliJ IDEA.
  User: Snoopy
  Date: 2017/8/30
  Time: 2:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
jsp!!!!
<%//镶嵌代码块
    int i=4;
    System.out.println(i);
%>
<%=k%>//向网页输出内容
<%=i%>
<%
    out.print("hello");//out.print();为内部对象
%>
<%!
    int k=4;//定义成员
%>
</body>
</html>
