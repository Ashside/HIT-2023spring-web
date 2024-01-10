package cn.edu.hit.dao.impl;

import cn.edu.hit.dao.StudentDao;
import cn.edu.hit.db.DBUtil;
import cn.edu.hit.entity.Student;

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
        String sql = "insert into student (sid, sname, gender, age, birthday, mid)\n" +
                "values ('" + sid + "','" + sname + "','" + gender + "','" + age + "','" + birthday + "','" + mid + "')";
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
        dbUtil.executeUpdate("update student set sname = '" + sname + "' where sid = '" + sid + "'");
        dbUtil.executeUpdate("update student set gender = '"+ gender +"' where sid = '" + sid + "'");
        dbUtil.executeUpdate("update student set age = '"+ age +"' where sid = '" + sid + "'");
        dbUtil.executeUpdate("update student set birthday = '"+ birthday +"' where sid = '" + sid + "'");
        dbUtil.executeUpdate("update student set mid = '"+ mid +"' where sid = '" + sid + "'");
        dbUtil.close();
    }

    @Override
    public void remove(String sid) {
        DBUtil dbUtil = new DBUtil();
        dbUtil.executeUpdate("delete from student where sid = '" + sid + "'");
        dbUtil.close();
    }

    @Override
    public String getBySid(String sid) {
        DBUtil dbUtil = new DBUtil();
        ResultSet rs = dbUtil.executeQuery("select * from student where sid = '" + sid + "'");
        String toSid = null;
        /*
        String sname;
        char gender;
        int age;
        Date birthday;
        String mid;*/
        try {
            if (rs.next()) {
                /*
                sname = rs.getString("sname");
                gender = rs.getString("gender").charAt(0);
                age = rs.getInt("age");
                birthday = rs.getDate("birthday");
                mid = rs.getString("mid");*/
                return sid;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return toSid;
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

        try {
            while (rs.next()) {
                sid = rs.getString("sid");
                sname = rs.getString("sname");
                gender = rs.getString("gender").charAt(0);
                age = rs.getInt("age");
                birthday = rs.getDate("birthday");
                mid = rs.getString("mid");
                studentList.add(new Student(sid,sname,gender,age,birthday,mid));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            dbUtil.close();
            return studentList;
        }


    }
}
