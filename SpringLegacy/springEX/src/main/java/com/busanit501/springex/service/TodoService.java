package com.busanit501.springex.service;

import com.busanit501.springex.dto.TodoDTO;

import java.util.List;

public interface TodoService {
  void insert(TodoDTO todoDTO);
  List<TodoDTO> listAll();
}













