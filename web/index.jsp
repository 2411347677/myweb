<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2020/3/10
  Time: 21:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>首页</title>
  </head>
  <body>
  <script type='text/javascript' src='https://www.wjx.cn/handler/jqemed.ashx?activity=64689575&width=760&source=iframe'>

  </script>
    <a href="/student?method=queryAll">查询所有</a>
    <form action="/student" method="post">
      根据id查询：<input type="text" name="id"/>
      <input type="hidden" name="method" value="queryById"/>
      <input type="hidden" name="update" value="false"/>
      <input type="submit" value="查询"/>
    </form>
    <form action="/student" method="post">
      根据姓名查询：<input type="text" name="name"/>
      <input type="hidden" name="method" value="queryByName"/>
      <input type="submit" value="查询"/>
    </form>
  </body>
</html>
