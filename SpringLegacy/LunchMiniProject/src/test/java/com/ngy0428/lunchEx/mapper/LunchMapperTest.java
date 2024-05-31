package com.ngy0428.lunchEx.mapper;

import com.ngy0428.lunchEx.domain.LunchVO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations ="file:src/main/webapp/WEB-INF/root-context.xml")
public class LunchMapperTest {

    @Autowired(required = false)
    private LunchMapper lunchMapper;

    @Test
    public void testInsert() {
        // 임시 TodoVO
        LunchVO lunchVO = LunchVO.builder()
                .lunchTitle("치킨")
                .dueDate(LocalDate.now())
                .finished(true)
                .writer("남견")
                .build();
        lunchMapper.insert(lunchVO);
    }

    @Test
    public void testSelect() {
        List<LunchVO> todoList = lunchMapper.listAll();
        todoList.forEach(vo -> log.info("vo : " + vo));
    }

    @Test
    public void testGetOne() {
        LunchVO todoVO = lunchMapper.getOne(2L);
        log.info("lunchVO : " + todoVO);
    }

    @Test
    public void testDelete() {
        lunchMapper.delete(2L);
    }
}
