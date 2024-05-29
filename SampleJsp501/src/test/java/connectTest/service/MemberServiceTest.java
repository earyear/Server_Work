package connectTest.service;

import com.busanit501.samplejsp501.todo.dto.MemberDTO;
import com.busanit501.samplejsp501.todo.service.MemberService;
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
    public void selectTest() throws Exception {

        MemberDTO memberDTO =memberService.getSelectOne("ngy","1234");
        log.info("값 나옴 : "+memberDTO);
    }

    @Test
    public void selectUUID() throws Exception{
        MemberDTO dto =memberService.selectUUID("f29cbe4a-8c26-4f49-9d5d-05773dd47bdd");
        log.info(dto);
    }

    @Test
    public void insertTest() throws Exception {

        MemberDTO memberDTO = MemberDTO.builder()
                .mid("example")
                .mpw("8887")
                .mname("서비스테스트예시")
                .build();
        memberService.insertMember(memberDTO);
        //DB에서 확인
    }
}
