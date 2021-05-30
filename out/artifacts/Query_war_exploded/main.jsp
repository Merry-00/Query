<%--
  Created by IntelliJ IDEA.
  User: 86166
  Date: 2021/4/27
  Time: 10:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>学生管理系统</title>

<!-- Bootstrap -->
<link href="./boot/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="./css/reset.css">
<link rel="stylesheet" href="./css/index.css">
<style>
  .contain{
    width:100%;
    background:#dddddd;
    height:800px;

  }
  .clearfix ::after{
    content:"";
    display: block;
    clear:both;
  }
  .item{
    float:left;
    width:300px;
    height:300px;
    font-size:25px;

  }

  .item div{
    background-color: #709fb0;
    width:200px;
    height:200px;
    border:1px solid #ccc;
    margin-top:100px;
    margin-left:200px;
    text-align: center;
    /* line-height: 200px; */
  }
  span{
    color:#ccc;
    font-weight:400;
    line-height: 200px;
  }

</style>
</head>
<body>


<div class="container">
  <ul id="mytab" class="nav nav-tabs">
    <li ><a href="">Apple商城</a></li>
    <li class="right"><a  href="http://127.0.0.1:5500/%E4%BB%BFApple%E5%95%86%E5%9F%8E%E9%A1%B9%E7%9B%AE%E5%AE%9E%E9%AA%8C%E4%B8%80/login.html">登录</a></li>
    <li><a href="">注册</a></li>
    <li><a href="">消息通知</a></li>
    <li class="left"><a  href="#">购物车</a></li>
  </ul>
</div>

<div class="contain">
  <ul id="nav" class="clearfix">
    <li class="item"><a href="http://localhost:8080/Query_war_exploded/listServlet">
      <div>
        <span>jstl展示</span>
      </div>
    </a></li>
    <li class="item"><a href="http://127.0.0.1:5500/%E5%AD%A6%E7%94%9F%E7%AE%A1%E7%90%86%E7%B3%BB%E7%BB%9F/AJAX.html">
      <div>
        <span>AJAX请求展示</span>
        <a href="index.jsp">登录</a>
      </div>
    </a></li>
  </ul>

</div>

<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>

</body>
</html>
