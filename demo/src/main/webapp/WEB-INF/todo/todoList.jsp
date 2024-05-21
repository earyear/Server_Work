<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>JSP-list</title>
</head>
<body>
<h1>todolist</h1>
<%--서버에서 넘겨 받은 임시 더미 리스트 사용해보기.--%>
<%--EL 표기법으로 \${사용할 변수의 키}, ex(key 이름 : list)--%>
<%--${list}--%>
<br>

<ul>
    <c:forEach var="dto" items="${list}">
        <li>
                <span>
                    <a href="/todo/read?tno=${dto.tno}">${dto.tno}</a>
                </span>
                ${dto}
        </li>
    </c:forEach>
</ul>


</body>
</html>
