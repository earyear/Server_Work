package com.busanit501.demo.login;

import com.busanit501.demo.lunch.service.MenuMemberService;
import com.busanit501.demo.todo.dto.MemberDTO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.UUID;

@WebServlet(name = "loginmenu", urlPatterns = "/loginmenu")
public class MenuLoginController extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // 로그인 입력폼으로 전달.
    System.out.println("get 으로 login 처리");
    RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/login/loginMenu.jsp");
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

    //DB속 아이디 비번을 가져와서 화면의 아이디 비번과 비교.
    try{
      MemberDTO memberDTO = MenuMemberService.INSTANCE.getSelectOne(mid, mpw);
      if(remember){
        //체크되었다면 UUID생성
        String uuid = UUID.randomUUID().toString();

        MenuMemberService.INSTANCE.updateUUID(mid, uuid); //실제 DB에 데이터 업데이트함
        memberDTO.setUuid(uuid); //임시모델에 같은 uuid 담음

        //쿠키에 생성한 uuid 랜덤 문자열 넣기 (쿠키 생성 기본 인스턴스)
        Cookie rememberCookie = new Cookie("rememberC", uuid);
        rememberCookie.setMaxAge(60*60*24*7);
        rememberCookie.setPath("/"); //적용범위
        resp.addCookie(rememberCookie);

        HttpSession session = req.getSession();

        session.setAttribute("loginInfo", memberDTO);
        resp.sendRedirect("/menu/list");
      }
      else {
          //자동로그인 체크 안했을때
          HttpSession session = req.getSession();

          session.setAttribute("loginInfo", memberDTO);
          resp.sendRedirect("/menu/list");
      }
    } catch (Exception e) {
      resp.sendRedirect("/loginmenu?result=error");
//        throw new RuntimeException(e);
    }
  }
}







