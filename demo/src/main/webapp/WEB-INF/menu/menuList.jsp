<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>MenuList-jsp</title>
</head>
<body>
<h2>${memberDTO.mname}님 환영합니다!</h2>

<div>
    <form method="post" action="/logoutmenu">
        <button type="submit">로그아웃</button>
        <%--        <input type="button" id="logout" value="로그아웃">--%>
    </form>
</div>
<div>
    <form method="post" action="/noautomenu">
        <button type="submit">자동 로그인 해제</button>
    </form>
</div>
<button><a href="/menu/input">메뉴작성</a></button>
<ul>
    <c:forEach var="dto" items="${menulist}">
        <li>
            <span>
                <a href="/menu/Read?no=${dto.no}">${dto.no}</a>
            </span>
            <span>
                    ${dto.name}
            </span>
            <span>
                    ${dto.dueDate}
            </span>

        </li>
    </c:forEach>
</ul>
</body>
</html>
