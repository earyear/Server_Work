package com.busanit501.demo.lunch.controller;

import com.busanit501.demo.lunch.dto.MenuDTO;
import com.busanit501.demo.lunch.service.MenuService;
import com.busanit501.demo.todo.dto.MemberDTO;
import lombok.extern.log4j.Log4j2;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Log4j2
@WebServlet(name="lunchMenu", urlPatterns = "/menu/list")
public class MenuController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("doGet 들어옴");
        HttpSession session = req.getSession();
        MemberDTO memberDTO = (MemberDTO) session.getAttribute("loginInfo");
        log.info("doGet");

        try {
            List<MenuDTO> samplelist = MenuService.INSTANCE.listAll();
            log.info("samplelist 들어옴 : " + samplelist);
//            List<MenuDTO> samplelist = MenuService.INSTANCE.getList(); //임시리스트
            req.setAttribute("menulist",samplelist);
            req.setAttribute("memberDTO",memberDTO);
            RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/menu/menuList.jsp");
            rd.forward(req, resp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
