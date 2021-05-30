package com.gcl.query.servlet;

import com.gcl.query.dao.RegisterDaoIpm;
import com.gcl.query.model.Student;
import com.gcl.query.service.UserServiceIpm;
import com.mysql.cj.xdevapi.JsonArray;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@MultipartConfig  //使用MultipartConfig注解标注改servlet能够接受文件上传的请求
@WebServlet(name = "add",urlPatterns = "/add")
public class add extends HttpServlet {
    UserServiceIpm userServiceIpm=new UserServiceIpm();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");
        //1. 上传逻辑
        Part part = req.getPart("photo");
        //获取文件名
        RegisterDaoIpm registerDaoIpm=new RegisterDaoIpm();
        registerDaoIpm.addPicture(part);
        String id=req.getParameter("id");
        String name=req.getParameter("name");
        String age=req.getParameter("age");
        int age1=Integer.valueOf(age);
        String student_class=req.getParameter("student_class");
        String grade=req.getParameter("grade");
        String sex=req.getParameter("sex");
        String img="img/"+part.getSubmittedFileName();
        Student student=new Student(id,name,age1,student_class,grade,sex,img);
        System.out.println(student.toString());
        int x=userServiceIpm.addStudent(student);
        if(x>0){
            System.out.println("添加成功");
            resp.sendRedirect("http://localhost:8080/Query_war_exploded/listServlet");
//            String msg = "添加成功,listServlet";
//            PrintWriter respWritter=resp.getWriter();
////            将JSON个数的对象toString()后发送
//            respWritter.append(msg);
        }
        else{
//            String msg = "添加失败,add.jsp";
//            System.out.println("添加失败");
                resp.sendRedirect("http://localhost:8080/Query_war_exploded/addp.jsp");
//            resp.getWriter().append(msg);
        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }

}
