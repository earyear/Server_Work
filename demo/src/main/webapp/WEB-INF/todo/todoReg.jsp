<%--
  Created by IntelliJ IDEA.
  User: it
  Date: 2024-05-14
  Time: 오후 4:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP-reg</title>
</head>
<body>
<h1>임시 todoReg화면</h1>
<form method="post" action="/todo/register">
    <div>
        <input type=text name="title" placeholder="제목을 입력해주세요.">
    </div>

    <div>
        <input type=date name="dueDate">
    </div>
    <button type="submit">작성</button>
    <button type="reset">초기화</button>
</form>
</body>
</html>
