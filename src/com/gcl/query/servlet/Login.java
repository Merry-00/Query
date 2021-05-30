package com.gcl.query.servlet;

import com.gcl.query.service.UserServiceIpm;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

@WebServlet("/login")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id=req.getParameter("username");
        String password=req.getParameter("password");
        UserServiceIpm userServiceIpm=new UserServiceIpm();
        boolean flag=userServiceIpm.loginUser(id,password);
        if(flag){
            //登录成功----跳转到主界面
            resp.sendRedirect("http://localhost:8080/Query_war_exploded/main.jsp");
        }
        else{
            //登录失败---提示重新登录
            String message="登录失败";
            resp.setContentType("text/html;charset=UTF-8");
            PrintWriter out=resp.getWriter();
            out.println("<h1>" + message + "</h1>"+"<a href='./index.jsp'>点击返回登录</a>");
        }
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        super.service(req, res);
    }
}
