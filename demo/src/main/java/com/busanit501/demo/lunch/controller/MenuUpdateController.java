package com.busanit501.demo.lunch.controller;

import com.busanit501.demo.lunch.dto.MenuDTO;
import com.busanit501.demo.lunch.service.MenuService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@Log4j2
@WebServlet(name ="updateMenu", urlPatterns = "/menu/Update")
public class MenuUpdateController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("no"));

        try {
            MenuDTO dto = MenuService.INSTANCE.selectOne(id);
            log.info("업데이트 컨트롤러 get값 : "+dto);

            request.setAttribute("menu", dto);
            request.getRequestDispatcher("/WEB-INF/menu/menuUpdate.jsp").forward(request, response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Long id = Long.parseLong(request.getParameter("no"));
        String name = request.getParameter("name");
        LocalDate date = LocalDate.parse(request.getParameter("dueDate"));

        log.info("no : "+id+"name : "+name+"dueDate : "+date);

        MenuDTO dto = MenuDTO.builder()
                .no(id)
                .name(name)
                .dueDate(date)
                .build();

        try {
            MenuService.INSTANCE.update(dto);
            response.sendRedirect("/menu/list");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
