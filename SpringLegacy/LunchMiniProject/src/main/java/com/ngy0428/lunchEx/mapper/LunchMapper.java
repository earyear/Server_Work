package com.ngy0428.lunchEx.mapper;

import com.ngy0428.lunchEx.domain.LunchVO;

import java.util.List;

public interface LunchMapper {
  // 여기 메서드와, TodoMapper.xml 파일(SQL 문장을 보관, id 이름과, 메서드 이름 동일)
  // 주의하기.
//  String getTime();

  void insert(LunchVO lunchVO);

  List<LunchVO> listAll();

  LunchVO getOne(Long mno);

  void delete(Long mno);

  void update(LunchVO lunchVO);
}













