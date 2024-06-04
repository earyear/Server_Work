package com.ngy0428.lunchEx.mapper;

import com.ngy0428.lunchEx.domain.LunchVO;
import com.ngy0428.lunchEx.dto.PageRequestDTO;
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
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                .page(1)
                .size(10)
                .build();

        List<LunchVO> todoList = lunchMapper.listAll(pageRequestDTO);
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

    // 검색시, 타입에 관련된 테스트
    // 화면 -> 서버, 페이징 정보를 담아서 보내고 , PageRequestDTO + 검색, 필터 준비물
    @Test
    public void testSelectTypes() {
        // 테스트용 더미 PageRequestDTO 만들기.
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                .page(1)
                .size(10)
                .keyword("족발")
                // 검색 조건이, 작성자 또는 제목
                .types(new String[]{"t","w"})
                .from(LocalDate.of(2024,5,1))
                .to(LocalDate.of(2024,5,31))
                .finished(true)
                .build();

        List<LunchVO> voList  = lunchMapper.listAll(pageRequestDTO);
        voList.forEach(vo -> log.info("vo : " + vo ));
    }
}
