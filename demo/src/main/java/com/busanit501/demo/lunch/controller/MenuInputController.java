package com.busanit501.demo.lunch.controller;

import com.busanit501.demo.lunch.dto.MenuDTO;
import com.busanit501.demo.lunch.service.MenuService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "MenuInputController", urlPatterns = "/menu/input")
public class MenuInputController extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // 기본, 뷰 jsp 파일로 전달하기.
    RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/menu/menuInput.jsp");
    requestDispatcher.forward(req, resp);

  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    MenuDTO menuDTO = MenuDTO.builder()
            .name(req.getParameter("menu"))
            .dueDate(LocalDate.parse(req.getParameter("dueDate")))
            .build();

      //입력 받은 값 넣기
      try {
          MenuService.INSTANCE.insert(menuDTO);
          resp.sendRedirect("/menu/list");
      } catch (Exception e) {
          throw new RuntimeException(e);
      }

  }
}







