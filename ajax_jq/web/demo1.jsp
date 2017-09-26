<%--
  Created by IntelliJ IDEA.
  User: Fionar
  Date: 2017/9/26
  Time: 18:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="#">
    <table>
        <tr>
            <td>用户名</td>
            <td><input type="text" name="username" onblur="checkUsername(this)"></td>
            <td><p id="name"></p></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="password" name="password"></td>
            <td><p id="pwd"></p></td>
        </tr>
        <tr>

            <td colspan="2"><input type="submit" id="sub"></td>
        </tr>
    </table>

</form>
</body>
<script>
    function checkUsername(obj) {
//        document.getElementById("name").innerHTML = "名字已存在";
        //创建核心对象
        var xmlhttp = null;
        if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
            xmlhttp = new XMLHttpRequest();
        }
        else {// code for IE6, IE5
            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        }
        //编写回调函数
        xmlhttp.onreadystatechange = function () {
            if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
//                alert(xmlhttp.responseText);
                if (xmlhttp.responseText == 1) {
                    document.getElementById("name").innerHTML = "<font color='green'>用户名可以使用</font>";

                    document.getElementById("sub").disabled = false;
                } else {
                    document.getElementById("name").innerHTML = "<font color='red'>用户名已被占用</font>";
                    document.getElementById("sub").disabled = true;
                }
            }
        }

        //open 设置请求方式和请求路径
        xmlhttp.open("get", "${pageContext.request.contextPath}/checkUsername4Ajax?username=" + obj.value, true);
        //send
        xmlhttp.send();
    }
</script>
</html>
