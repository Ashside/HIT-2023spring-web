<%--
  Created by IntelliJ IDEA.
  User: z
  Date: 2023-03-03
  Time: 19:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*,java.io.*" %>
<%@ page import="javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec" %>
<html>
<head>
    <title>注册成功-Success</title>
    <style>
        div{
            text-align: center;
        }
        list{
            display: inline-block;
        }
    </style>
</head>
<body>

<%
    String username = request.getParameter("username");

    String password = request.getParameter("password");

    String gender = request.getParameter("gender");

    String[] hobbies = request.getParameterValues("hobby");

    String textarea = request.getParameter("selfconduct");

    Map<String,String> map1 = new HashMap<String, String>();
    map1.put("male","男");
    map1.put("female","女");
    map1.put("helicopter","武装直升机");

    Map<String,String> map2 = new HashMap<String, String>();
    map2.put("basketball","篮球");
    map2.put("football","足球");
    map2.put("pingpong","乒乓");
    map2.put("swimming","游泳");
    map2.put("hiking","徒步");
%>


<h1 align="center">
    注册成功
</h1>

<div>



                <ul id="list">
                    <li>
                        <%
                            out.println("用户名：" + username);
                        %>
                    </li>
                    <li>
                        <%
                            out.println("密码：" + password);
                        %>
                    </li>
                    <li>
                        <%
                            out.println("性别：" + map1.get(gender));
                        %>
                    </li>
                    <li>
                        <%
                            out.println("爱好：");
                            for (String hobby : hobbies) {
                                out.println(map2.get(hobby));
                            }
                        %>
                    </li>
                    <li>
                        <%
                            out.println("个人简介：" + textarea);
                        %>
                    </li>
                </ul>

</div>

</body>
</html>
