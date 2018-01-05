<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 11456
  Date: 2016/12/10
  Time: 19:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body bgcolor="#f7f7f7">
<div class="nav">
    <nav class="navbar navbar-dark bg-inverse" >
        <!-- Navbar content -->
        <a class="navbar-brand text-white margin-right margin-left24">katey2658</a>
        <ul class="nav navbar-nav">
            <li class="nav-item active">
                <a class="nav-link" href="home.jsp">首页 <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="">个人中心</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="about.jsp">关于</a>
            </li>
        </ul>
    </nav>

</div>

<div class="article">
    <div class="aheader">
        <span class="htest"><a href="">组卷</a></span><span class="htest"><a href="">发放试卷</a></span> <span class="hsearch">点此搜索试题</span>
    </div>
    <div class="line"></div>

</div>
<div class="#">

    <%--添加一个测试--%>
    <div>
        <form>
            <div>

            </div>
            <table>
                <tr>
                    <th>
                        <span>设置考试所需要的参数</span>
                    </th>
                </tr>
                <tr>
                    <td>
                        <span>测试科目</span>
                    </td>
                    <td>
                        <div>
                            <select>
                                <option value="" selected>==请选择考试课程==</option>
                                <option value="">C语言</option>
                                <option value="">操作系统</option>
                                <option value="">JavaWeb</option>
                                <option value="">数据库原理</option>
                                <option value="">JAVA</option>
                                <option value="">HTML网页设计</option>
                            </select>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>
                        <span>考试编号</span>
                    </td>
                    <td>
                        <span>课程编号</span>
                        <input type="text" >
                    </td>
                    <td>
                        <span>测试编号</span>
                        <input type="text" >
                    </td>
                </tr>

                <tr>
                    <td>
                        <span>开始和结束时间设置</span>
                    </td>

                    <td>
                        <input type="datetime"/>
                    </td>
                    <td>
                        <input type="datetime"/>
                    </td>
                </tr>

                <tr>
                    <td>
                        <span>考试时间</span>
                    </td>
                    <td>
                        <input type="text">
                    </td>
                </tr>

                <tr>
                    <td>
                        <span>习题系数设置1</span>
                    </td>
                    <td>
                        <span>所占分数百分比</span>
                        <select size="1" name="选择题目分值" >
                            <option value="0" selected>-所占总分百分比-</option>
                            <option value="100">100%</option>
                            <option value="50">50%</option>
                            <option value="30">30%</option>
                            <option value="20">20%</option>
                            <option value="10">10%</option>
                        </select>
                    </td>
                    <td>
                        <span>难度系数</span>
                        <select>
                            <option value="0" selected>-难度系数-</option>
                            <option value="10">10</option>
                            <option value="9">9</option>
                            <option value="8">8</option>
                            <option value="7">7</option>
                            <option value="6">6</option>
                            <option value="5">5</option>
                            <option value="4">4</option>
                            <option value="3">3</option>
                            <option value="2">2</option>
                            <option value="1">1</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        <span>习题系数设置2</span>
                    </td>
                    <td>
                        <span>所占分数百分比</span>
                        <select size="1" name="选择题目分值" >
                            <option value="0" selected>-所占总分百分比-</option>
                            <option value="100">100%</option>
                            <option value="50">50%</option>
                            <option value="30">30%</option>
                            <option value="20">20%</option>
                            <option value="10">10%</option>
                        </select>
                    </td>
                    <td>
                        <span>难度系数</span>
                        <select>
                            <option value="0" selected>-难度系数-</option>
                            <option value="10">10</option>
                            <option value="9">9</option>
                            <option value="8">8</option>
                            <option value="7">7</option>
                            <option value="6">6</option>
                            <option value="5">5</option>
                            <option value="4">4</option>
                            <option value="3">3</option>
                            <option value="2">2</option>
                            <option value="1">1</option>
                        </select>
                    </td>
                </tr>


                <tr>
                    <td>
                        <span>习题系数设置3</span>
                    </td>
                    <td>
                        <span>所占分数百分比</span>
                        <select size="1" name="选择题目分值" >
                            <option value="0" selected>-所占总分百分比-</option>
                            <option value="100">100%</option>
                            <option value="50">50%</option>
                            <option value="30">30%</option>
                            <option value="20">20%</option>
                            <option value="10">10%</option>
                        </select>
                    </td>
                    <td>
                        <span>难度系数</span>
                        <select>
                            <option value="0" selected>-难度系数-</option>
                            <option value="10">10</option>
                            <option value="9">9</option>
                            <option value="8">8</option>
                            <option value="7">7</option>
                            <option value="6">6</option>
                            <option value="5">5</option>
                            <option value="4">4</option>
                            <option value="3">3</option>
                            <option value="2">2</option>
                            <option value="1">1</option>
                        </select>
                    </td>
                </tr>

                <tr>
                    <td>
                        <span>习题系数设置4</span>
                    </td>
                    <td>
                        <span>所占分数百分比</span>
                        <select size="1" name="选择题目分值" >
                            <option value="0" selected>-所占总分百分比-</option>
                            <option value="100">100%</option>
                            <option value="50">50%</option>
                            <option value="30">30%</option>
                            <option value="20">20%</option>
                            <option value="10">10%</option>
                        </select>
                    </td>
                    <td>
                        <span>难度系数</span>
                        <select>
                            <option value="0" selected>-难度系数-</option>
                            <option value="10">10</option>
                            <option value="9">9</option>
                            <option value="8">8</option>
                            <option value="7">7</option>
                            <option value="6">6</option>
                            <option value="5">5</option>
                            <option value="4">4</option>
                            <option value="3">3</option>
                            <option value="2">2</option>
                            <option value="1">1</option>
                        </select>

                    </td>
                </tr>

                <tr>
                    <td>
                        <span>习题系数设置5</span>
                    </td>
                    <td>
                        <span>所占分数百分比</span>
                        <select size="1" name="选择题目分值" >
                            <option value="" selected>-所占总分百分比-</option>
                            <option value="100">100%</option>
                            <option value="50">50%</option>
                            <option value="30">30%</option>
                            <option value="20">20%</option>
                            <option value="10">10%</option>
                        </select>
                    </td>
                    <td>
                        <span>难度系数</span>
                        <select>
                            <option value="0" selected>-难度系数-</option>
                            <option value="10">10</option>
                            <option value="9">9</option>
                            <option value="8">8</option>
                            <option value="7">7</option>
                            <option value="6">6</option>
                            <option value="5">5</option>
                            <option value="4">4</option>
                            <option value="3">3</option>
                            <option value="2">2</option>
                            <option value="1">1</option>
                        </select>
                    </td>
                </tr>


            </table>
            <input type="submit" value="发布测试">
        </form>
    </div>
</div>
</body>
</html>
