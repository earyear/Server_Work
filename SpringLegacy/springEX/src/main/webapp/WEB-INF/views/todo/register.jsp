<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>register화면</title>
</head>
<body>
    <h1>todoregister화면     임시 reg.jsp임둥</h1>
<form method="post" action="/todo/ex6">
    <input type="hidden" name="tno" value="1">
    <div>
        <input type="text" name="title" placeholder="제목을 입력해주세요.">
    </div>
    <div>
        <input type="date" name="dueDate">
    </div>
    <div>
        <input type="text" name="writer" placeholder="작성자를 입력해주세요">
    </div>
    <div>
        Finished : <input type="checkbox" name="finished" >
    </div>
    <div>
        <button type="reset">초기화</button>
        <button type="submit">작성</button>
    </div>
</form>
</body>
</html>
