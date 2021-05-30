package com.gcl.query.model;
public class Student {
    private String id;//学号
    private String name;//姓名
    private int age;//年龄
    private String student_class;//班级
    private String grade;//年级
    private String sex;//性别
    private String img;
    //空构造方法

    public Student() {
    }

    public Student(String id, String name, int age, String student_class, String grade, String sex) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.student_class = student_class;
        this.grade = grade;
        this.sex = sex;
    }

    public Student(String id, String name, int age, String student_class, String grade, String sex, String img) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.student_class = student_class;
        this.grade = grade;
        this.sex = sex;
        this.img = img;
    }
//setter和getter方法

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", student_class='" + student_class + '\'' +
                ", grade='" + grade + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getStudent_class() {
        return student_class;
    }

    public void setStudent_class(String student_class) {
        this.student_class = student_class;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}


