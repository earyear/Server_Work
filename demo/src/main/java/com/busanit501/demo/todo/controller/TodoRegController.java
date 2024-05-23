package com.busanit501.demo.todo.controller;

import com.busanit501.demo.todo.dto.TodoDTO;
import com.busanit501.demo.todo.service.TodoService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;

@Log4j2
@WebServlet(name = "todoReg", urlPatterns = "/todo/register")
public class TodoRegController extends HttpServlet {

    private TodoService todoService = TodoService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //세션 정보 조회
        HttpSession session = req.getSession();

        //조회    웹브라우저 > 서버에 최초 접근하면 새로운 시스템 쿠키 만들어주고,
        //로그인으로 돌려보내기
        if(session.isNew()){
            log.info("뉴 JsessionID");
            resp.sendRedirect("/login");
            return;
        }

        //세션의 로그인 정보를 저장할 공간에 정보 있다면, 로그인 성공 > 리스트
        //없다면, 다시 LOGIN폼으로 이동
        //GETTER
        if(session.getAttribute("loginInfo") == null){
            log.info("로그인 정보가 없는 유저");
            resp.sendRedirect("/login");
            return;
        }


        RequestDispatcher requestDispatcher=req.getRequestDispatcher("/WEB-INF/todo/todoReg.jsp");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //TodoDTO 타입을 받아서 서비스에 전달
        TodoDTO todoDTO=TodoDTO.builder()
                .title(req.getParameter("title"))
                .dueDate(LocalDate.parse(req.getParameter("dueDate")))
                .build();

        //실제 데이터 입력
        try {
            todoService.register2(todoDTO);
            resp.sendRedirect("/todo/list");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
