package com.busanit501.demo;

import com.busanit501.demo.mapper.TimeMapper;
import com.busanit501.demo.mapper.TimeMapper2;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@Log4j2
// 스프링 레거시에서 단위테스트 를 위한 설정 관련.
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations ="file:src/main/webapp/WEB-INF/root-context.xml")
public class TimeMapperTest {

    @Autowired(required = false)
    private TimeMapper timeMapper;

    @Autowired(required = false)
    private TimeMapper2 timeMapper2;

    @Test
    public void timeTest() {
        log.info("마이바티스 설정 확인 중, 매퍼테스트: "+timeMapper.getTime());
    }

    @Test
    public void timeTest2() {
        log.info("마이바티스 설정 확인 중, 매퍼테스트: "+timeMapper2.getNow());
    }

}






