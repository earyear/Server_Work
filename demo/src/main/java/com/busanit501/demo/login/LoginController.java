package com.busanit501.demo.login;

import com.busanit501.demo.todo.dto.MemberDTO;
import com.busanit501.demo.todo.service.MemberService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.UUID;

@WebServlet(name = "loginController", urlPatterns = "/login")
public class LoginController extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // 로그인 입력폼으로 전달.
    System.out.println("get 으로 login 처리");
    RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/login/login.jsp");
    requestDispatcher.forward(req,resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    //SETTER, 화면에서 아이디, 패스워드 먼저 받기
    String mid = req.getParameter("mid");
    String mpw = req.getParameter("mpw");

    String check =req.getParameter("auto");
    // 상태 변수, 자동 로그인 체크 여부
    boolean remember = check != null && check.equals("on");

    //체크되었다면 UUID생성
    if(remember){
      String uuid = UUID.randomUUID().toString();
    }


    //DB속 아이디 비번을 가져와서 화면의 아이디 비번과 비교.
    try{
      MemberDTO memberDTO = MemberService.INSTANCE.getSelectOne(mid, mpw);
      HttpSession session = req.getSession();

      session.setAttribute("loginInfo", memberDTO);
      resp.sendRedirect("/todo/list");

    } catch (Exception e) {
      resp.sendRedirect("/login?result=error");
//        throw new RuntimeException(e);
    }
//
//    //로그인해야지 세션 생김.
//    String user = mid + mpw;
//
//    HttpSession session = req.getSession();
//
//    session.setAttribute("loginInfo", user);
//    resp.sendRedirect("/todo/list");
  }
}







