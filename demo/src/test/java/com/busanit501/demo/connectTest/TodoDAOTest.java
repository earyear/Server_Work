package com.busanit501.demo.connectTest;

import com.busanit501.demo.todo.dao.TodoDAO;
import com.busanit501.demo.todo.domain.TodoVo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TodoDAOTest {
    private TodoDAO todoDAO;

    //각 단위 테스트 실행전, 먼저실행되는 어노테이션
    //테스트별로 계속 생성하는것을 그냥 한번에 하기 위해..
    @BeforeEach
    public void ready() {
        todoDAO = new TodoDAO();
    }

    //단위 테스트는 리턴할 필요 없음 > 확인용이기 땜에 확인하고 패스
    @Test
    public void getTimeTest(){
        String time = todoDAO.getTime();
        System.out.println("time : "+time);
    }

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

        System.out.println("원하는 값 : "+todoVo);
    }



    //혼자해보는 TEST
    @Test
    public void selectTableTest(){
        String result = todoDAO.selectTable();
        System.out.println("문장가져옴 : "+result);
    }

    @Test
    public void selectOneTest(){
        String result = todoDAO.selectOne();
        System.out.println("한개 가져옴 : \n"+result);
    }
}
