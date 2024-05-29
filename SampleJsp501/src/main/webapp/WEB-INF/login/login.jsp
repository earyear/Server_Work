<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP2 - login.jsp</title>
</head>
<body>
<c:if test="${param.result == 'error'}">
  <h1>로그인 에러</h1>
</c:if>
<form action="/login" method="post">
  <input type="text" name="mid" placeholder="아이디를 입력해주세요.">
  <input type="number" name="mpw" placeholder="패스워드를 입력해주세요.">

  <input type="checkbox" name="auto" id="auto">
  <label for="auto">자동로그인</label>

  <button type="submit">로그인</button>
</form>

<form action="/signup" method="get">
  <button type="submit">회원가입</button>
</form>

</body>
</html>
