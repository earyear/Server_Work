package com.busanit501.demo.todo.dao;

import com.busanit501.demo.todo.domain.MemberVo;
import lombok.Cleanup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDAO {
    public MemberVo getPassword(String id, String pw) throws Exception{
        String sql="select * from tbl_member where mid=? and mpw=?";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, id);
        pstmt.setString(2, pw);
        @Cleanup ResultSet rs = pstmt.executeQuery();
        rs.next(); //select 한놈이라서 while문 필요없음

        MemberVo memberVo = MemberVo.builder()
                .mid(rs.getString("mid"))
                .mpw(rs.getString("mpw"))
                .mname(rs.getString("mname"))
                .uuid(rs.getString("uuid"))
                .build();

        return memberVo;
    }

    public void updateUUID(String id, String uuid) throws Exception{
        String sql="update tbl_member set uuid=? where mid=?";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, uuid);
        pstmt.setString(2, id);
        pstmt.executeUpdate();
    }
}
