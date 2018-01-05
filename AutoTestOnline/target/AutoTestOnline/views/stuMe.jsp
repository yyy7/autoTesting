<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 11456
  Date: 2016/12/10
  Time: 19:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <link href="../css/bootstrap.css" rel="stylesheet">
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/style2.css" rel="stylesheet">
</head>
<body>
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
        <%--<c:choose>--%>
            <%--<c:when test="${sessionScope.user!=null}">--%>
                <%--<span class="text-logined ">欢迎您，<c:out value="${sessionScope.user.getUserName}"/></span>--%>
            <%--</c:when>--%>
        <%--</c:choose>--%>

    </nav>
</div>

<%--要参加的考试的信息--%>
<div class="article container-fluid bg-faded padding30">
    <%--考试信息详细--%>
    <div class="div-center">
           <c:forEach items="${requestScope.testInfos}" var="info">
               <form action="testJoin" method="post">
                   <div class="card-me col-sm-3 ">
                       <div class="card-block-me">
                           <ul class="list-group">
                               <li class="list-group-item disabled">
                                   <h4 class="card-title"><c:out value="计算机网络"/></h4>
                               </li>
                               <li class="list-group-item">
                                   <span>课程编号:</span>
                                   <span><c:out value="${info.getCourseId()}"/></span>
                                   <input type="hidden" name="courseId" value="${info.getCourseId()}"/>
                               </li>

                               <li class="list-group-item">
                                   <span>测试编号:</span>
                                   <span><c:out value="${info.getTestId()}"/></span>
                                   <input type="hidden" name="testId" value="${info.getTestId()}"/>
                               </li>

                               <li class="list-group-item">
                                   <span>考试开始时间:</span>
                                   <span><c:out value="${info.getStartTime()}"/></span>
                               </li>
                               <li class="list-group-item">
                                   <span>考试结束时间:</span>
                                   <span><c:out value="${info.getEndTime()}"/></span>
                               </li>
                               <li class="list-group-item">
                                   <span>考试时间:</span>
                                   <span><c:out value="${info.getTime()}"/></span>
                               </li>
                               <li class="list-group-item">
                                   <span>考试分数：</span>
                               </li>
                           </ul>
                           <input type="submit" class="btn btn-primary " value="开始测试"/>
                       </div>
                   </div>
               </form>
       </c:forEach>
    </div>
    <%--参加考试--%>

</div>

<div class="table-align-center ">
    <h4 class="#">往次考试记录</h4>
    <table class="table table-striped ">
        <thead>
        <tr>
            <th>课程编号</th>
            <th>课程名</th>
            <th>测试编号</th>
            <th>参加测试时间</th>
            <th>用时（分）</th>
            <th>成绩</th>
        </tr>
        </thead>
       <tbody>
       <c:forEach items="${requestScope.scores}" var="t" >
           <tr>
               <td><c:out value="${t.getCourseId()}"/> </td>
               <td><c:out value="${t.getCourseName()}"/></td>
               <td><c:out value="${t.getTestId()}"/></td>
               <td><c:out value="${t.getStartTime()}"/></td>
               <td><c:out value="${t.getUseTime()}"/></td>
               <td><c:out value="${t.getScore()}"/></td>
           </tr>
       </c:forEach>
       </tbody>
    </table>
</div>

<div class="footer">

</div>
<script src="../js/bootstrap.js"/>
</body>
</html>
