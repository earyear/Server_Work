package com.busanit501.demo.lunch.dao;

import com.busanit501.demo.todo.domain.MemberVo;
import lombok.Cleanup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDAO {
    //아이디 비번 DB에서 가져옴.
    public MemberVo getPassword(String id, String pw) throws Exception{
        String sql="select * from lunch_member where mid=? and mpw=?";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, id);
        pstmt.setString(2, pw);
        @Cleanup ResultSet rs = pstmt.executeQuery();
        rs.next();

        MemberVo memberVo = MemberVo.builder()
                .mid(rs.getString("mid"))
                .mpw(rs.getString("mpw"))
                .mname(rs.getString("mname"))
                .uuid(rs.getString("uuid"))
                .build();

        return memberVo;
    }

    //uuid 업데이트
    public void updateUUID(String id, String uuid) throws Exception{
        String sql="update lunch_member set uuid=? where mid=?";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, uuid);
        pstmt.setString(2, id);
        pstmt.executeUpdate();
    }

    //하나의 uuid 가져오는 기능
    public MemberVo selectUUID(String uuid) throws Exception{
        String sql="select * from lunch_member where uuid=?";

        @Cleanup Connection connection = com.busanit501.demo.todo.dao.ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, uuid);

        @Cleanup ResultSet rs = pstmt.executeQuery();
        rs.next();

        MemberVo memberVo = MemberVo.builder()
                .mid(rs.getString("mid"))
                .mpw(rs.getString("mpw"))
                .mname(rs.getString("mname"))
                .uuid(rs.getString("uuid"))
                .build();

        return memberVo;
    }


    //회원가입
    public void insert(MemberVo memberVo) throws Exception{
        String sql="insert into lunch_member(mid, mpw, mname) values(?,?,?) ";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, memberVo.getMid());
        pstmt.setString(2, memberVo.getMpw());
        pstmt.setString(3, memberVo.getMname());
        pstmt.executeUpdate();
    }
}
