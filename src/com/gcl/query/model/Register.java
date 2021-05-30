package com.gcl.query.model;

public class Register {
    //成员变量

    private String id;
    private String email;
    private String password;
    //构造方法
    public Register(){}
    public Register(String id,String email,String password){
        this.id=id;
        this.email=email;
        this.password=password;
    }
    //setter和getter方法


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword(){
        return password;
    }
}
