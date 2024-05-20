package com.busanit501.demo.lunch.dao;

import com.busanit501.demo.lunch.domain.MenuVo;
import lombok.Cleanup;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MenuDAO {

    //List 사용해서 select 전체 가져오기
    public List<MenuVo> selectAll() throws Exception{
        String sql="select * from lunchmenu";

        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        @Cleanup ResultSet rs = pstmt.executeQuery();

        List<MenuVo> list = new ArrayList<>();

        while (rs.next()){

            MenuVo todoVoBuilder = MenuVo.builder()
                    .no(rs.getLong("menuNo"))
                    .name(rs.getString("MenuTitle"))
                    .dueDate(rs.getDate("MenuRegDate").toLocalDate())
                    .build();

            list.add(todoVoBuilder);
        }
        return list;
    }

    //특정 행만 가져오기
    public MenuVo selectOneMenu(Long no) throws Exception{
        String sql="select * from lunchmenu where menuNo= ?";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = connection.prepareStatement(sql);

        pstmt.setLong(1, no);
        @Cleanup ResultSet rs = pstmt.executeQuery();

        rs.next(); //select 한놈이라서 while문 필요없음

        MenuVo vo = MenuVo.builder()
                .no(rs.getLong("menuno"))
                .name(rs.getString("MenuTitle"))
                .dueDate(rs.getDate("MenuRegDate").toLocalDate())
                .build();

        return vo;
    }

    //insert
    public void insert(MenuVo vo) throws Exception{
        String sql ="insert into lunchmenu(menutitle,menuregdate) values (?,?)";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = connection.prepareStatement(sql);

        pstmt.setString(1, vo.getName());
        pstmt.setDate(2, Date.valueOf(vo.getDueDate()));

        pstmt.executeUpdate();
    }

    //update
    public void update(MenuVo vo) throws Exception{
        String sql ="update lunchmenu set menuTitle=?,menuRegDate=? where menuNo=?";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = connection.prepareStatement(sql);

        pstmt.setString(1, vo.getName());
        pstmt.setDate(2, Date.valueOf(vo.getDueDate()));
        pstmt.setLong(3, vo.getNo());

        pstmt.executeUpdate();
    }

    //delete
    public void delete(Long no) throws Exception{
        String sql ="delete from lunchmenu where menuNo=?";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = connection.prepareStatement(sql);

        pstmt.setLong(1, no);
        pstmt.executeUpdate();
    }


}
