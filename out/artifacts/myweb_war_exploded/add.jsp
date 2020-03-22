<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2020/3/11
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加</title>
</head>
<body>
    <form action="/student" method="post">
        姓名：<input type="text" name="name"/><br/>
        分数：<input type="text" name="score"/><br/>
        <input type="hidden" name="method" value="insertStudent"/>
        <input type="submit" value="添加"/>
    </form>
</body>
</html>
