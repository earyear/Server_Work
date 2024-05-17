package com.busanit501.demo.todo.dao;

import com.busanit501.demo.todo.domain.TodoVo;
import lombok.Cleanup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

public class TodoDAO {

    //자동 반납
    public String getTime2() throws Exception{

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = connection.prepareStatement("select now()");
        @Cleanup ResultSet rs = pstmt.executeQuery();
        rs.next();
        String now = rs.getString(1);
        return now;
    }

    //디비에 직접적인 비즈니스 로직 처리하는 기능 만듬
    public String getTime(){
        //HikariCP 이용해, 디비 연결하는 도구
//        Connection conn = ConnectionUtil.INSTANCE.getConnection();
        //예외처리 3가지 방식 1)try catch finally 2)throws 3)resource

        String now = null;
        try(Connection connection = ConnectionUtil.INSTANCE.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("select now()"); //sql 전달 도구
            ResultSet rs = pstmt.executeQuery(); //한 행만 불러옴
            ){
            rs.next(); //while문 안하는 이유 : 지금은 한 행밖에 없어서^^
            now = rs.getString(1);
        }catch (Exception e){
            e.printStackTrace();
        } //finally 구문으로 close해야하지만, try resource가 자동으로 close해줌.
        return now;   //디비접근 시,
    }

    //List 사용해서 select 전체 가져오기
    public List<TodoVo> selectAll() throws Exception{
        String sql="select * from tbl_todo";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = connection.prepareStatement(sql);
        @Cleanup ResultSet rs = pstmt.executeQuery();

        List<TodoVo> list = new ArrayList<>();

        while (rs.next()){
            //방법 1. TodoVo 객체 생성해서 넣기
//            TodoVo vo = new TodoVo();
//            vo.setTno(rs.getLong("tno"));
//            vo.setTitle(rs.getString("title"));
//            vo.setDueDate(rs.getDate("dueDate").toLocalDate());
//            vo.setFinished(rs.getBoolean("finished"));

            //방법 2. 빌더 사용하기
            TodoVo todoVoBuilder = TodoVo.builder()
                    .tno(rs.getLong("tno"))
                    .title(rs.getString("title"))
                    .dueDate(rs.getDate("dueDate").toLocalDate())
                    .finished(rs.getBoolean("finished"))
                    .build();

            list.add(todoVoBuilder);
        }

        return list;
    }

    //특정행만 가져오기
    public TodoVo selectONE(Long tno) throws Exception{
        String sql="select * from tbl_todo where tno=?";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setLong(1, tno);
        @Cleanup ResultSet rs = pstmt.executeQuery();
        rs.next(); //select 한놈이라서 while문 필요없음

        TodoVo todoVo = TodoVo.builder()
                .tno(rs.getLong("tno"))
                .title(rs.getString("title"))
                .dueDate(rs.getDate("dueDate").toLocalDate())
                .finished(rs.getBoolean("finished"))
                .build();

        return todoVo;
    }

    //혼자한거(gpt) 한개만 가져옴
    public String selectOne(){

        StringBuilder now = new StringBuilder();

        try(Connection connection = ConnectionUtil.INSTANCE.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("select * from tbl_todo where tno =1"); //sql 전달 도구
            ResultSet rs = pstmt.executeQuery()
        ){
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();

//            //열이름(이뻐보이기 위함)
//            for(int i = 1; i <= columnCount; i++){
//                now.append(rsmd.getColumnName(i)).append(",");
//            }
//            now.append("\n");

            while (rs.next()){
                for(int i = 1; i <= columnCount; i++){
                    now.append(rs.getString(i)).append(",");
                }
                now.append("\n");
            }

        }catch (Exception e){
            e.printStackTrace();
        } //finally 구문으로 close해야하지만, try resource가 자동으로 close해줌.
        return now.toString();   //디비접근 시,
    }


    //전체 select
    public String selectTable(){

        StringBuilder select = new StringBuilder();
        try(Connection connection = ConnectionUtil.INSTANCE.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("select * from tbl_todo"); //sql 전달 도구
            ResultSet rs = pstmt.executeQuery(); //한 행만 불러옴
        ){
            while(rs.next()){
                select.append(rs.getString(1)).append('\n');
            }

        }catch (Exception e){
            e.printStackTrace();
        } //finally 구문으로 close해야하지만, try resource가 자동으로 close해줌.
        return select.toString();   //디비접근 시,
    }
}
