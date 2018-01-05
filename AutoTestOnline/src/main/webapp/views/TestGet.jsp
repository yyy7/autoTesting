<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
  Created by IntelliJ IDEA.
  User: 11456
  Date: 2016/12/11
  Time: 11:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ page import="java.text.*"%>
<html>
<head>
    <title>试题界面</title>
    <link href="../css/bootstrap.css" rel="stylesheet">
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/testpaper.css" rel="stylesheet">
</head>
<body>
<%--头部导航栏--%>
<div class="#"></div>

<div class="nav">
    <nav class="navbar navbar-dark bg-inverse">
        <a class="navbar-brand text-white margin-right margin-left24">katey2658</a>
        <!-- <ul class="nav navbar-nav">
            <li class="nav-item "><a class="nav-link" href="home.jsp">首页
                    <span class="sr-only">(current)</span>
            </a></li>
            <li class="nav-item active"><a class="nav-link" href="">个人中心</a>
            </li>
            <li class="nav-item"><a class="nav-link" href="about.jsp">关于</a>
            </li>
        </ul> -->

        <%--<c:choose>--%>
        <%--<c:when test="${sessionScope.user!=null}">--%>
        <%--<span class="text-logined ">欢迎您，<c:out value="${sessionScope.user.getUserName}"/></span>--%>
        <%--</c:when>--%>
        <%--</c:choose>--%>

    </nav>
</div>

<div>
    <form action="testSubmit" method="post">
        <%--考试头部信息--%>
        <div class="test-bg">
            <div class="">
                <span class="course">考试科目:<c:out value="${sessionScope.testInfo.getCourseName()}"></c:out></span>
                <%-- <span><c:out value="${}"/></span> --%>
                <div class="testborder"></div>
                <ul style="list-style-type:none">
                    <li class="test-li courseno"><span><b>课程编号:<c:out value="${sessionScope.testInfo.getCourseId()}"/></b> </span>
                        <%-- <span><c:out value="${}"/></span> --%>
                    </li>
                    <li class="test-li"><span><b>测试编号:<c:out value="${sessionScope.testInfo.getTestId()}"/></b> </span>

                    </li>
                    <li class="test-li"><span><b>考试开始时间:</b> </span> <span>
									<%
                                        String datetime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                                                .format(Calendar.getInstance().getTime()); //获取系统时间
                                    %> <%=datetime%> </span> <%-- <span><c:out value="${}"/></span> --%>
                    </li>
                </ul>
            </div>
            <div>
                <c:forEach items="${sessionScope.questions}" var="q" varStatus="s">
                    <div class="">单选题</div>
                    <div class="">
                        <div class="">单选<c:out value="${s.index}"/></div>
                        <div class=""><c:out value="${q.getQuesContent()}"/></div>


                        <div>
                            <span>A:<c:out value="${q.getOptions().get(0)}"/></span><input type="radio" name="${q.getQuesId()}" value="A"/>
                        </div>
                        <div>
                            <span>B:<c:out value="${q.getOptions().get(1)}"/></span><input type="radio" name="${q.getQuesId()}" value="B"/>
                        </div>
                        <div>
                            <span>C:<c:out value="${q.getOptions().get(2)}"/></span><input type="radio" name="${q.getQuesId()}" value="C"/>
                        </div>
                        <div>
                            <span>D:<c:out value="${q.getOptions().get(3)}"/></span><input type="radio" name="${q.getQuesId()}" value="D"/>
                        </div>
                    </div>
                </c:forEach>
                <div>
                    <input class="btn rounded-right bg-primary" type="submit" value="提交" />
                </div>
            </div>
        </div>
    </form>
</div>
</body>
</html>
