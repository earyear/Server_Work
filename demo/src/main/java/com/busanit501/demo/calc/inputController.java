package com.busanit501.demo.calc;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="inputController", urlPatterns = "/calc/input")
public class inputController extends HttpServlet {

    //get >폼화면 그려줌(로그인 화면), post > 화면처리(로그인 처리)

    //컨트롤러: 화면페이지로 안내 > 화면 전달.
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        System.out.println("작업순서 1 : InputController 거쳐감");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/calc/input.jsp");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        //재정의 > calc를 처리한 결과 페이지로 가는게 목적.
        String num1= req.getParameter("num1");
        String num2= req.getParameter("num2");
        System.out.println("num1 : "+num1+" num2 : "+num2);
    }
}
