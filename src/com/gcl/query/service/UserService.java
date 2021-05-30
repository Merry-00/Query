package com.gcl.query.service;

import com.gcl.query.model.Register;
import com.gcl.query.model.Student;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface UserService {
    void register(Register register);
    boolean loginUser(String id,String psd);
    List<Student> selectAll() throws SQLException;
    int addStudent(Student student);
    Student select(String id);
    int deleteStudent(String id);
    boolean updateStudent(Student student);

}
