package com.busanit501.springex.service;

import com.busanit501.springex.domain.TodoVO;
import com.busanit501.springex.dto.TodoDTO;
import com.busanit501.springex.mapper.TodoMapper;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
public class TodoServiceImpl implements TodoService {

  @Autowired
  private TodoMapper todoMapper;

  @Autowired
  private ModelMapper modelMapper;

  @Override
  public void insert(TodoDTO todoDTO) {

    TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);
    todoMapper.insert(todoVO);
  }

  @Override
  public List<TodoDTO> listAll() {
    List<TodoVO> sampleLists = todoMapper.listAll();
    // TodoVo -> TodoDTO
    List<TodoDTO> dtoLists = sampleLists.stream().map(vo -> modelMapper.map(vo, TodoDTO.class))
            .collect(Collectors.toList());
    return dtoLists;
  }

}







