package com.busanit501.demo.lunch;

import com.busanit501.demo.lunch.dto.MenuDTO;
import com.busanit501.demo.lunch.service.MenuService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name="lunchMenu", urlPatterns = "/lunchMenu")
public class MenuController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet 들어옴");

        List<MenuDTO> samplelist = MenuService.INSTANCE.getList();
        req.setAttribute("menulist",samplelist);
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/menu/menuList.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        String menu= req.getParameter("menu");
//
//        if (menu.equals("mac")) {
//            // 메인, index 로가기.
//            System.out.println("먹고싶은 메뉴 : ");
//            resp.sendRedirect("/lunchMenu");
//        } else {
//            // 실패면, 로그인 폼으로 가기.
//            System.out.println("[같지않음] 입력받은 메뉴 : ");
//            resp.sendRedirect("/menuList");
//        }
        resp.sendRedirect("/menuList");
    }
}
