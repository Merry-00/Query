package com.gcl.query.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.gcl.query.model.Student;
import com.gcl.query.utils.DBUtil;
public class StudentDaoIpm implements StudentDao{
    public ResultSet select(){
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        String sql="select * from student ";
        try{
            connection= DBUtil.getConnection();
            preparedStatement=connection.prepareStatement(sql);
            resultSet=preparedStatement.executeQuery();
            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
//            DBUtil.closeAll(connection,preparedStatement,null);
        }
        return null;
    }
    public int add(Student student){
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        String sql="insert into student(student_id,name,age,student_class,grade,sex,img) values(?,?,?,?,?,?,?);";

        try {
            connection=DBUtil.getConnection();
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,student.getId());
            preparedStatement.setString(2,student.getName());
            preparedStatement.setInt(3,student.getAge());
            preparedStatement.setString(4,student.getStudent_class());
            preparedStatement.setString(5,student.getGrade());
            preparedStatement.setString(6,student.getSex());
            preparedStatement.setString(7,student.getImg());
            return preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DBUtil.closeAll(connection,preparedStatement,null);
        }
        return 0;
    }
    public ResultSet selectById(String id){
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        String sql="select * from student where student_id=? ";
        try{
            connection= DBUtil.getConnection();
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,id);
            resultSet=preparedStatement.executeQuery();
            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
//            DBUtil.closeAll(connection,preparedStatement,null);
        }
        return null;
    }
    public int update(Student student){
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        String sql="update student set name=?,age=?,student_class=?,grade=?,sex=?,img=? where student_id=?";
        int x=0;
        try{
            connection=DBUtil.getConnection();
            preparedStatement=connection.prepareStatement(sql);

            preparedStatement.setString(1,student.getName());
            preparedStatement.setInt(2,student.getAge());
            preparedStatement.setString(3,student.getStudent_class());
            preparedStatement.setString(4,student.getGrade());
            preparedStatement.setString(5,student.getSex());
            preparedStatement.setString(6,student.getImg());
            preparedStatement.setString(7,student.getId());
            x=preparedStatement.executeUpdate();
            return x;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeAll(connection,preparedStatement,null);
        }
        return x;
    }
    public int deleteByid(String id){
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        String sql="delete from student where student_id=?";
        int x=0;
        try{
            connection=DBUtil.getConnection();
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,id);
            x=preparedStatement.executeUpdate();
            return x;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return x;
    }

    @Override
    public int getTotalRecords() {

        return 0;
    }

    @Override
    public List<Student> queryStudentsByPage(int currentPage, int pageSize) {
        return null;
    }
}
