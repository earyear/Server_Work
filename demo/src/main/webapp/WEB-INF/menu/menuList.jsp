<%--
  Created by IntelliJ IDEA.
  User: it
  Date: 24. 5. 16.
  Time: 오후 12:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>MenuList-jsp</title>
</head>
<body>
<button><a href="/menuinput">메뉴작성</a></button>
<ul>
    <c:forEach var="dto" items="${menulist}">
        <li>
            <span>
                    <a href="/menuRead?no=${dto.no}">${dto.no}</a>
                </span>
                ${dto}
        </li>
    </c:forEach>
</ul>
</body>
</html>
