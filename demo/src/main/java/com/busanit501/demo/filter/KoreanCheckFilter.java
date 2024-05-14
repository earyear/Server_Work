package com.busanit501.demo.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

// 현재 , http://localhost:8080/ -> /
// / 이하 경로는 전부다, 현재 KoreanCheckFilter 걸쳐서 지나간다.
@WebFilter(urlPatterns = {"/*"})
public class KoreanCheckFilter implements Filter {

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

    // 한글 UTF-8 설정.
    // ServletRequest(부모) 는  HttpServletRequest(자식) 의 상위 개념.
    HttpServletRequest req  = (HttpServletRequest)servletRequest;
    req.setCharacterEncoding("UTF-8");
// 필터 체인이라는 인스턴스에 적용한다.
    filterChain.doFilter(servletRequest,servletResponse);

  }
}







