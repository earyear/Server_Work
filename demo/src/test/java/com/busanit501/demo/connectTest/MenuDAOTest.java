package com.busanit501.demo.connectTest;

import com.busanit501.demo.lunch.dao.MenuDAO;
import com.busanit501.demo.lunch.domain.MenuVo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
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

    @Test
    public void selectOneMenu() throws Exception{
        MenuVo vo = menuDAO.selectOneMenu(2L);

        System.out.println("특정한 행 : "+vo);
    }

    @Test
    public void insertMenu() throws Exception{
        MenuVo vo = MenuVo.builder()
                .name("샌드위치")
                .dueDate(LocalDate.of(2023,04,28))
                .build();

        menuDAO.insert(vo);
    }

    @Test
    public void updateMenu() throws Exception{
        MenuVo vo = MenuVo.builder()
                .name("피자")
                .dueDate(LocalDate.of(2023,02,06))
                .no(2L)
                .build();

        menuDAO.update(vo);
    }

    @Test
    public void deleteMenu() throws Exception{
        menuDAO.delete(3L);
    }
}
