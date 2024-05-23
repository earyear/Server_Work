package com.busanit501.demo.lunch.controller;

import com.busanit501.demo.lunch.service.MenuService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Log4j2
@WebServlet(name ="deleteMenu", urlPatterns = "/menu/Delete")
public class MenuDeleteController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            Long id = Long.parseLong(request.getParameter("no"));
            MenuService.INSTANCE.delete(id);
            response.sendRedirect("/menu/list");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
