<%@ page import="com.gcl.query.service.UserServiceIpm" %>
<%@ page import="com.gcl.query.model.Student" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 86166
  Date: 2021/4/29
  Time: 21:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>展示表格数据</title>
    <!-- Bootstrap -->
    <link href="./boot/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="./css/reset.css">
    <link rel="stylesheet" href="./css/index.css">


</head>
<%--    <%--%>
<%--    Student student=new Student();--%>
<%--    UserServiceIpm userServiceIpm=new UserServiceIpm();--%>
<%--    List<Student> list=userServiceIpm.selectAll();--%>
<%--    pageContext.setAttribute("Students",list);--%>
<%--    %>--%>
<body>
<%--forech展示--%>
<table id="std_table" class="table table-striped">
    <tbody id="tbody">
    <tr>
        <td>学号</td>
        <td>姓名</td>
        <td>年龄</td>
        <td>班级</td>
        <td>年级</td>
        <td>性别</td>
        <td>操作</td>

    </tr>
    <c:forEach items="${Students}" var="student" >
        <tr>
            <td >${student.id}</td>
            <td >${student.name}</td>
            <td >${student.age}</td>
            <td >${student.student_class}</td>
            <td >${student.grade}</td>
            <td >${student.sex}</td>
            <td><a href="http://localhost:8080/Query_war_exploded/deleteServlet?id=${student.id}">删除</a> <a href="http://localhost:8080/Query_war_exploded/loadServlet?id=${student.id}">修改</a> </td>
        </tr>
    </c:forEach>

    </tbody>
</table>
</body>
</html>
