<%@ page import="com.katey2658.web.entity.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 11456
  Date: 2016/12/4
  Time: 20:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>home</title>
    <link href="../css/bootstrap.css" rel="stylesheet">
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/style2.css" rel="stylesheet">
</head>
<body>

<%--导航条--%>
<nav class="navbar navbar-dark bg-inverse" >
    <!-- Navbar content -->
    <a class="navbar-brand text-white margin-right margin-left24">katey2658</a>
    <ul class="nav navbar-nav">
        <li class="nav-item active">
            <a class="nav-link" href="home.jsp">首页 <span class="sr-only">(current)</span></a>
        </li>
        <li class="nav-item">
            <c:choose>
                <c:when test="${(sessionScope.user!=null)&&sessionScope.user.getUserId().startsWith('T')}">
                    <a class="nav-link" href="tecMe">个人中心</a>
                </c:when>

                <c:when test="${sessionScope.user!=null}">
                    <a class="nav-link" href="stuMe">个人中心</a>
                </c:when>

                <c:otherwise>
                    <a class="nav-link" href="login.jsp">个人中心</a>
                </c:otherwise>
            </c:choose>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="about.jsp">关于</a>
        </li>
    </ul>

    <form  action="search" class="form-inline navbar-form bg-inverse right">
        <input class="form-control" type="text" placeholder="课程、测试、知识库">
        <button class="btn btn-success-outline margin-right" type="submit">搜索</button>


        <c:choose>
        <c:when test="${sessionScope.user!=null}">
            <span class="text-logined ">欢迎您，<c:out value="${sessionScope.user.getUserName()}"/></span>
            </div>
        </c:when>
        <c:otherwise>
            <a href="login.jsp" class="">
            <button type="button" class="btn btn-primary pull-right">登录</button>
            </a>
        </c:otherwise>
        </c:choose>

    </form>
</nav>


<div class="jumbotron container-height">
    <h1 class="display-3">Hello, world!</h1>
    <p class="lead">This is a simple hero unit, a simple jumbotron-style component for calling extra attention to featured content or information.</p>
    <hr class="m-y-md">
    <p>It uses utility classes for typography and spacing to space content out within the larger container.</p>
    <p class="lead">


        <a class="btn btn-primary btn-lg" href="stuMe" role="button">去参加测试</a>
    </p>
</div>
<script src="../js/bootstrap.js"/>
</body>
</html>
