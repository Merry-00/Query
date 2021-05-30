package com.gcl.query.servlet;

import com.gcl.query.model.Student;
import com.gcl.query.service.UserServiceIpm;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/loadServlet")
public class LoadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String id=request.getParameter("id");
        UserServiceIpm userServiceIpm=new UserServiceIpm();
        Student student= userServiceIpm.select(id);
            if(student!=null){
            request.setAttribute("s",student);
            request.getRequestDispatcher("/update.jsp").forward(request,response);
        }

    }
}
