package com.ngy0428.lunchEx.mapper;

import com.ngy0428.lunchEx.domain.LunchVO;
import com.ngy0428.lunchEx.dto.PageRequestDTO;

import java.util.List;

public interface LunchMapper {
  // 여기 메서드와, TodoMapper.xml 파일(SQL 문장을 보관, id 이름과, 메서드 이름 동일)

  void insert(LunchVO lunchVO);

  List<LunchVO> listAll(PageRequestDTO pageRequestDTO); //페이징 정보를 리스트 볼때 보기.

  LunchVO getOne(Long mno);

  void delete(Long mno);

  void update(LunchVO lunchVO);

  //전체 개수 구하는 메서드, 페이징 처리시 필요한 준비물
  int getCount();

  int getCount2(PageRequestDTO pageRequestDTO);
}













