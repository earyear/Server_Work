<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>ex5화면</title>
</head>
<body>
    <h1>ex5, 서버에서 넘어온 데이터를 EL표기법으로 표시</h1>
    <h1>오늘 먹은 점심 : ${menu}</h1>
    <h2>오늘 먹은 점심 : <c:out value="${menu}"></c:out></h2>
    <h1> 넘어온 todoDTO : ${todoDTO}</h1>
    <h1> 넘어온 todoDTO의 title 의 효과는 getTitle() 같은 효과 : ${todoDTO.title}</h1>
</body>
</html>
