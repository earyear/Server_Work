package com.busanit501.demo.connectTest.service;

import com.busanit501.demo.todo.dto.MemberDTO;
import com.busanit501.demo.todo.service.MemberService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@Log4j2
public class MemberServiceTest {
    private MemberService memberService;

    @BeforeEach
    public void ready() {
        memberService = MemberService.INSTANCE;
    }

    @Test
    public void getselectTest() throws Exception {

        MemberDTO memberDTO =memberService.getSelectOne("ngy","1234");
        log.info("값 나옴 : "+memberDTO);
    }
}
