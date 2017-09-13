<%--
  Created by IntelliJ IDEA.
  User: Fionar
  Date: 2017/9/7
  Time: 22:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <a href="/el_jstl/jsp/page.jsp">page指令</a><br>
  <a href="/el_jstl/jsp/include/include.jsp">include指令</a><br>
  <a href="action/forward.jsp">jsp动态标签-forward</a><br>
  <a href="action/include.jsp">jsp动态标签-include</a><br>
  <a href="el/demo1.jsp">el-获取简单数据</a><br>
  <a href="el/demo2.jsp">el-获取复杂数据</a><br>
  <a href="el/demo3.jsp">el-javabean导航</a><br>
  <a href="el/demo4.jsp">el-动态获取项目名</a><br>
  <a href="jstl/if.jsp">c-if</a><br>
  <a href="${pageContext.request.contextPath}/jstl/for1.jsp">jstl-foreach遍历List</a>
  </body>
</html>
