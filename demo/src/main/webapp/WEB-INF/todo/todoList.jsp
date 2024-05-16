<%--
  Created by IntelliJ IDEA.
  User: it
  Date: 2024-05-14
  Time: 오후 4:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>JSP-list</title>
</head>
<body>
<h1>todolist</h1>
서버에서 넘겨 받은 임시 더미 리스트 사용해보기.
EL 표기법으로 \${사용할 변수의 키}, ex(key 이름 : list)
${list}
<br>
<h2>
    ${list[0].tno}
    ${list[0].title}
    ${list[0].dueDate}
</h2>

<ul>
    <c:forEach var="dto" items="${list}">
        <li>
                ${dto}
        </li>
    </c:forEach>
</ul>


</body>
</html>
