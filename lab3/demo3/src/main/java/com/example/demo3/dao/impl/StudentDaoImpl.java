package com.example.demo3.dao.impl;

import com.example.demo3.dao.StudentDao;
import com.example.demo3.db.DBUtil;
import com.example.demo3.entity.Student;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    @Override
    public void add(Student student) {
        DBUtil dbUtil = new DBUtil();
        String sid = student.getSid();
        String sname = student.getSname();
        char gender = student.getGender();
        int age = student.getAge();
        Date birthday = student.getBirthday();
        String mid = student.getMid();
        String sql = "insert into student " + "values ('" + sid + "','" + sname + "','" + gender + "'," + age + ",'" + birthday + "','" + mid + "')";
        System.out.println(sql);
        dbUtil.executeUpdate(sql);
    }

    @Override
    public void modify(Student student) {
        DBUtil dbUtil = new DBUtil();
        String sid = student.getSid();
        String sname = student.getSname();
        char gender = student.getGender();
        int age = student.getAge();
        Date birthday = student.getBirthday();
        String mid = student.getMid();
        String sql = "update student set sname = '" + sname + "',gender='" + gender + "',age=" + age + ",birthday='" + birthday + "',mid='" + mid + "' where sid = '" + sid + "'";
        System.out.println(sql);
        dbUtil.executeUpdate(sql);
        dbUtil.close();
    }

    @Override
    public void remove(String sid) {
        DBUtil dbUtil = new DBUtil();
        String sql = "delete from student where sid = '" + sid + "'";
        System.out.println(sql);
        dbUtil.executeUpdate(sql);
        dbUtil.close();
    }

    @Override
    public Student getBySid(String sid) {
        DBUtil dbUtil = new DBUtil();
        List<Student> studentList = new ArrayList<>();
        String sql="select * from student where sid = '" + sid + "'";
        ResultSet rs = dbUtil.executeQuery(sql);
        String sname;
        char gender;
        int age;
        Date birthday;
        String mid,mname;
        Student student=null;
        try {
            if (rs.next()) {

                sname = rs.getString("sname");
                gender = rs.getString("gender").charAt(0);
                age = rs.getInt("age");
                birthday = rs.getDate("birthday");
                mid = rs.getString("mid");
                student = new Student(sid,sname,gender,age,birthday,mid);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return student;
    }

    @Override
    public List<Student> getAll(String sql) {
        DBUtil dbUtil = new DBUtil();
        ResultSet rs = dbUtil.executeQuery(sql);
        List<Student> studentList = new ArrayList<>();

        String sid;
        String sname;
        char gender;
        int age;
        Date birthday;
        String mid;
        String mname;
        try {
            while (rs.next()) {
                sid = rs.getString("sid");
                sname = rs.getString("sname");
                gender = rs.getString("gender").charAt(0);
                age = rs.getInt("age");
                birthday = rs.getDate("birthday");
                mid = rs.getString("mid");
                mname = rs.getString("mname");
                studentList.add(new Student(sid,sname,gender,age,birthday,mid,mname));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        finally {
            dbUtil.close();
            return studentList;
        }


    }
}
