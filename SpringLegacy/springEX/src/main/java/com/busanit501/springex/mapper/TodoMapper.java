package com.busanit501.springex.mapper;

import com.busanit501.springex.domain.TodoVO;

import java.util.List;

public interface TodoMapper {
  // 여기 메서드와, TodoMapper.xml 파일(SQL 문장을 보관, id 이름과, 메서드 이름 동일)
  // 주의하기.
  String getTime();

  void insert(TodoVO todoVO);

  List<TodoVO> listAll();
}













