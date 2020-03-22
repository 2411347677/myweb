<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2020/3/11
  Time: 13:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>查询结果</title>
</head>
<body>
    <table border="1">
        <tr>
            <th>编号</th>
            <th>姓名</th>
            <th>成绩</th>
            <th>日期</th>
        </tr>
        <c:forEach items="${studentList}" var="student">
        <tr>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.score}</td>
            <td>${student.date}</td>
            <td>
                <a href="/student?method=deleteStudent&id=${student.id}">删除</a>
                <a href="/student?method=queryById&id=${student.id}&update=true">修改</a>
            </td>
        </tr>
        </c:forEach>
    </table>
    <a href="add.jsp">添加</a>
</body>
</html>
