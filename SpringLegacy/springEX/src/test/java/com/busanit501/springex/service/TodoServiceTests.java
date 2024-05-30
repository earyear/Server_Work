package com.busanit501.springex.service;

import com.busanit501.springex.dto.TodoDTO;
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
public class TodoServiceTests {

  // 기본이 true 인데, 만약 해당 빈이 없다면, 널 오류가 발생.
  // 널도 허용가능.
  @Autowired(required = false)
  private TodoService todoService;


  @Test
  public void testInsert() {
    // 임시 TodoVO , 인스턴스 필요하고,
    TodoDTO todoDTO = TodoDTO.builder()
        .title("돈까스33333333333333333333333333")
        .dueDate(LocalDate.now())
        .finished(false)
        .writer("이상용333333333333333333")
        .build();
    todoService.insert(todoDTO);
  }

  @Test
  public void testListAll() {
    List<TodoDTO> todoList = todoService.listAll();
    todoList.forEach(dto -> log.info("dto : " + dto));
  }

}







