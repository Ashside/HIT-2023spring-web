<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.demo3.entity.Student" %>
<%@ page import="java.sql.Date" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ include file="checkLogin.jsp"%>
<jsp:useBean id="StudentDao" class="com.example.demo3.dao.impl.StudentDaoImpl" scope="session"/>
<html>
<head>
    <title>学生管理</title>
    <style>
        table{
            border: 1px solid #000;
            border-collapse: collapse;
        }
        td{
            border: 1px solid #000;
            border-collapse: collapse;
        }

    </style>
</head>
<body>
<a href="addStudent.jsp">添加学生</a>
<table>
    <tr>
        <td>学号</td>
        <td>姓名</td>
        <td>性别</td>
        <td>年龄</td>
        <td>生日</td>
        <td>专业</td>
        <td>修改</td>
        <td>删除</td>
    </tr>
    <%
        List<Student> studentList = StudentDao.getAll("select sid,sname,gender,age,birthday,student.mid,major.mname from student , major where student.mid = major.mid");
        String sid,sname;
        char gender;
        int age;
        Date birthday;
        String mname;
        Map<Character,String> map = new HashMap<>();
        map.put('m',"男");
        map.put('f',"女");
        for (Student student : studentList) {
            sid= student.getSid();
            sname= student.getSname();
            gender= student.getGender();
            age= student.getAge();
            birthday= student.getBirthday();
            mname= student.getMname();
    %>
    <tr>
        <td><%=sid%></td>
        <td><%=sname%></td>
        <td><%=map.get(gender)%></td>
        <td><%=age%></td>
        <td><%=birthday%></td>
        <td><%=mname%></td>
        <td><a href="modifyStudent.jsp?sid=<%=sid%>">修改</a></td>
        <td><a href="StudentServlet?action=remove&sid=<%=sid%>" onclick="return confirm('确定要删除<%=sname%>同学吗？')">删除</a></td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
