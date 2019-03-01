<%--
  Created by IntelliJ IDEA.
  User: zhangdan
  Date: 2019/1/7
  Time: 12:45
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>上传文件</title>
</head>
<body>
   <form action="/upload" method="post" enctype="multipart/form-data">
       <label for="head">设置文件</label>
       <input id="head" name="head" value="上传文件" type="file">
       <input type="submit" value="提交">
   </form>
   <c:if test="${head_data !=null}">
       <img src="${head_data}">
   </c:if>
</body>
</html>
