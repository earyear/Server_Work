package com.busanit501.demo.filter;

import com.busanit501.demo.lunch.service.MenuMemberService;
import com.busanit501.demo.todo.dto.MemberDTO;
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

@Log4j2
@WebFilter(urlPatterns = "/menu/*")
public class MenuLoginFilter implements Filter {

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

        //servletRequest가 HttpServletRequest의 상위 > 다운캐스팅 필요함.
        HttpServletRequest req=(HttpServletRequest) servletRequest;
        HttpServletResponse resp=(HttpServletResponse) servletResponse;

        //세션을 이용하기 위한 도구 필요
        HttpSession session=req.getSession();

        //로그인시, 세션의 임시 공간의 이름 : loginInfo
        if(session.getAttribute("loginInfo")!=null){
//            resp.sendRedirect("/login");
            //로그인 doFilter를 계속 하겠다.
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        //쿠키 체크
        Cookie cookie = findCookie(req.getCookies(),"rememberC");

        //세션에도 없고, 쿠키에도 없다면
        if(cookie==null){
            resp.sendRedirect("/loginmenu");
            return;
        }

        //쿠키가 존재하는 상황. 쿠키에서 uuid를 가져옴.
        String uuid = cookie.getValue();
        try{
            MemberDTO memberDTO = MenuMemberService.INSTANCE.selectUUID(uuid);

            //memberDTO가 없다면, 회원이없다면.
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
