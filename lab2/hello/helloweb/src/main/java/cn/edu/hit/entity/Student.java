package cn.edu.hit.entity;

import java.sql.Date;

public class Student {
    private String sid;
    private String sname;
    private char gender;
    private int age;
    private java.sql.Date birthday;
    private String mid;

    public Student() {
    }

    public Student(String sid, String sname, char gender, int age, java.sql.Date birthday, String mid) {
        this.sid = sid;
        this.sname = sname;
        this.gender = gender;
        this.age = age;
        this.birthday = birthday;
        this.mid = mid;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }
}
