<%--
  Created by IntelliJ IDEA.
  User: it
  Date: 2024-05-14
  Time: 오후 4:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP-read</title>
</head>
<body>
<h1>임시 todoRead화면</h1>

<div>
    <input type="text" name="title" placeholder="제목을 입력해주세요." value="${sample.title}" readonly>
</div>
<div>
    <input type="date" name="dueDate" value="${sample.dueDate}" readonly>
</div>
<div>
    <input type="checkbox" name="finished" ${sample.finished ? "checked":""} onClick="return false" >
</div>

<%--방법1--%>
<form method="get" action="/todo/update">
    <input type="hidden" name="tno" value="${sample.tno}">
    <div>
        <h3>방법1, 수정폼 이동</h3>
        <button type="submit">수정하기</button>
    </div>
</form>


<%--방법2 링크로 해당 수정폼 이동하기.--%>
<div>
    <h3>방법2, 수정폼 이동</h3>
    <a href="/todo/update?tno=${sample.tno}">수정폼이동</a>
</div>


<%--방법3--%>
<%--자바스크립트의 코드 이용해서. 처리하기. --%>
<div>
    <h3>방법3, 수정폼 이동</h3>
    <input type="button" value="수정폼이동" id="updateBtn">
</div>
<script>
    document.querySelector("#updateBtn").addEventListener("click",function(e){
        self.location = "/todo/update?tno=${sample.tno}"
    },false);
</script>

<p>
<form method="get" action="/todo/list">
    <button type="submit">전체메뉴</button>
</form>



<%--<form method="post" action="/todo/read">--%>
<%--    <input type=text name="title" placeholder="찾을 숫자를 입력해주세요.">--%>
<%--    <button type="submit">조회</button>--%>
<%--    <p>--%>
<%--    <div>--%>
<%--        ${DTO}--%>
<%--    </div>--%>
<%--</form>--%>

<%--<form method="get" action="/todo/update?tno=${DTO.tno}">--%>
<%--    <button type="submit">수정</button>--%>
<%--</form>--%>
<%--<form method="get" action="/todo/list">--%>
<%--    <button type="submit">전체보기</button>--%>
<%--</form>--%>

</body>
</html>
