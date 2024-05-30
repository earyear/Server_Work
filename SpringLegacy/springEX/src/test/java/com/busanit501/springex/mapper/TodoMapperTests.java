package com.busanit501.springex.mapper;

import com.busanit501.springex.domain.TodoVO;
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
public class TodoMapperTests {

  // 기본이 true 인데, 만약 해당 빈이 없다면, 널 오류가 발생.
  // 널도 허용가능.
  @Autowired(required = false)
  private TodoMapper todoMapper;

  @Test
  public void testGetTime() {
    log.info("시간 테스트 : " + todoMapper.getTime());
  }

  @Test
  public void testInsert() {
    // 임시 TodoVO , 인스턴스 필요하고,
    TodoVO todoVO = TodoVO.builder()
        .title("돈까스22222222222222222222222222")
        .dueDate(LocalDate.now())
        .finished(false)
        .writer("이상용222222222222222222222222222")
        .build();
    todoMapper.insert(todoVO);
  }

  @Test
  public void testSelect() {
    List<TodoVO> todoVOList = todoMapper.listAll();
    todoVOList.forEach(vo -> log.info("vo : " + vo));
  }
}







