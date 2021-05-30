package com.gcl.query.servlet;

import com.gcl.query.model.Student;
import com.gcl.query.service.UserServiceIpm;

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

@WebServlet("/updateServlet")
@MultipartConfig
public class updateServlet extends HttpServlet {
    UserServiceIpm userServiceIpm=new UserServiceIpm();
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");
        String id=req.getParameter("id");
        String name=req.getParameter("name");
        String age=req.getParameter("age");
        int age1=Integer.valueOf(age);
        String student_class=req.getParameter("student_class");
        String grade=req.getParameter("grade");
        String sex=req.getParameter("sex");
        //1. 上传逻辑
        Part part = req.getPart("img");
        //获取文件名
        String filename=part.getSubmittedFileName();
        String serverpath="D:\\java code\\IdeaProjects\\Query\\web\\img\\";
        //获取上传文件的文件名
        InputStream in = part.getInputStream();
        FileOutputStream fos = new FileOutputStream(serverpath + filename);
        byte[] bytes=new byte[1024];
        int length=0;
        while((length=in.read(bytes))!=-1){
            fos.write(bytes,0,length);
        }
        fos.close();
        in.close();
        String img="img/"+filename;
        Student student=new Student(id,name,age1,student_class,grade,sex,img);
        boolean flag=userServiceIpm.updateStudent(student);
        if(flag){
            //修改成功
            System.out.println("修改成功");
            resp.sendRedirect("http://localhost:8080/Query_war_exploded/listServlet");

        }
        else {
            System.out.println("修改失败");
            resp.sendRedirect("http://localhost:8080/Query_war_exploded/update.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)  {

    }
}
