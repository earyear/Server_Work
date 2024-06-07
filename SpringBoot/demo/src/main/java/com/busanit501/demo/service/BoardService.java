package com.busanit501.demo.service;

import com.busanit501.demo.dto.BoardDTO;

public interface BoardService {
  Long register(BoardDTO boardDTO);
  BoardDTO read(Long bno);
  void update(BoardDTO boardDTO);
  void delete(Long bno);
}







