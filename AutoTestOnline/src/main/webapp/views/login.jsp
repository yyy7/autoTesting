<%--
  Created by IntelliJ IDEA.
  User: 11456
  Date: 2016/12/4
  Time: 20:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<html>
<head>
    <title>Title</title>

    <!-- CSS -->
    <link href="../css/bootstrap.css" rel="stylesheet">
    <link rel="stylesheet"  href="../css/reset.css" >
    <link rel="stylesheet"  href="../css/supersized.css">
    <link rel="stylesheet"  href="../css/style.css">

</head>
<body>
<div class="page-container" >
    <h1 class="form-signin-heading">登录</h1>
    <form action="login" method="post">
        <input type="text" name="userName"  class="form-control" placeholder="请输入您的用户名！"/><br>
        <input type="password" name="userPwd"  class="form-control" placeholder="请输入您的用户密码！"/><br>
        <input type="hidden" name="page" value="${requestScope.page}"/>
        <input type="submit" class="btn btn-lg btn-primary btn-block" value="登录"/><br/>
        <a href="register.jsp"><input type="button" class="btn btn-lg btn-warning btn-block " value="注册"></a>
    </form>
</div>
<%--JS--%>
<script src="../js/bootstrap.js"/>
</body>
</html>
