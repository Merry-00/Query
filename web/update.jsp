<%--
  Created by IntelliJ IDEA.
  User: 86166
  Date: 2021/5/11
  Time: 11:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改学生信息</title>
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
        }
    </style>
</head>
<body>
    <h1>修改学生</h1>
    <hr>
    <br>

    <form action="http://localhost:8080/Query_war_exploded/updateServlet" method="post" enctype="multipart/form-data" id="form" class="myform form-inline"  >
        <div class="form-group">
            <label >学号</label>
            <input name="id" type="text" class="form-control" id="id" value="${s.id}">
        </div>
        <div class="form-group">
            <label >姓名</label>
            <input name="name" type="text" class="form-control" id="name" value="${s.name}" >
        </div>
        <div class="form-group">
            <label >年龄</label>
            <input name="age" type="text" class="form-control" id="age" value="${s.age}">
        </div>
        <div class="form-group">
            <label >班级</label>
            <input name="student_class" type="text" class="form-control" id="student_class" value="${s.student_class}" >
        </div>
        <div class="form-group">
            <label >年级</label>
            <input name="grade" type="text" class="form-control" id="grade" value="${s.grade}">
        </div>
        <div class="form-group">
            <label >性别</label>
            <input name="sex" type="text" class="form-control" id="sex" value="${s.sex}">
        </div>
        <div class="form-group">
            <label >头像</label>
            <input name="img" type="file" class="form-control" id="img">
        </div>
        <div class="form-group">
            <input class="btn btn-primary" type="submit" name="修改" >
        </div>
        <div class="form-group">
            <input class="btn btn-default" type="reset" name="重置" >
        </div>
    </form>


    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>

<script>
</script>
</body>
</html>
