package com.busanit501.demo.lunch.dao;

import com.busanit501.demo.lunch.domain.MenuVo;
import lombok.Cleanup;

import java.sql.Connection;
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

}
