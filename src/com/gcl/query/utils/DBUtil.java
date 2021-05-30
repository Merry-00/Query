package com.gcl.query.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DBUtil {
    //存储配置文件的map
    private static final Properties PROPERTIES=new Properties();
    static{
        InputStream is= DBUtil.class.getResourceAsStream("/com/gcl/query/utils/bd.properties");
        //存储配置文件内容加载到properties集合


        try {
            //00.out.println("why");
            PROPERTIES.load(is);//通过流，将配置文件内容加载到properties集合中
            Class.forName(PROPERTIES.getProperty("driver"));//通过找配置文件中的变量名来得到值
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //获取数据库的连接
    public static Connection getConnection(){
        Connection connection=null;
        try {
            connection = DriverManager.getConnection(PROPERTIES.getProperty("url"),PROPERTIES.getProperty("username"), PROPERTIES.getProperty("password"));
            //System.out.println("连接数据库成功！");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;

    }
    //释放资源方法
    public static void closeAll(Connection connection, Statement statement, ResultSet resultSet){
        if(resultSet!=null){
            try {
                resultSet.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(statement!=null){
            try {
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(connection!=null){
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }






}
