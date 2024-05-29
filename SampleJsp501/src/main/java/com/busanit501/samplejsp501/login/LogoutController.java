package com.busanit501.samplejsp501.login;

import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Log4j2
@WebServlet(name ="logout", urlPatterns = "/logout")
public class LogoutController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //로그아웃 처리, 세션의 정보 삭제
        log.info("로그아웃 처리");
        HttpSession session = req.getSession();

        session.removeAttribute("loginInfo");
        session.invalidate();

        resp.sendRedirect("/login");
    }
}
