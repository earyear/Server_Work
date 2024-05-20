package com.busanit501.demo.todo.controller;

import com.busanit501.demo.todo.dto.TodoDTO;
import com.busanit501.demo.todo.service.TodoService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "todoReg", urlPatterns = "/todo/register")
public class TodoRegController extends HttpServlet {

    private TodoService todoService = TodoService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
