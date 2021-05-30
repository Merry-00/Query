package com.gcl.query.dao;

import com.gcl.query.model.Student;

import java.util.List;

public interface StudentDao {
    //查询总记录条数
    int getTotalRecords();
    //分页查询学生信息 参数为当前页和页面大小
    List<Student> queryStudentsByPage(int currentPage,int pageSize);

}
