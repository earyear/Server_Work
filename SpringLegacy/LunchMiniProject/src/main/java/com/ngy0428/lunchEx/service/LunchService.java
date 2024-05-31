package com.ngy0428.lunchEx.service;

import com.ngy0428.lunchEx.dto.LunchDTO;

import java.util.List;

public interface LunchService {
  void insert(LunchDTO lunchDTO);
  // 맵퍼, listAll 반환 타입 : TodoVO
  // 서비스에서, TodoDTO 로 모두 변환하기.
  List<LunchDTO> listAll();
  LunchDTO getOne(Long mno);
  void delete(Long mno);
  void update(LunchDTO lunchDTO);

}













