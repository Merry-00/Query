package com.gcl.query.dao;

import com.gcl.query.model.Register;
import com.gcl.query.utils.DBUtil;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
@MultipartConfig  //使用MultipartConfig注解标注改servlet能够接受文件上传的请求
public class RegisterDaoIpm implements RegisterDao {
    /**
     * 查询注册表是否存在该账号
     * @param id
     * @return
     */
    @Override
    public ResultSet selectById(String id) {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        String sql="select * from rgstudent where student_id=?";
        try {
            connection= DBUtil.getConnection();
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,id);
            resultSet=preparedStatement.executeQuery();
            return resultSet;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try{
                connection.close();
                preparedStatement.close();
            }catch (SQLException e){
                e.printStackTrace();
            }

        }
        return null;
    }

    /***
     * 将注册的账号，密码写入注册表中
     * @param register
     * @return
     */
    @Override
    public int addUser(Register register) {
       Connection connection=null;
       PreparedStatement preparedStatement=null;
       String sql="insert into rgstudent(email,id,password) values(?,?,?)";
       try{
           connection=DBUtil.getConnection();
           preparedStatement=connection.prepareStatement(sql);
           preparedStatement.setString(1,register.getEmail());
           preparedStatement.setString(2,register.getId());
           preparedStatement.setString(3,register.getPassword());
           int x=preparedStatement.executeUpdate();
           return x;
       } catch (SQLException e) {
           e.printStackTrace();
       }finally {
           DBUtil.closeAll(connection,preparedStatement,null);
       }
       return 0;
    }

    /**
     * 实现上传头像功能：
     * @param part
     * @return
     */

    @Override
    public int addPicture(Part part) {
        //1. 上传逻辑
        //获取文件名
        String filename=part.getSubmittedFileName();
        String serverpath="D:\\java code\\IdeaProjects\\Query\\web\\img\\";
        //获取上传文件的文件名
        InputStream in = null;
        try {
            in = part.getInputStream();
            FileOutputStream fos = new FileOutputStream(serverpath + filename);
            byte[] bytes=new byte[1024];
            int length=0;
            while((length=in.read(bytes))!=-1){
                fos.write(bytes,0,length);
            }
            fos.close();
            in.close();
            return 1;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
