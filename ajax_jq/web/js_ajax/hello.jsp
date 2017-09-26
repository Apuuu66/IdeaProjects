<%--
  Created by IntelliJ IDEA.
  User: Fionar
  Date: 2017/9/25
  Time: 0:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<input type="button" value="点我" onclick="btnClick()">
</body>
<script>
    function btnClick() {
        //创建核心对象
        var xmlhttp = null;
        if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
            xmlhttp = new XMLHttpRequest();
        }
        else {// code for IE6, IE5
            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        }
        //编写回调函数
        xmlhttp.onreadystatechange = function(){
            alert(xmlhttp.readyState);
        }
        //open 设置请求方式和请求路径
        xmlhttp.open("get", "${pageContext.request.contextPath}/ajax1", true);
        //send
        xmlhttp.send(null);
    }
</script>
</html>
