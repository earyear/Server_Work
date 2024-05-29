package com.busanit501.samplejsp501.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(urlPatterns = {"/*"})
public class KoreanCheckFilter implements Filter {

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                       FilterChain filterChain) throws IOException, ServletException {

    HttpServletRequest req  = (HttpServletRequest)servletRequest;
    req.setCharacterEncoding("UTF-8");

    filterChain.doFilter(servletRequest,servletResponse);
  }
}







