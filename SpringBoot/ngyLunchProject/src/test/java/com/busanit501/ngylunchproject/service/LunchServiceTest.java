package com.busanit501.ngylunchproject.service;

import com.busanit501.ngylunchproject.dto.LunchDTO;
import com.busanit501.ngylunchproject.dto.PageRequestDTO;
import com.busanit501.ngylunchproject.dto.PageResponseDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Log4j2
@SpringBootTest
public class LunchServiceTest {

    @Autowired
    LunchService lunchService;

    @Test
    public void insert(){
        //화면에서 넘어온 더미데이터(DTO)만들기
        LunchDTO lunchDTO = LunchDTO.builder()
                .title("욥22")
                .content("인사하기")
                .writer("남견")
                .build();

        Long bno = lunchService.register(lunchDTO);
        log.info("추가 후에 번호나 게시글 번호 : "+bno);
    }

    @Test
    public void read(){

        LunchDTO lunchDTO = lunchService.read(2L);
        log.info("하나 조회 Bno : "+lunchDTO);
    }

    @Test
    public void update(){
        //화면에서 넘어온 더미데이터(DTO)만들기
        LunchDTO lunchDTO = LunchDTO.builder()
                .bno(2L)
                .title("움하하하")
                .content("욥")
                .writer("남견쓰")
                .build();

        lunchService.update(lunchDTO);
        log.info("하나 조회 Dno : "+lunchDTO);
    }

    @Test
    public void delete(){
        lunchService.delete(3L);
    }

    @Test
    public void testList() {
        // 화면에서 전달할 내용을 담은 PageRequestDTO 더미가 필요.
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                .type("tcw")
                .keyword("더미")
                .page(1)
                .size(10)
                .build();

        PageResponseDTO<LunchDTO> responseDTO = lunchService.list(pageRequestDTO);
        log.info("list 테스트 responseDTO : " + responseDTO);

    }

}
