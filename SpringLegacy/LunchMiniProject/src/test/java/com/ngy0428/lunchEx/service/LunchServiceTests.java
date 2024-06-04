package com.ngy0428.lunchEx.service;


import com.ngy0428.lunchEx.dto.LunchDTO;
import com.ngy0428.lunchEx.dto.PageRequestDTO;
import com.ngy0428.lunchEx.dto.PageResponseDTO;
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
public class LunchServiceTests {

  // 기본이 true 인데, 만약 해당 빈이 없다면, 널 오류가 발생.
  // 널도 허용가능.
  @Autowired(required = false)
  private LunchService lunchService;


  @Test
  public void testInsert() {
    // 임시 lunchVO , 인스턴스 필요하고,
    LunchDTO lunchDTO = LunchDTO.builder()
        .lunchTitle("돈까스")
        .dueDate(LocalDate.now())
        .finished(false)
        .writer("이상용")
        .build();
    lunchService.insert(lunchDTO);
  }

  @Test
  public void testListAll() {
    PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
            .page(1)
            .size(10)
            .keyword("오늘")
            // 검색 조건이, 작성자 또는 제목
            .types(new String[]{"t","w"})
            .from(LocalDate.of(2024,5,1))
            .to(LocalDate.of(2024,5,31))
            .finished(true)
            .build();

//    List<LunchDTO> lunchList = lunchService.listAll(pageRequestDTO);
//    lunchList.forEach(dto -> log.info("dto : " + dto));
    PageResponseDTO<LunchDTO> pageResponseDTO = lunchService.listAll(pageRequestDTO);
    log.info("pageResponseDTO : " + pageResponseDTO);
    // 목록 확인
    pageResponseDTO.getDtoList().stream().forEach(lunchDTO -> log.info("lunchDTO : " + lunchDTO));
    // 전체 갯수 확인.
    log.info("전체 갯수 : " +pageResponseDTO.getTotal() );
    // PageRequestDTO 내용물 확인.
    log.info("PageRequestDTO 내용물 확인. : " +pageResponseDTO.getSize() );

  }

  @Test
  public void testGetOne() {
    LunchDTO lunchDTO = lunchService.getOne(1L);
    log.info("lunchDTO : " + lunchDTO);
  }

  @Test
  public void testDelete() {
    lunchService.delete(4L);

  }

  @Test
  public void testUpdate() {
//    수정 하기위한 더미 데이터 만들기.
    LunchDTO lunchDTO = LunchDTO.builder()
        .mno(1L)
        .lunchTitle("족발 워너비 고씨")
        .dueDate(LocalDate.of(2024,6,1))
        .finished(false)
        .build();

    lunchService.update(lunchDTO);

  }

}







