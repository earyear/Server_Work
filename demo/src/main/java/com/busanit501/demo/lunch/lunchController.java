package com.busanit501.demo.lunch;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="lunchController", urlPatterns = "/l")
public class lunchController extends HttpServlet {

    //get >폼화면 그려줌(로그인 화면), post > 화면처리(로그인 처리)

    //컨트롤러: 화면페이지로 안내 > 화면 전달.
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        System.out.println("작업순서 1 : lunchController 거쳐감");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/lunch/input.jsp");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        //재정의 > lunch를 처리한 결과 페이지로 가는게 목적.
        String num1= req.getParameter("num1");

        if (num1.equals("mac")) {
            // 메인, index 로가기.
            System.out.println("먹고싶은 메뉴 : "+num1);
            resp.sendRedirect("/");
        } else {
            // 실패면, 로그인 폼으로 가기.
            System.out.println("[같지않음] 입력받은 메뉴 : "+num1);
            resp.sendRedirect("/l");
        }

    }
}
