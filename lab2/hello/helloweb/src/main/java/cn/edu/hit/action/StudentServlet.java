package cn.edu.hit.action;

import cn.edu.hit.dao.StudentDao;
import cn.edu.hit.dao.impl.StudentDaoImpl;
import cn.edu.hit.entity.Student;
import com.alibaba.fastjson.JSON;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "studentServlet", value = "/student-servlet")
public class StudentServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String action = request.getParameter("action");
        if(action.equals("add")) {
            String sid = request.getParameter("sid");
            String sname = request.getParameter("sname");
            char gender = request.getParameter("gender").charAt(0);
            int age = Integer.parseInt(request.getParameter("age"));
            Date birthday = Date.valueOf(request.getParameter("birthday"));
            String mid = request.getParameter("mid");
            StudentDao studentDao = new StudentDaoImpl();
            studentDao.add(new Student(sid,sname,gender,age,birthday,mid));

            out.println(JSON.toJSONString(new Student(sid,sname,gender,age,birthday,mid)));

        }
        else if(action.equals("getAll")) {
            StudentDao studentDao = new StudentDaoImpl();
            List<Student> studentList = studentDao.getAll("select * from student");
            out.println(JSON.toJSONString(studentList));
        }
        else if(action.equals("valid")) {
            StudentDao studentDao = new StudentDaoImpl();
            String sid = request.getParameter("sid");
            String toSid = studentDao.getBySid(sid);
            if(toSid == null) {
                out.println("true");
            }
            else if(toSid.equals(sid)){
                out.println("false");
            }
        }
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request, response);
    }
}