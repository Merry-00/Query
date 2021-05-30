package com.gcl.query.test;
import com.gcl.query.dao.StudentDaoIpm;
import com.gcl.query.model.Student;
import com.gcl.query.utils.DBUtil;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
public class StudentDaoIpmdemo {
    public static void main(String[] args) throws SQLException {
        StudentDaoIpm studentDaoIpm=new StudentDaoIpm();
        ArrayList<Student> list = new ArrayList<Student>();
        ResultSet resultSet=null;
        resultSet=studentDaoIpm.select();
        while(resultSet.next()){
            String id=resultSet.getString(1);
            String name=resultSet.getString(2);
            int age=resultSet.getInt(3);
            String student_class=resultSet.getString(4);
            String grade=resultSet.getString(5);
            String sex=resultSet.getString(6);
            Student student=new Student(id,name,age,student_class,grade,sex);
            list.add(student);
        }
        if(!resultSet.next()){
            resultSet.close();
        }
        for(Student student:list){
            System.out.println(student);
        }
    }
    }

