package com.busanit501.demo.service;

import com.busanit501.demo.dto.BoardDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Log4j2
@SpringBootTest
public class BoardServiceTest {

    @Autowired
    BoardService boardService;

    @Test
    public void insert(){
        //화면에서 넘어온 더미데이터(DTO)만들기
        BoardDTO boardDTO = BoardDTO.builder()
                .title("욥")
                .content("인사하기")
                .writer("남견")
                .build();

        Long bno = boardService.register(boardDTO);
        log.info("추가 후에 번호나 게시글 번호 : "+bno);
    }

    @Test
    public void read(){

        BoardDTO boardDTO = boardService.read(55L);
        log.info("하나 조회 Bno : "+boardDTO);
    }

    @Test
    public void update(){
        //화면에서 넘어온 더미데이터(DTO)만들기
        BoardDTO boardDTO = BoardDTO.builder()
                .bno(55L)
                .title("움하하하")
                .content("욥")
                .writer("남견쓰")
                .build();

        boardService.update(boardDTO);
//        log.info("하나 조회 Dno : "+boardDTO);
    }

    @Test
    public void delete(){
        boardService.delete(20L);
    }

}
