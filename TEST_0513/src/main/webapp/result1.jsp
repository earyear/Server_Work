<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - input.jsp</title>
</head>
<body>
<form action="input.jsp" method="post">
    <h1>input.js에서 보낸 파라미터 정보를 받아서 출력하는 결과 파일</h1>
    <h1>넘어온 데이터 num1 : ${param.num1}</h1>
    <h1>넘어온 데이터 num2 : ${param.num2}</h1>
</form>
</body>
</html>