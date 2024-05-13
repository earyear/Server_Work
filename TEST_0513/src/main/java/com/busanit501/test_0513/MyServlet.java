package com.busanit501.test_0513;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet (name ="myServlet", urlPatterns = "/my")
public class MyServlet extends HttpServlet{

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + "내가 만든 쿠키~에서 답보내기 연습중!" + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}
