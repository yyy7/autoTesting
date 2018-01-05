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
    <meta charset='UTF-8'>
    <meta content='IE=edge' http-equiv='X-UA-Compatible'>
    <meta content='学生教师端考试系统' name='Keywords'>
    <meta content='学生教师端考试系统' name='Description'>
    <title>
        高校课程在线考试平台
    </title>
    <meta content="authenticity_token" name="csrf-param" />
    <meta content="ioxh3Y3FNn264/TSE5+CWS9TQBJYRbFDK72hvnItvT4=" name="csrf-token" />
    <script type="text/javascript">
        //<![CDATA[
        window.gon = {};gon.gravatar_url="http://www.gravatar.com/avatar/%{hash}?s=%{size}&d=mm";
        //]]>
    </script>

    <link href="css/style3.css" media="screen" rel="stylesheet" type="text/css" />
    <link href="css/application-a2e2d63c67b50ae82a25ed3ebb608bda.css" media="screen" rel="stylesheet" type="text/css" />
    <script src="js/app-d39deca01efdff5c06ab05b6f8d09c50.js" type="text/javascript"></script>
    <script src="js/style.js" type="text/javascript"></script>
    <meta content="authenticity_token" name="csrf-param" />
    <meta content="ioxh3Y3FNn264/TSE5+CWS9TQBJYRbFDK72hvnItvT4=" name="csrf-token" />
</head>
<body class='ui_basic' id='dashboard-show'>
<header class='ui grey menu grid page fixed noborder' id='git-header-nav'>
    <div class='git-header'>
        <div class='item gitosc-logo' style='padding:0;'>
            <a href="/"><img  src='image/logo1.png' >
            </a></div>
        <a href="home.jsp" class="item" style="font-size: 1.05rem">首页</a>
        <a href="about.jsp" class="item" style="font-size: 1.05rem" target="_blank">关于</a>
        <a href="stuMe" class="item" style="font-size: 1.05rem">学生课程中心</a>
        <a href="tecMe" class="item" style="font-size: 1.05rem">教师课程中心</a>
        <a href="course" class="item" style="font-size: 1.05rem" target="_blank">课程中心
            <sup style='color: #CA1212;'>
                new
            </sup>
        </a><form accept-charset="UTF-8" action="/search" class="item search_padding" id="projects-search-form" method="get"><div style="margin:0;padding:0;display:inline"><input name="utf8" type="hidden" value="&#x2713;" /></div>
        <div class='ui icon left mini input'>
            <input autocomplete="off" id="search_top-search-input" name="search" placeholder="搜索课程..." style="border: 0px; background-color: #efefef" type="text" />
            <i class='search link icon' id='projects-search'></i>
            <input id="group_id" name="group_id" type="hidden" />
            <input id="project_id" name="project_id" type="hidden" />
        </div>
    </form>

        <div class='right menu userbar' id='git-nav-user-bar'>
            <a href="register.jsp" class="item">注册
            </a><a href="Login.jsp" class="item">登录
        </a>
        </div>
    </div>
</header>
<div class='ui grid page fixed-notice-messages'>
    <div class='jumbotron'>
        <div class='header' id='sologan'>
            <div class='title'>
                高校课程在线考试平台
            </div>
            <div class='content-home'>
                不只是考试，我们更注重学生自我能力的提高！
            </div>
            <div class='operation'>
                <a href="register.jsp" class="login-btn ui button red">我要加入</a>
                <a href="Login.jsp" class="login-btn ui button grey ">已有账户?登录-&gt;</a>
            </div>
        </div>
    </div>
</div>
<div class='i' id='sologan'>
    <div class='left-i'>
        <div class='icon-i'>
            <img  src="image/logolz.png" />
        </div>
        <div class='function'>
            完全免费
        </div>
        <div class='brief'>
            老师、学生端只需要注册账号即可享用网站所有服务。
        </div>
    </div>
    <div class='right-i'>
        <div class='icon-i'>
            <img  src="image/logolz.png" />
        </div>
        <div class='function'>
            多种题型
        </div>
        <div class='brief'>
            里面有多达上千个题目，老师可以设置难度，保证每位学生抽到的题目会不一样。
        </div>
    </div>
    <div class='clear'></div>
    <div class='left-i'>
        <div class='icon-i'>
            <img  src="image/logolz.png" />
        </div>
        <div class='function'>
            质量保证
        </div>
        <div class='brief'>
            题库中的每道题目都是多年考试记载下来的经典题型。
        </div>
    </div>
    <div class='right-i'>
        <div class='icon-i'>
            <img  src="image/logolz.png" />
        </div>
        <div class='function'>
            网站服务平台
        </div>
        <div class='brief'>
            提供关于教师端出卷、学生端考试所需的技术服务。
        </div>
    </div>
</div>
<div class='contrast'>
    <div class='icon-help'>
        <a href="/contrast" class="col">为什么使用该平台?</a>
    </div>
</div>
<div class='testimonial'>
    <div class='cent1'>我们提供这些课程</div>
    <div class='testal'>
        <div class='swiper-container'>
            <div class='swiper-wrapper-change'>
                <div class='swiper-slide'>
                    <div class='shadow' id='sh1'>
                        <div class='project-wrap'>
                            <div class='project-title'>
                                <a href="/jfinal/jfinal" target="_blank">计算机网络
                                </a></div>
                            <div class='project-description'>计算机网络是大三学生开始进行的一个课程，也是考研学生必考科目之一，是学习软件和硬件学生都必备的知识，其重要性可想而知。:)</div>
                            <div class='swiper-pagination'></div>
                        </div>
                    </div>
                </div>
                <div class='swiper-slide'>
                    <div class='shadow' id='sh2'>
                        <div class='project-wrap'>
                            <div class='project-title'>
                                <a  target="_blank">java语言
                                </a></div>
                            <div class='project-description'>java语言具有安全、跨平台、面向对象、简单、适用于网络等显著特点，当时以web为主要形式的互联网正在迅猛发展，java语言的出现迅速引起所有程序员和软件公司的极大关注，程序员们纷纷尝试用java语言编写网络应用程序，并利用网络把程序发布到世界各地进行运行。</div>
                            <div class='swiper-pagination'></div>
                        </div>
                    </div>
                </div>
                <div class='swiper-slide'>
                    <div class='shadow' id='sh3'>
                        <div class='project-wrap'>
                            <div class='project-title'>
                                <a target="_blank">软件工程
                                </a></div>
                            <div class='project-description'>件工程是一门研究用工程化方法构建和维护有效的、实用的和高质量的软件的学科。它涉及程序设计语言、数据库、软件开发工具、系统平台、标准、设计模式等方面。</div>
                            <div class='swiper-pagination'></div>
                        </div>
                    </div>
                </div>

                <div class='swiper-pagination'></div>
            </div>
        </div>
    </div>
</div>
<footer id='git-footer-main'>
    <div class='ui container'>
        <div class='ui two column grid'>
            <div class='column'>
                <div class='ui two column grid'>
                    <div class='column'>
                        <div class='ui link list'>
                            <div class='item'>
                                <a href="/terms" class="item">使用条款</a>
                            </div>
                            <div class='item'>
                                <a href="/piracy" class="item">隐私与安全</a>
                            </div>
                            <div class='item'>
                                <a href="mailto:git@oschina.cn" class="item" onclick="return false;" title="Email: git#oschina.cn">联系我们
                                </a></div>
                        </div>
                    </div>
                    <div class='column'>
                        <div class='ui link list'>
                            <div class='item'>
                                <a href="/appclient" class="item">APP下载</a>
                            </div>
                            <div class='item'>
                                <a href="/links.html" class="item">友情链接</a>
                            </div>
                            <div class='item'>QQ交流群: 515965326</div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</footer>
</body>
</html>
