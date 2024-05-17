package com.busanit501.demo.connectTest;

import com.busanit501.demo.lunch.dao.MenuDAO;
import com.busanit501.demo.lunch.domain.MenuVo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MenuDAOTest {
    private MenuDAO menuDAO;

    @BeforeEach
    public void ready() {
        menuDAO = new MenuDAO();
    }

    @Test
    public void selectMenu() throws Exception{
        List<MenuVo> list = menuDAO.selectAll();

        System.out.println("테이블 값 : " + list);
        list.forEach(vo ->System.out.println("각각 출력해보기 : " + vo) );
    }
}
