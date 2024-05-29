package connectTest;

import com.busanit501.samplejsp501.todo.dao.TodoDAO;
import com.busanit501.samplejsp501.todo.domain.TodoVo;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;
@Log4j2
public class TodoDAOTest {
    private TodoDAO todoDAO;

    //각 단위 테스트 실행전, 먼저실행되는 어노테이션
    //테스트별로 계속 생성하는것을 그냥 한번에 하기 위해..
    @BeforeEach
    public void ready() {
        todoDAO = new TodoDAO();
    }

    //단위 테스트는 리턴할 필요 없음 > 확인용이기 땜에 확인하고 패스
    //자동 반환 TEST
    @Test
    public void getTime2Test() throws Exception{
        String time = todoDAO.getTime2();
        System.out.println("time : "+time);
    }

    //전체 select
    @Test
    public void selectAll() throws Exception{
        List<TodoVo> list = todoDAO.selectAll();

        System.out.println("list : "+list);
        list.forEach(vo ->System.out.println("각각 출력해보기 : "+vo));
    }

    @Test
    public void selectONETest() throws Exception{
        TodoVo todoVo = todoDAO.selectONE(3L);

        log.info("원하는 todoVo : "+todoVo);
//        System.out.println("원하는 값 : "+todoVo);
    }

    //삽입
    @Test
    public void insertTest() throws Exception{
        TodoVo todoVo = TodoVo.builder()
                .title("오늘 점심 뭐?")
                .dueDate(LocalDate.of(22,04,30))
                .finished(false)
                .build();

        todoDAO.insert(todoVo);
    }

    //수정
    @Test
    public void updateTest() throws Exception{
        TodoVo todoVo = TodoVo.builder()
                .finished(false)
                .tno(3L)
                .title("샘플3번수정")
                .build();

        todoDAO.update(todoVo);
    }

    //삭제
    @Test
    public void deleteTest() throws Exception{
        todoDAO.delete(5L);
    }

}
