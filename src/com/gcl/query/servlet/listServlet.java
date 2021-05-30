package com.gcl.query.servlet;

import com.gcl.query.model.Student;
import com.gcl.query.service.UserServiceIpm;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
@WebServlet("/listServlet")
public class listServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserServiceIpm userServiceIpm=new UserServiceIpm();
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");
        List<Student> list= null;
        try {
            list = userServiceIpm.selectAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("Students",list);
        req.getRequestDispatcher("/query.jsp").forward(req,resp);
        //pageContext.setAttribute("Students",list);
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
