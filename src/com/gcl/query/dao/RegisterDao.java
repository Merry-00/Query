package com.gcl.query.dao;

import com.gcl.query.model.Register;
import javax.servlet.http.Part;
import java.sql.ResultSet;


public interface RegisterDao {
    ResultSet selectById(String id);
    int addUser(Register register);
    int addPicture(Part part);
}
