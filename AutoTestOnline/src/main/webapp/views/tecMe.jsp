<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 11456
  Date: 2016/12/10
  Time: 20:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/style2.css" rel="stylesheet">
</head>
<body>

<%--头部--%>
<div class="nav">
    <nav class="navbar navbar-dark bg-inverse" >
        <!-- Navbar content -->
        <a class="navbar-brand text-white margin-right margin-left24">katey2658</a>
        <ul class="nav navbar-nav">
            <li class="nav-item ">
                <a class="nav-link" href="home.jsp">首页 <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="">个人中心</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="about.jsp">关于</a>
            </li>
        </ul>
        <a href="userExit">
            <span class="form-inline navbar-form bg-inverse right-exit text-logined">退出</span>
        </a>
    </nav>
</div>

<%--正在进行的测试--%>


<div class="table-align-center row">
    <h4>测试正在进行中</h4>
    <c:forEach items="${requestScope.testInfosNow}" var="now">
        <div class="card-me col-sm-3 ">
            <div class="card-block-me">
                <ul class="list-group">
                    <li class="list-group-item disabled">
                        <h4 class="card-title"><c:out value="计算机网络"/></h4>
                    </li>
                    <li class="list-group-item">
                        <span>课程编号:</span>
                        <span><c:out value="${now.getCourseId()}"/></span>
                        <input type="hidden" name="courseId" value="${now.getCourseId()}"/>
                    </li>
                    <li class="list-group-item">
                        <span>测试编号:</span>
                        <span><c:out value="${now.getTestId()}"/></span>
                        <input type="hidden" name="testId" value="${now.getTestId()}"/>
                    </li>

                    <li class="list-group-item">
                        <span>考试开始时间:</span>
                        <span><c:out value="${now.getStartTime()}"/></span>
                    </li>
                    <li class="list-group-item">
                        <span>考试结束时间:</span>
                        <span><c:out value="${now.getEndTime()}"/></span>
                    </li>
                    <li class="list-group-item">
                        <span>考试时间:</span>
                        <span><c:out value="${now.getTime()}"/></span>
                    </li>
                </ul>
            </div>
            <%--进度条--%>
            <span>进行状况：
                <c:out value="${now.getNumActual()}"/>
                    <span>/</span>
                <c:out value="${now.getJoinNum()}"/>
            </span>
            <div>
                <progress class="progress progress-success"
                          value="${(now.getNumActual()*100)/now.getJoinNum()}"
                          max="100"/>

            </div>
        </div>
    </c:forEach>

</div>

<br>
<div class="table-align-center row">
    <%--往次的测试--%>
    <h3>测试已经结束</h3>
        <c:forEach items="${requestScope.testInfosPass}" var="pass">
            <div class="card-me col-sm-3 ">
                <div class="card-block-me">
                    <ul class="list-group">
                        <li class="list-group-item disabled">
                            <h4 class="card-title"><c:out value="java"/></h4>
                        </li>
                        <li class="list-group-item">
                            <span>课程编号:</span>
                            <span><c:out value="${pass.getCourseId()}"/></span>
                            <input type="hidden" name="courseId" value="${pass.getCourseId()}"/>
                        </li>
                        <li class="list-group-item">
                            <span>测试编号:</span>
                            <span><c:out value="${pass.getTestId()}"/></span>
                            <input type="hidden" name="testId" value="${pass.getTestId()}"/>
                        </li>

                        <li class="list-group-item">
                            <span>考试开始时间:</span>
                            <span><c:out value="${pass.getStartTime()}"/></span>
                        </li>
                        <li class="list-group-item" >
                            <span>考试结束时间:</span>
                            <span><c:out value="${pass.getEndTime()}"/></span>
                        </li>
                        <li class="list-group-item">
                            <span>考试时间:</span>
                            <span><c:out value="${pass.getTime()}"/></span>
                        </li>
                    </ul>
                </div>
                    <%--进度条--%>
                <span>完成状况：
                    <c:out value="${pass.getNumActual()}"/>
                        <span>/</span>
                    <c:out value="${pass.getJoinNum()}"/>
                 </span>
                <div>
                    <progress class="progress progress-danger"
                              value="${(pass.getNumActual()*100)/pass.getJoinNum()}"
                              max="100"/>
                </div>
            </div>
        </c:forEach>

</div>

<script src="../js/bootstrap.js"/>
</body>
</html>
