<%--
  Created by IntelliJ IDEA.
  User: 86166
  Date: 2021/4/7
  Time: 21:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>创建您的ID</title>
    <link rel="stylesheet" href="./css/reset.css">
    <link rel="stylesheet" href="./css/register.css">


</head>
<body>
<%--QQ邮箱注册,密码,重复密码,QQ邮箱验证码--%>
<div class="title">
    <p>
        只需一个  ID，您即可进入学生管理系统。已有  ID？<a href="https://iforgot.apple.com/appleid">在此查找 ></a>
    </p>
</div>
<<form class="register" action="http://localhost:8080/demo_war_exploded/register" method="post" onsubmit="return SignUp()">
    <div class="first">
        <input id="email" name="email" type="text" placeholder="QQ邮箱">
        <div class="emailInfo">
            <span id="emailInfo">&nbsp;</span>
        </div>
    </div>
    <div class="center">
        <div class="studentId">
            <input id="student_id" name="student_id" type="text" placeholder="学号">
            <div class="idInfo">
                <span id="idInfo">&nbsp;</span>
            </div>
        </div>
        <div class="password">
            <input name="password" type="password" id="password" placeholder="密码">
            <div class="passwordInfo">
                <span id="passwordInfo">&nbsp;</span>
            </div>
        </div>
        <div class="repassword">
            <input type="password" name="" id="rePassword" placeholder="确认密码">
            <div class="rspInfo">
                <span id="rspInfo">&nbsp;</span>
            </div>
        </div>
        <div class="veritefy clearfix">
        <div class="code">
            <input id="code" name="code" type="text" placeholder="验证码">
            <div class="codeInfo">
                <span id="codeInfo">&nbsp;</span>
            </div>
        </div>
        <div class="send">
            <button>发送验证码</button>
        </div>
        </div>
        <div class="button">
            <input type="submit" value="注册">
        </div>
    </div>

</form>
<script>
    /*
        注册分析：
        需求分析：
        1. 判断输入的信息是否合法
        2.当检查合法之后，点击注册按钮会将信息写入数据库中；
        3.如果写入成功---生成Apple id---并将id 和密码写入到用户信息表中
        4.在用户表中查询是否有记录---有记录则表示注册成功
        5.返回登录界面---用户进行登录

     */


    function SignUp(){
        var infoAll=document.getElementById("rspInfo");
        if(check()){
            alert(check());
            infoAll.innerHTML="";
            return true;//格式验证正确
        }
        else{
            infoAll.innerHTML="格式不正确";
            return false;
        }
    }
    var ele = {};//定义一个对象
    //这个方法用于初始化数据和加载页面之后执行的操作函数
    window.onload=function(){
        //失焦时进行验证---
        //存放各个input字段的obj
        ele = {
            //有五个变量
            email: document.getElementById("email"),
            student_id: document.getElementById("student_id"),
            password:document.getElementById("password"),
            rePassword:document.getElementById("rePassword"),
            code:document.getElementById("code")

        };
        //1.当email失去焦点时检测
        ele.email.onblur = function(){
            checkEmail(ele.email.value);
        }

        //2.当Id失去焦点时检测
        ele.student_id.onblur = function(){
            checkId(ele.student_id.value);
        }

        //3.当password失去焦点时检测
        ele.password.onblur = function(){
            checkPassword(ele.password.value,ele.rePassword.value);
        }

        //4.当rePassword失去焦点时检测
        ele.rePassword.onblur = function(){
            checkPassword(ele.password.value,ele.rePassword.value);
        }
        //5.当code失去焦点时检测
        ele.code.onblur=function () {
            checkCode(ele.code.value);
        }

    }

    /*
    全局变量
     */
    var emailInfo=document.getElementById("emailInfo");
    var idInfo=document.getElementById("idInfo");
    var passwordInfo=document.getElementById("passwordInfo");
    var rspInfo=document.getElementById("rspInfo");
    var codeInfo=document.getElementById("codeInfo");

    function checkEmail(email){
        var email=document.getElementById("email").value;
        if(email!=""){
            var reg=new RegExp("[1-9]\\d{7,10}@qq\\.com");
            if(reg.test(email)){
                emailInfo.innerHTML="";
                return true;//email格式正确
            }
            else{
                emailInfo.innerHTML="email格式不正确";
                //email格式不正确
                return false;
            }
        }
        else{
            //email不能为空
            emailInfo.innerHTML="email不能为空";
            return false;
        }
    }
    function checkId(student_id) {
        var student_id=document.getElementById("student_id").value;
        var reg3=new RegExp("^\\d{10}$");
        if(student_id!=""){
            if(reg3.test(student_id)){
                return true;//ID格式正确
            }
            else{
                //ID格式不正确
                idInfo.innerHTML="ID格式不正确";
                return false;
            }
        }
        else{
            //ID不能为空
            idInfo.innerHTML="ID不能为空";
            return false;
        }
    }
    function checkCode(code){
        var code=document.getElementById("code").value;
        if(code!=""){
                codeInfo.innerHTML="";
                return true;//验证码格式正确

        }
        else{
            //验证码不能为空
            codeInfo.innerHTML="验证码不能为空";
            return false;
        }
    }
    function checkPassword( password, rePassword){
        var password=document.getElementById("password").value;
        var rePassword=document.getElementById("rePassword").value;

        if(password!=""&&rePassword!=""){
            var reg2=new RegExp("^[a-zA-Z0-9_]{6,12}$");//6-12位的字母，数字，下划线
            var flag=reg2.test(password);
            if(flag&&password==rePassword){
                return true;
            }
            else if(!flag){
                //密码格式错误
                passwordInfo.innerHTML="密码格式错误";
                return false;
            }
            else if(password!=rePassword){
                rspInfo.innerHTML="两次密码输入不对";
                //密码两次输入不对
                return false;
            }
        }
        else if(password=""){
            //第一次密码不能为空
            passwordInfo.innerHTML="密码不能为空";
            return false;
        }
        else{
            //第二次密码不能为空
            rspInfo.innerHTML="密码不能为空";
            return false;
        }
    }
    function check(){
        var email=document.getElementById("email").value;
        var student_id=document.getElementById("student_id").value;
        var password=document.getElementById("password").value;
        var rePassword=document.getElementById("rePassword").value;
        var code=document.getElementById("code").value;
        var emailFlag=false;
        emailFlag=checkEmail(email);
        var idFlag=false;
        idFlag=checkId(student_id);
        var psdFlag=false;
        psdFlag=checkPassword(password,rePassword);
        var rspFlag=false;
        rspFlag=checkPassword(password,rePassword);
        var codeFlag=false;
        codeFlag=checkCode(code);
        if(emailFlag&&idFlag&&psdFlag&&rspFlag&&codeFlag){
            return true;
        }
        else{
            return false;//验证不通过
        }

    }
</script>
</body>
</html>
