package com.ngy0428.lunchEx.service;

import com.ngy0428.lunchEx.dto.LunchDTO;
import com.ngy0428.lunchEx.dto.PageRequestDTO;
import com.ngy0428.lunchEx.dto.PageResponseDTO;

import java.util.List;

public interface LunchService {
  void insert(LunchDTO lunchDTO);
  // 맵퍼, listAll 반환 타입 : LunchVO
  // 서비스에서, LunchDTO로 모두 변환하기.
//  List<LunchDTO> listAll(PageRequestDTO pageRequestDTO);
  PageResponseDTO<LunchDTO> listAll(PageRequestDTO pageRequestDTO);
  LunchDTO getOne(Long mno);
  void delete(Long mno);
  void update(LunchDTO lunchDTO);
  int getCount();
  int getCount2(PageRequestDTO pageRequestDTO);
}













