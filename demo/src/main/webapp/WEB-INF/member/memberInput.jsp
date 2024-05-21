<%--
  Created by IntelliJ IDEA.
  User: it
  Date: 24. 5. 16.
  Time: 오후 12:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>memberInput-jsp</title>
</head>
<body>
<form action="/memberinput" method="post">
    <input type="text" name="menu" value="먹고싶은 메뉴입력">
    <%--    <input type="number" name="num2">--%>
    <button type="submit">전송</button>
</form>
</body>
</html>
