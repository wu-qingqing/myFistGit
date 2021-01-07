<%--
  Created by IntelliJ IDEA.
  User: 五斤斤
  Date: 2021/1/6
  Time: 15:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
    <h1>注册页面</h1>
    <form action="${pageContext.request.contextPath}/user/register" method="post">
        用户名：<input type="text" name="username"> <br>
        密 码：<input type="text" name="password"> <br>
        <input type="submit" value="立即注册">
    </form>
</body>
</html>
