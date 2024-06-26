package com.busanit501.ngylunchproject.repository;


import com.busanit501.ngylunchproject.domain.Lunch;
import com.busanit501.ngylunchproject.domain.Reply;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Log4j2
public class ReplyRepositoryTest {
    @Autowired
    private ReplyRepository replyRepository;

    @Test
    public void testInsert() {
        //실제 디비 각자 데이터에 따라서 다름.
        // 현재 bno = 900
        Long bno = 705L;

        Lunch lunch = Lunch.builder()
                .bno(bno)
                .build();

        Reply reply = Reply.builder()
                .lunch(lunch)
                .replyText("댓글 테스트")
                .replyer("테스터")
                .build();

        replyRepository.save(reply);

    }

    @Transactional
    @Test
    public void testReplies() {
        // 각자 테이블의 데이터 내용에 맞게.
        Long bno = 101L;

        Pageable pageable =
                PageRequest.of(0,10,
                        Sort.by("rno").descending());

       Page<Reply> result = replyRepository.listOfLunch(bno,pageable);

       result.getContent().forEach(reply -> {
           log.info("reply 확인 : " +reply);
       });

    }

}
