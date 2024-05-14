<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP2 - result1.jsp</title>
</head>
<body>
<%--action 속성의 값으로 서버에서 처리할 서블릿 주소를 입력 하면 됨.--%>
<h1>input.jsp 에서 보낸 파라미터 정보를 받아서 출력하는 결과 파일. </h1>
<h1>넘어온 데이터 num1 : ${param.num1}</h1>
<h1>넘어온 데이터 num2 : ${param.num2}</h1>
</body>
</html>
