package com.gcl.query.servlet;

import com.gcl.query.service.UserServiceIpm;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteServlet")
public class deleteServlet extends HttpServlet {
    UserServiceIpm userServiceIpm=new UserServiceIpm();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id=request.getParameter("id");
        int x=userServiceIpm.deleteStudent(id);
        if(x>0){
            System.out.println("删除成功");
            response.sendRedirect("http://localhost:8080/Query_war_exploded/listServlet");
        }
        else{
            response.sendRedirect("http://localhost:8080/Query_war_exploded/query.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
