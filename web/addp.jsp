<%--
  Created by IntelliJ IDEA.
  User: 86166
  Date: 2021/5/11
  Time: 10:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加学生</title>
    <!-- Bootstrap -->
    <link href="./boot/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="./css/reset.css">
    <link rel="stylesheet" href="./css/index.css">
    <style>
        h1{
            margin-top:20px;
            font-size:26px;
            font-width: 400;
            color:#5e5e5e;
            margin-bottom: 30px;
        }
    </style>
</head>
<body>
<div>
    <h1>添加学生</h1>
</div>
<form id="form"  action="http://localhost:8080/Query_war_exploded/add" method="post" enctype="multipart/form-data" class="myform form-inline">
    <div class="form-group">
        <label >学号</label>
        <input name="id" type="text" class="form-control" id="id" >
    </div>
    <div class="form-group">
        <label >姓名</label>
        <input name="name" type="text" class="form-control" id="name" >
    </div>
    <div class="form-group">
        <label >年龄</label>
        <input name="age" type="text" class="form-control" id="age" >
    </div>
    <div class="form-group">
        <label >班级</label>
        <input name="student_class" type="text" class="form-control" id="student_class" >
    </div>
    <div class="form-group">
        <label >年级</label>
        <input name="grade" type="text" class="form-control" id="grade" >
    </div>
    <div class="form-group">
        <label >性别</label>
        <input name="sex" type="text" class="form-control" id="sex" >
    </div>
    <div class="form-group">
        <label >头像</label>
        <input name="photo" type="file" class="form-control" id="photo" >
    </div>
    <div class="form-group">
        <input  type="submit" class="bt btn-primary" >
    </div>
    <div class="form-group">
        <input class="btn btn-default" type="reset" name="重置">
    </div>
</form>



<!-- 学生信息添加功能 -->

<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
<script>


</script>
</body>
</html>
