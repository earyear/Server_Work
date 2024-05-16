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
    <title>MemberList-jsp</title>
</head>
<body>
<ul>
    <c:forEach var="dto" items="${mlist}">
        <li>
                ${dto}
        </li>
    </c:forEach>-
</ul>
</body>
</html>
