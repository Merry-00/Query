package com.gcl.query.service;

import com.gcl.query.dao.RegisterDaoIpm;
import com.gcl.query.dao.StudentDaoIpm;
import com.gcl.query.model.Register;
import com.gcl.query.model.Student;
import com.gcl.query.utils.DBUtil;

import javax.xml.transform.Result;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UserServiceIpm implements UserService {
    StudentDaoIpm studentDaoIpm=new StudentDaoIpm();

    /**
     *  登录功能实现逻辑
     *      1.用户输入学号，密码
     *      检查学号格式是否正确
     *      2.提交表单---要实现自动登录功能
     *      3.获取学号，密码
     *      在数据库中查询学号和密码是否匹配---在rgstudent表中查询
     *      若匹配成功---登录成功--跳转到主页面---index.jsp
     *      若匹配失败---提示登录失败---用户名或密码错误---跳转到登录界面---login.jsp
     *
     *
     *
     * @return
     */
    @Override
    public boolean loginUser(String id,String psd) {
        RegisterDaoIpm registerDaoIpm=new RegisterDaoIpm();
        ResultSet resultSet=null;
        resultSet=registerDaoIpm.selectById(id);
        try{
            while(resultSet.next()){
                String password=resultSet.getString(3);
               if(psd.equals(password)){
                   return true;
               }
               else{
                   return false;
               }
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     *  注册实现逻辑：
     *      1. 用户输入学号，密码，重复密码
     *      检查格式正确之后提交到registerServlet
     *      2.获取注册信息----先在数据库中的register表中查询是否注册过
     *      若注册过---则给出注册过的信息以及返回登录的按钮
     *      若没有注册过---则跳转到完善学生信息的页面
     *      3.输入基本信息和上传头像的功能
     *      跳转到addServlet实现添加到数据库中 的功能
     *      添加成功----提示注册成功----请登录
     *      添加失败----提示注册失败的信息
     *
     * @param register
     */
    @Override
    public void register(Register register) {

    }

    @Override
    public List<Student> selectAll() throws SQLException {
        ResultSet resultSet=null;
       List<Student> students=new ArrayList<Student>();
        resultSet=studentDaoIpm.select();
        while(resultSet.next()){
            String id=resultSet.getString(1);
            String name=resultSet.getString(2);
            int age=resultSet.getInt(3);
            String student_class=resultSet.getString(4);
            String grade=resultSet.getString(5);
            String sex=resultSet.getString(6);
            String img=resultSet.getString(7);
            Student student=new Student(id,name,age,student_class,grade,sex,img);
            students.add(student);
        }
        if(!resultSet.next()){
            resultSet.close();
        }
        return students;
    }

    @Override
    public int addStudent(Student student) {
        int x=0;
        x=studentDaoIpm.add(student);
        return x;
    }

    @Override
    public Student select(String id) {
        ResultSet resultSet=studentDaoIpm.selectById(id);

            try {
                while(resultSet.next()){
                    String sid=resultSet.getString(1);
                    String name=resultSet.getString(2);
                    int age=resultSet.getInt(3);
                    String student_class=resultSet.getString(4);
                    String grade=resultSet.getString(5);
                    String sex=resultSet.getString(6);
                    String img=resultSet.getString(7);
                    Student student=new Student(sid,name,age,student_class,grade,sex,img);
                    return student;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            finally {
                try {
                    if(resultSet!=null){
                        resultSet.close();
                    }

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        return null;
    }

    @Override
    public int deleteStudent(String id) {
        int x=0;
        x=studentDaoIpm.deleteByid(id);
        return x;
    }

    @Override
    public boolean updateStudent(Student student) {
        int x=studentDaoIpm.update(student);
        if(x>0){
            System.out.println("添加成功");
            return true;
        }
        return false;
    }
}
