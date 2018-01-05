<%--
  Created by IntelliJ IDEA.
  User: 11456
  Date: 2016/12/4
  Time: 20:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet"  href="../css/style2.css">
    <link href="../css/bootstrap.css" rel="stylesheet">

</head>
<body class="bg">
<%--头部--%>
<div>

</div>
<%--表单--%>
<form  action="register"  method="post">
    <div class="form-signin-heading reall" >
        <h1 class="retitle form-signin-heading">注册</h1>
        <div class="form-group1 row">
            <label for="inputEmail3" class="col-sm-2 form-control-label tecno">教工号:</label>
            <div class="col-sm-10 ">
                <input type="text" class="form-control1 " name="userId" id="inputEmail3" placeholder="请输入教工号">
            </div>
        </div>

        <div class="form-group1 row">
            <label for="inputEmail4" class="col-sm-2 form-control-label tecno">邮箱地址:</label>
            <div class="col-sm-10">
                <input type="email" class="form-control1"  name="userMail" id="inputEmail4" placeholder="请输入邮箱地址">
            </div>
        </div>

        <div class="form-group1 row">
            <label for="inputEmail5" class="col-sm-2 form-control-label tecno">真实姓名:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control1"  name="userName" id="inputEmail5" placeholder="请输入真实姓名">
            </div>
        </div>

        <div class="form-group1 row">
            <label for="inputEmail6" class="col-sm-2 form-control-label tecno">密码:</label>
            <div class="col-sm-10">
                <input type="password" class="form-control1" name="userPwd" id="inputEmail6" placeholder="请输入一个密码">
            </div>
        </div>

        <div class="form-group1 row">
            <label for="inputEmail7" class="col-sm-2 form-control-label tecno">重复密码:</label>
            <div class="col-sm-10">
                <input type="password" class="form-control1" id="inputEmail7" name="userPwdAgain" placeholder="请再次输入密码">
            </div>
        </div>

        <span class="tecno" >性别：</span>
        <input type="radio" name="userSex" class="" value="男" checked="checked"/><span>男</span>
        <input type="radio" name="userSex" class="" value="女"/><span>女</span>


        <span class="tecno age">年龄：</span>
        <select class="" name="userAge">
            <option value ="10" >10</option>
            <option value ="11">11</option>
            <option value ="12">12</option>
            <option value ="13">13</option>
            <option value ="14">14</option>
            <option value ="15">15</option>
            <option value ="16">16</option>
            <option value ="17">17</option>
            <option value ="18">18</option>
            <option value ="19">19</option>
            <option value ="20" selected="selected">20</option>
            <option value ="21">21</option>
            <option value ="22">22</option>
            <option value ="23">23</option>
            <option value ="24">24</option>
            <option value ="25">25</option>
            <option value ="26">26</option>
            <option value ="27">27</option>
            <option value ="28">28</option>
            <option value ="29">29</option>
            <option value ="30">30</option>
        </select><br>
        <!--  <span class="tecno">居住地：</span>
         <input type="text" name="" class="address" placeholder="家庭地址" > <br> -->

        <input type="submit" class="rebtn" value="注册"><br>
        <a href="login.jsp">
            <span class="btn-link1">已经有账号，去登录</span>
        </a>
    </div>
</form>
</body>
</html>