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
import java.io.IOException;
@Log4j2
@WebServlet(name="todoRead", urlPatterns = "/todo/read")
public class TodoReadController extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            Long tno = Long.valueOf(req.getParameter("tno"));
            TodoDTO todoDTO = TodoService.INSTANCE.selectone(tno);
            log.info(todoDTO);

            req.setAttribute("sample", todoDTO);
            RequestDispatcher requestDispatcher=req.getRequestDispatcher("/WEB-INF/todo/todoRead.jsp");
            requestDispatcher.forward(req,resp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }



//    내가 하다가 던진 코드
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Long tno = Long.parseLong(req.getParameter("tno"));
//
//        try {
//            TodoDTO todoDTO = TodoService.INSTANCE.selectone(tno);
//            req.setAttribute("DTO", todoDTO);
//            req.getRequestDispatcher("/WEB-INF/todo/todoRead.jsp")
//                    .forward(req,resp);
//
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
}
