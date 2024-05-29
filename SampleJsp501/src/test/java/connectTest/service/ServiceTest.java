package connectTest.service;

import com.busanit501.samplejsp501.todo.dto.TodoDTO;
import com.busanit501.samplejsp501.todo.service.TodoService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class ServiceTest {

    private TodoService todoService;

    @BeforeEach
    public void ready() {
        todoService = TodoService.INSTANCE;
    }

    @Test
    public void serviceTest() throws Exception {
        //인자값으로 todoDTO를 사용해야함,
        TodoDTO todoDTO = TodoDTO.builder()
                .title("샘플11")
                .dueDate(LocalDate.now())
                .finished(false)
                .build();

        System.out.println(todoDTO);
        todoService.register2(todoDTO);
    }

    @Test
    public void serviceTest2() throws Exception {
        todoService.delete(31L);
    }


}
