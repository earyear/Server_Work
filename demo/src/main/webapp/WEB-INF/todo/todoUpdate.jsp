<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP-update</title>
</head>
<body>
<h1>임시 todoUpdate화면</h1>

<%--수정--%>
<form method="post" action="/todo/update">
    <div>
        <input type="text" name="title" placeholder="제목을 입력해주세요." value="${sample.title}" >
    </div>
    <div>
        <input type="date" name="dueDate" value="${sample.dueDate}" >
    </div>
    <div>
        <input type="checkbox" name="finished" ${sample.finished ? "checked":""} >
    </div>
    <div>
        <input type="hidden" name="tno" value="${sample.tno}">
        <button type="submit">수정하기</button>
    </div>
</form>

<%--삭제--%>
<form method="post" action="/todo/delete">
    <%--  화면에는 안보임. --%>
    <input type="hidden" name="tno" value="${sample.tno}">
    <button type="submit">삭제하기</button>
</form>

<%--전체 리스트보기--%>
<form method="get" action="/todo/list">
    <button type="submit">전체메뉴</button>
</form>

<%--혼자 뻘짓--%>
<%--<form method="post" action="/todo/update">--%>
<%--    <div>--%>
<%--        ${todoDTO.title}--%>
<%--        <input type=text name="title" placeholder="${todoDTO.title}" value="${todoDTO.title}">--%>
<%--    </div>--%>
<%--    <div>--%>
<%--        <input type=date name="dueDate">--%>
<%--    </div>--%>
<%--    <button type="submit">수정적용확인</button>--%>
<%--</form>--%>
<%--<form method="post" action="/todo/delete">--%>
<%--    <input type="hidden" name="tno" value="${todoDTO.tno}">--%>
<%--    <button type="submit">삭제</button>--%>
<%--</form>--%>
</body>
</html>
