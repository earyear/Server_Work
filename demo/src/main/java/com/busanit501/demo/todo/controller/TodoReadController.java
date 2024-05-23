package com.busanit501.demo.todo.controller;

import com.busanit501.demo.todo.dto.TodoDTO;
import com.busanit501.demo.todo.service.TodoService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Log4j2
@WebServlet(name="todoRead", urlPatterns = "/todo/read")
public class TodoReadController extends HttpServlet {

    private Cookie findCookie(Cookie[] cookies, String cookieName){
        //찾은 쿠키를 담을 임시 쿠키
        Cookie targetCookie = null;

        //쿠키 있다면.
        if(cookies != null && cookies.length>0){
            for(Cookie cookie : cookies){
                if(cookie.getName().equals(cookieName)){
                    targetCookie = cookie;
                    break;
                }
            }
        }
        //쿠키가 없다면. 쿠키 설정
        if(targetCookie == null){
            targetCookie = new Cookie(cookieName, "");
            targetCookie.setPath("/");
            targetCookie.setMaxAge(60*60*24); //24시간
        }
        return targetCookie;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            //DB에서 결과 가지고 옴
            Long tno = Long.valueOf(req.getParameter("tno"));
            TodoDTO sample  = TodoService.INSTANCE.selectone(tno);
            log.info(sample);

            //화면 전달
            req.setAttribute("sample", sample);

            //쿠키 찾기
            //viewTodo > 내가 찾고 싶은 쿠키, req.getCookies() > 전체 쿠키
            Cookie viewTodoCookie = findCookie(req.getCookies(), "viewTodo");
            String todoListResult = viewTodoCookie.getValue();
            boolean exist = false;

            if(todoListResult != null && todoListResult.indexOf(tno+"-")>=0) {
                exist = true;
            }

            //exist > false : 최근에 본 내용이 쿠키에 저장되어있지 않음.
            if(!exist){
                todoListResult += tno+"-";
                viewTodoCookie.setValue(todoListResult);
                viewTodoCookie.setMaxAge(60*60*24);     //쿠키 생존 주기, 시간
                viewTodoCookie.setPath("/");            //쿠키 적용 범위, 경로
                resp.addCookie(viewTodoCookie);
            }

            RequestDispatcher requestDispatcher=req.getRequestDispatcher("/WEB-INF/todo/todoRead.jsp");
            requestDispatcher.forward(req,resp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }



//    내가 하다가 던진 코드
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Long tno = Long.parseLong(req.getParameter("tno"));
//
//        try {
//            TodoDTO todoDTO = TodoService.INSTANCE.selectone(tno);
//            req.setAttribute("DTO", todoDTO);
//            req.getRequestDispatcher("/WEB-INF/todo/todoRead.jsp")
//                    .forward(req,resp);
//
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
}
