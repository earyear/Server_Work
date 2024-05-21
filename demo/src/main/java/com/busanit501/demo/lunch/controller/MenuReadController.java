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

@Log4j2
@WebServlet(name ="readMenu", urlPatterns = "/menuRead")
public class MenuReadController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("no"));

        try {
            MenuDTO menuDTO = MenuService.INSTANCE.selectOne(id);
            log.info(menuDTO);

            req.setAttribute("menu", menuDTO);
            req.getRequestDispatcher("/WEB-INF/menu/menuRead.jsp").forward(req, resp);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
