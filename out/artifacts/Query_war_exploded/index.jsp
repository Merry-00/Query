<%--
Created by IntelliJ IDEA.
User: 86166
Date: 2021/4/1
Time: 10:45
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录界面</title>
    <scrip type="text/javascrip" src="./loginM.html"></scrip>
    <link rel="stylesheet" href="./css/reset.css">
    <link rel="stylesheet" href="./css/login.css">
</head>
<body>
<div class="center">
    <h1>请登录。</h1>
    <div class="login">
        <form action="http://localhost:8080/Query_war_exploded/login" method="post" onsubmit="return SignIn()">
            <div class="username">
                <input type="text" name="username" id="username" placeholder="学号Id">
                <div class="usernameInfo">
                    <span id="userInfo">  &nbsp;</span>
                </div>

            </div>
            <div class="psd">
                <input type="password" name="password" id="psd" placeholder="密码">
                <div class="passwordInfo">
                    <span id="psdInfo">  &nbsp;</span>
                </div>

            </div>
            <div class="button">
                <input id="loginbutton" type="submit" value="登录">

            </div>
            <div class="forget">
                <a href="https://iforgot.apple.com/password/verify/appleid?language=CN-ZH&app_id=2083&newWindow=true&border=false">忘了自己的 Apple ID 或密码？</a>
            </div>
            <div class="create">
                <a href="http://localhost:8080/Query_war_exploded/register.jsp">没有注册？立即注册一个。</a>
            </div>

        </form>
    </div>

</div>
<script>
    /**
     * 利用javascript和html css实现一个简单的登录功能
        分析：
        需求：
            1.有两个输入框，第一个是输入用户名，第二个是输入密码
            2.一个登录按钮，当点击登录按钮之后，要获取用户输入的信息，进行判断
                2.1判断输入框是否为空
                是---提示不能为空的信息

                2.2判断输入的用户名，密码格式是否正确
                是---进行下一步
                否---提示格式错误，并重新输入
                2.3 进行在数组中查找用户名和密码是否匹配
                    * 2.1为false 2.2为ture 2.3 为true -----(登录成功)
                    2.3为false----登录失败----(用户名不存在或者密码错误！)
        功能：
        1. 登录按钮绑定一个事件---onclick;
        2. 给事件一个方法SignIn()----当点击了登录按钮就会执行此方法


    */
    var ele = {};//定义一个对象
    //这个方法用于初始化数据和加载页面之后执行的操作函数
    window.onload=function(){

        //失焦时进行验证---调用checkname()和checkPsd()方法
        //存放各个input字段的obj
        ele = {
            //有两个变量
            username: document.getElementById("username"),
            password: document.getElementById("psd"),
        };
        //当username失去焦点时检测
        ele.username.onblur = function(){
            checkName(ele.username.value);
        }
        //当password失去焦点时检测
        ele.password.onblur = function(){
            checkPassword(ele.password.value);
        }
    }
    /**
        SignIn()用于当点击登录按钮之后，先进行格式是否匹配判断，在进行用户名和密码是否匹配判断
        当匹配成功之后，会跳转到登录成功的界面，否则提示登录失败的信息。
        跳转html界面使用的是window.location.href="";
    */
    function SignIn(){
        var infoall=document.getElementById("psdInfo");
        if(check()){
            infoall.innerHTML="";
            //window.location.href="http://127.0.0.1:5500/%E4%BB%BFApple%E5%95%86%E5%9F%8E%E9%A1%B9%E7%9B%AE%E5%AE%9E%E9%AA%8C%E4%B8%80/loginM.html";
            return true;
            // window.location.href= "http://localhost:8080/demo_war_exploded/loginM.html"
        }
        else{
            var y="输入的格式不对！";
            infoall.innerHTML=y+"";
            return false;
        }
    }
    /**
        *checkName()用户检测用户输入的用户名是否为空以及用户名格式是否正确
    */
    function checkName(username){
        var info=document.getElementById("userInfo").value;

        if(username!=""){
            var reg1=new RegExp("/^\\d{10}$/");//格式为十位纯数字
            var flag=reg1.test(username);
            info.innerHTML="";
            return flag;
        }
        else{
            var x="用户名不能为空！"
            info.innerHTML=x+"";
            return false;
        }

    }
    /**
     * checkPassword()用于检测用户输入的密码是否为空以及密码格式是否输入正确。
     */
    function checkPassword(password){

        var infopsd=document.getElementById("psdInfo").value;
        if(password!=""){
            var reg2=new RegExp("^[a-zA-Z0-9_]{6,12}$");//6-12位的字母，数字，下划线
            infopsd.innerHTML="";
            return reg2.test(password);
        }
        else{
            var psdinfo="密码不能为空！";
            infopsd.innerHTML=psdinfo+"";
            return false;
        }

    }
    //提交表单时进行check()验证
    function check(){
        var nameok = false;
        var passwordok = false;
        if(checkName(ele.username.value)){
            nameok = true;
        }
        if(checkPassword(ele.password.value)){
            passwordok = true;
        }
        if(nameok && passwordok){
            return true;
        }
        return false;
    }
</script>
</body>
</html>
