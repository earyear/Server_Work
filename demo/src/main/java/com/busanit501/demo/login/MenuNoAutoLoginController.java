package com.busanit501.demo.login;

import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

@Log4j2
@WebServlet(name ="noautologinmenu", urlPatterns = "/noautomenu")
public class MenuNoAutoLoginController extends HttpServlet {

    private Cookie findCookie(Cookie[] cookies, String cookieName){

        //쿠키가 없다면, 유효성 체크 > 리턴 null.
        if(cookies == null || cookies.length == 0){
            return null;
        }

        //Optional<Cookie> : 결과 값이 존재한다면, 그값을 사용 없다면 null 반환
        Optional<Cookie> result = Arrays.stream(cookies)
                .filter(cookie -> cookie.getName().equals(cookieName)).findFirst();

        return result.isPresent()? result.get(): null;

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("자동로그인 해제, 쿠키해제함");

        //쿠키 해제하는 코드 > 쿠키값을 유효시간 0으로 만들어줌.
        //쿠키제거하는 기능이 없어서 유효시간을 0으로 만들어줘서 사라지는 것처럼 할 수 있음.
        Cookie cookie = findCookie(req.getCookies(),"rememberC");
        cookie.setPath("/");
        cookie.setMaxAge(0);
        cookie.setValue("");
        resp.addCookie(cookie);

        resp.sendRedirect("/menu/list");
    }
}
