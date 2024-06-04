<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>

<style>
    .paging-container {
        display: flex;
        justify-content: center; /* 가로 중앙정렬 */
        align-items: center; /* 세로 중앙정렬 */
        height: 10vh;
        /* 부모 요소의 높이를 100%로 설정 *
         },
         .paging-content {
           width: 10vw;
           height: 100px;
           background-color: lightblue;
           text-align: center; /* 텍스트 가로 중앙정렬 */
        /*line-height: 100px; !* 텍스트 세로 중앙정렬 *!*/
    }
</style>


<div class="container-fluid">
    <div class="row">
        <!--    NavBar 가져와서 적용해보기-->
        <div class="col">
            <nav class="navbar navbar-expand-lg " style="background-color: #b0f89d;">
                <!--      <nav class="navbar bg-primary navbar-expand-lg bg-body-tertiary bg-primary"  data-bs-theme="" >-->
                <!--      <nav class="navbar bg-primary" data-bs-theme="dark">-->
                <div class="container-fluid">
                    <a class="navbar-brand" href="/lunch/list">목록가기</a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                            data-bs-target="#navbarTogglerDemo02" aria-controls="navbarTogglerDemo02"
                            aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
                        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                            <li class="nav-item">
                                <a class="nav-link active" aria-current="page" href="/lunch/register">글작성</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">Link</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link disabled" aria-disabled="true">Disabled</a>
                            </li>
                        </ul>
                        <%--            <form class="d-flex" role="search">--%>
                        <%--              <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">--%>
                        <%--              <button class="btn btn-outline-success" type="submit">Search</button>--%>
                        <%--            </form>--%>
                    </div>
                </div>
            </nav>
        </div>
    </div>
    <!--  Navbar 종료-->

    <%--검색 화면 구성 넣기--%>
    <div class="row content">
        <div class="col">
            <!--부트 스트랩 5.3 Card 컴포넌트 Header and Footer 의 샘플 가져오기-->
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">검색화면</h5>
                    <form action="/lunch/list" method="get">
                        <%--            <input type="hidden" name="page" value="${pageRequestDTO.page}">--%>
                        <input type="hidden" name="size" value="${pageRequestDTO.size}">
                        <div class="mb-3">
                            <input type="checkbox" name="finished" ${pageRequestDTO.finished ? "checked" : ""}> 완료여부
                        </div>
                        <div class="mb-3">
                            <input type="checkbox" name="types"
                                   value="t" ${pageRequestDTO.checkType("t") ? "checked" :""}> 제목
                            <input type="checkbox" name="types"
                                   value="w" ${pageRequestDTO.checkType("w") ? "checked" :""}> 작성자
                            <input type="text" name="keyword" class="form-control" placeholder="검색어를 입력해주세요."
                                   value="${pageRequestDTO.keyword}">
                        </div>

                        <div class="input-group dueDateDiv mb-3">
                            <input type="date" name="from" class="form-control" value="${pageRequestDTO.from}">
                            <input type="date" name="to" class="form-control" value="${pageRequestDTO.to}">
                        </div>

                        <div class="input-group dueDateDiv mb-3">
                            <button type="submit" class="btn btn-primary">검색하기</button>
                            <button type="reset" class="btn btn-warning">초기화하기</button>
                        </div>
                        <c:if test="${pageResponseDTO.total != null}">
                            <div class="input-group dueDateDiv mb-3">
                                <h3>검색 갯수 : ${pageResponseDTO.total}</h3>
                            </div>
                        </c:if>

                    </form>
                    <%--초기화 버튼 클릭시, 문자열 내용도 초기화되고, 페이지도 1페이지로 이동--%>
                    <script>
                        document.querySelector(".btn-warning").addEventListener("click", function (e) {
                            e.preventDefault()
                            e.stopPropagation()
                            self.location = "/lunch/list"
                        })
                    </script>
                </div>
            </div>
        </div>
    </div>
    <%--  검색 화면 구성 넣기--%>

    <!--  본문 시작-->
    <div class="row content">
        <div class="col">
            <!--부트 스트랩 5.3 Card 컴포넌트 Header and Footer 의 샘플 가져오기-->
            <div class="card">
                <div class="card-header">
                    목록
                </div>
                <div class="card-body">
                    <%--         리스트의 목록의 요소를 넣기--%>
                    <%--          ${dtoList}--%>
                    <table class="table">
                        <thead>
                        <tr>
                            <th scope="col">Nno</th>
                            <th scope="col">LunchTitle</th>
                            <th scope="col">Writer</th>
                            <th scope="col">DueDate</th>
                            <th scope="col">Finished</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${pageResponseDTO.dtoList}" var="dto">
                            <tr>
                                <th scope="row"><c:out value="${dto.mno}"/></th>
                                <td><a href="/lunch/read?mno=${dto.mno}&${pageRequestDTO.link}"><c:out
                                        value="${dto.lunchTitle}"/></a></td>
                                <td><c:out value="${dto.writer}"/></td>
                                <td><c:out value="${dto.dueDate}"/></td>
                                <td><c:out value="${dto.finished}"/></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>

                    <%--페이징 부트스트랩 추가하기--%>
                    <div class="paging-container">
                        <ul class="pagination paging-content">
                            <%--  <div>--%>
                            <%--  <ul class="pagination">--%>
                            <%--이전화면이 나오고--%>
                            <c:if test="${pageResponseDTO.prev}">
                                <li class="page-item">
                                    <a class="page-link" data-num="${pageResponseDTO.start-1}">Previous</a>
                                </li>
                            </c:if>
                            <%--페이지 : 1  ~  10 개 출력--%>
                            <%--서버에서 받아온 데이터를 적용하기--%>
                            <c:forEach begin="${pageResponseDTO.start}" end="${pageResponseDTO.end}" var="num">
                                <li class="page-item ${pageResponseDTO.page == num ? "active":""}">
                                    <a class="page-link" data-num="${num}">${num}</a>
                                </li>
                            </c:forEach>
                            <%-- 다음 화면 이 나오고--%>
                            <c:if test="${pageResponseDTO.next}">
                                <li class="page-item">
                                    <a class="page-link" data-num="${pageResponseDTO.end +1}">Next</a>
                                </li>
                            </c:if>
                        </ul>
                    </div>
                    <script>
                        document.querySelector(".pagination").addEventListener("click", function (e) {
                            e.preventDefault()
                            e.stopPropagation()

                            const target = e.target
                            // a 태그 가 아니면 해당 클릭 이벤트 함수를 나간다.
                            if (target.tagName !== 'A') {
                                return
                            }
                            // tagName 전부 a 태그만 살아 남음.
                            const num = target.getAttribute("data-num")

                            // 추가, 검색 및 필터 관련 정보를 추가해서, 페이징 이동하기.
                            const formObj = document.querySelector("form")
                            formObj.innerHTML += `<input type="hidden" name="page" value="\${num}">`
                            formObj.submit()
                            // self.location = `/lunch/list?page=\${num}`

                        }, false)
                    </script>
                    <%--페이징 부트스트랩 추가하기--%>

                </div>
            </div>
        </div>
    </div>
    <div class="row footer">
        <div class="row fixed-bottom" style="z-index: -100">
            <footer class="py-1 my-1">
                <p class="text-center text-muted">Footer</p>
            </footer>
        </div>

    </div>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
</body>
</html>
