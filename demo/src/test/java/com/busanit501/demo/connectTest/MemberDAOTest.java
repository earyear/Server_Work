package com.busanit501.demo.connectTest;

import com.busanit501.demo.todo.dao.MemberDAO;
import com.busanit501.demo.todo.domain.MemberVo;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//DAO의 하나의 기능을 만들었으면, 무조건 기능테스트 하기!!
@Log4j2
public class MemberDAOTest {
    private MemberDAO memberDAO;

    //각 단위 테스트 실행전, 먼저실행되는 어노테이션
    //테스트별로 계속 생성하는것을 그냥 한번에 하기 위해..
    @BeforeEach
    public void ready() {
        memberDAO = new MemberDAO();
    }


    @Test
    public void selectONETest() throws Exception{
        MemberVo memberVo = memberDAO.getPassword("ngy","1234");

        System.out.println("원하는 값 : "+memberVo);
    }

    @Test
    public void updateUUIDTest() throws Exception{
        memberDAO.updateUUID("ngy","test");
        log.info(memberDAO);
    }

    @Test
    public void selectUUIDTest() throws Exception{
        MemberVo memberVo =memberDAO.selectUUID("e2a04a59-e0d2-46f8-9e95-cfceab26a015");
        log.info(memberVo);
    }

    @Test
    public void insertTest() throws Exception{
        MemberVo memberVo = MemberVo.builder()
                .mid("test2")
                .mpw("7777")
                .mname("예시")
                .build();
        memberDAO.insert(memberVo);
        log.info(memberDAO);
    }

}
