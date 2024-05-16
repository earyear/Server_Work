package com.busanit501.demo.member;

import com.busanit501.demo.member.dto.MemberDTO;
import com.busanit501.demo.member.service.MemberService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name="memeberlist", urlPatterns = "/memberlist")
public class memberListController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet 들어옴");

        List<MemberDTO> samplelist = MemberService.INSTANCE.getList();
        req.setAttribute("mlist",samplelist);
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/member/memberList.jsp");
        rd.forward(req, resp);
    }

}
