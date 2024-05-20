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
import java.util.List;

@Log4j2
@WebServlet(name = "todoList", urlPatterns = "/todo/list")
public class TodoListController extends HttpServlet {

    //서비스 인스턴스 주입, 포함
    private TodoService todoService = TodoService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        try {
            List<TodoDTO> samplelist = todoService.listAll();
            log.info("listcontroller 확인 : " + samplelist);
            //임시 리스트
//        List<TodoDTO> samplelist = TodoService.INSTANCE.getList();
            req.setAttribute("list",samplelist);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/todo/todoList.jsp");
            requestDispatcher.forward(req,resp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
