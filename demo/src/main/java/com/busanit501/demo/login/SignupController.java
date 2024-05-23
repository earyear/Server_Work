package com.busanit501.demo.login;

import com.busanit501.demo.todo.dto.MemberDTO;
import com.busanit501.demo.todo.service.MemberService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SignupController", urlPatterns = "/signup")
public class SignupController extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // 로그인 입력폼으로 전달.
    System.out.println("get 으로 signup 처리");
    RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/login/signup.jsp");
    requestDispatcher.forward(req,resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    //SETTER, 화면에서 아이디, 이름, 패스워드 먼저 받기
    String mid = req.getParameter("mid");
    String mpw = req.getParameter("mpw");
    String mname = req.getParameter("mname");

    //입력받은 내용을 MemberDTO > 서비스에 넣자!
    MemberDTO memberDTO = MemberDTO.builder()
            .mid(mid)
            .mpw(mpw)
            .mname(mname)
            .build();

      try {
          MemberService.INSTANCE.insertMember(memberDTO);
          resp.sendRedirect("/login");
      } catch (Exception e) {
          throw new RuntimeException(e);
      }
  }
}







