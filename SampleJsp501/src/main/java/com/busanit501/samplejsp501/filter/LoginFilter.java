package com.busanit501.samplejsp501.filter;

import com.busanit501.samplejsp501.todo.dto.MemberDTO;
import com.busanit501.samplejsp501.todo.service.MemberService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

//로그인 필터 : 로그인하지 않으면 경로바꿔도(/todo/list) todo 페이지로 안들어가고 login으로 이동함.
@Log4j2
@WebFilter(urlPatterns = "/todo/*")
public class LoginFilter implements Filter {

    private Cookie findCookie(Cookie[] cookies, String cookieName){

        //쿠키가 없다면, 유효성 체크
        if(cookies == null || cookies.length == 0){
            return null;
        }

        //Optional<Cookie> : 결과 값이 존재한다면, 그값을 사용 없다면 null 반환
        Optional<Cookie> result = Arrays.stream(cookies)
                .filter(cookie -> cookie.getName().equals(cookieName)).findFirst();

        return result.isPresent()? result.get(): null;

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("로그인 필터 동작 여부 확인.");
        System.out.println("로그인 필터 동작 여부 확인.");
        //servletRequest가 HttpServletRequest의 상위이기에 다운캐스팅 필요함.
        HttpServletRequest req=(HttpServletRequest) servletRequest;
        HttpServletResponse resp=(HttpServletResponse) servletResponse;

        //세션을 이용하기 위한 도구 필요
        HttpSession session=req.getSession();

        //로그인 시, 세션의 임시 공간의 이름 : loginInfo
        if(session.getAttribute("loginInfo")!=null){
            //로그인 doFilter를 계속 하겠다.
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        //쿠키 체크 (쿠키 만듬)
        Cookie cookie = findCookie(req.getCookies(),"rememberC");

        // 1) 쿠키가 없다면, login으로 가라!
        if(cookie==null){
            resp.sendRedirect("/login");
            return;
        }

        // 2) 쿠키가 있다. 쿠키에서 uuid를 가져옴.
        String uuid = cookie.getValue();
        try{
            MemberDTO memberDTO = MemberService.INSTANCE.selectUUID(uuid);

            //memberDTO가 없다면, 회원이 없다면.
            if(memberDTO==null){
                //강제로 예외발생시킴
                throw new Exception("쿠키 값에 해당하는 유저가 없다.");
            }
            session.setAttribute("loginInfo",memberDTO); //세션에 저장함.
            filterChain.doFilter(servletRequest, servletResponse);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
