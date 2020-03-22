<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2020/3/11
  Time: 13:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查询结果</title>
</head>
<body>
    ${result}
    <table border="1">
        <tr>
            <th>编号</th>
            <th>姓名</th>
            <th>分数</th>
            <th>日期</th>
        </tr>
        <tr>
            <th>${student.id}</th>
            <th>${student.name}</th>
            <th>${student.score}</th>
            <th>${student.date}</th>
        </tr>
    </table>
</body>
</html>
