<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP-read</title>
</head>
<body>
<h1>menuRead화면</h1>

<div>
    <input type="text" name="name" placeholder="메뉴를 입력해주세요." value="${menu.name}" readonly>
</div>
<div>
    <input type="date" name="dueDate" value="${menu.dueDate}" readonly>
</div>
<%--<div>--%>
<%--    <input type="checkbox" name="finished" ${sample.finished ? "checked":""} onClick="return false" >--%>
<%--</div>--%>
<form method="get" action="/menuUpdate">
    <input type="hidden" name="no" value="${menu.no}">
    <div>
        <button type="submit">수정 하기</button>
    </div>
</form>

<p>
<form method="get" action="/menulist">
    <button type="submit">전체 메뉴</button>
</form>


</body>
</html>
