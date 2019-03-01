<%--
  Created by IntelliJ IDEA.
  User: zhangdan
  Date: 2019/1/7
  Time: 11:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>

   <form method="post" action="/login">
       <label for="username"> 用户名：</label><input type="text" id="username" value="" name="username" placeholder="请输入用户名">
       <label for="password"> 密码：</label><input type="text" id="password" value="" name="password" placeholder="请输入密码">
       <input type="submit" value="登录">
   </form>
</body>
</html>
