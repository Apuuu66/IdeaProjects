<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: Fionar
  Date: 2017/9/11
  Time: 22:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    request.setAttribute("arr",new java.lang.String[]{"aa","bb","cc"});
    ArrayList arrayList = new ArrayList();
    arrayList.add("dd");
    arrayList.add("ee");
    request.setAttribute("list",arrayList);
    HashMap hashMap = new HashMap();
    hashMap.put("r1","k1");
    hashMap.put("r2","k2");
    hashMap.put("r3","k3");
    request.setAttribute("map",hashMap);

%>
获取域中的数组：<br>
老方式：<%=((String [])request.getAttribute("arr"))[1]%><br>
el方式:${arr[1]}<br>

获取域中的list：<br>
老方式：<%=((List)request.getAttribute("list")).get(1)%><br>
el方式:${list.get(1)}<br>
list大小：${list.size()}<br>

获取域中的map：<br>
老方式：<%=((HashMap)request.getAttribute("map")).get("r1")%><br>
<%--el方式:${map.r1}<br>--%>
${map.get("r1")}
<%--${requestScope.map.r1}--%>
</body>
</html>
