package com.gcl.query.servlet;

import com.gcl.query.model.Student;
import com.gcl.query.service.UserServiceIpm;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "select",urlPatterns = "/select")
public class select extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("成功");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");
        UserServiceIpm userServiceIpm=new UserServiceIpm();
        try {
            List<Student> students=userServiceIpm.selectAll();
            JSONArray jsonlist=JSONArray.fromObject(students);
            //接下来发送数据给前端
//            resp.setCharacterEncoding("utf-8");
//            resp.setContentType("text/html;charset=UTF-8");
//            得到输出流
            PrintWriter respWritter=resp.getWriter();
//            将JSON个数的对象toString()后发送
            respWritter.append(jsonlist.toString());

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
