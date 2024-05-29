package com.busanit501.samplejsp501.todo.service;

import com.busanit501.samplejsp501.todo.dao.TodoDAO;
import com.busanit501.samplejsp501.todo.domain.TodoVo;
import com.busanit501.samplejsp501.todo.dto.TodoDTO;
import com.busanit501.samplejsp501.todo.util.MapperUtil;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Log4j2
//todo, 작성
//enum 열거형 상수
public enum TodoService {
    INSTANCE;

    private TodoDAO todoDAO;
    private ModelMapper modelMapper;

    //생성자
    TodoService() {
        todoDAO = new TodoDAO();
        modelMapper = MapperUtil.INSTANCE.getModelMapper();          //기본 생성자 호출 후 할당하기.
    }

    //기능
    // 모델 타입은 TodoDTO을 받아서 > 작업을 위해 VO로 변환
    // insert
    public void register2(TodoDTO todoDTO) throws Exception{
        TodoVo todoVo = modelMapper.map(todoDTO, TodoVo.class);
        log.info("Register todo: " + todoVo);

        todoDAO.insert(todoVo);
    }

    //전체 조회
    public List<TodoDTO> listAll() throws Exception{
        List<TodoVo> VOList = todoDAO.selectAll();   //DB > DAO > VO > DTO
        log.info("TodoVo의 리스트확인 : " + VOList);
        List<TodoDTO> DTOList = VOList.stream()
                .map(todoVo -> modelMapper.map(todoVo, TodoDTO.class))
                .collect(Collectors.toList());

        return DTOList;
    }

    //한개 조회
    public TodoDTO selectone(Long tno) throws Exception{
        TodoVo vo = todoDAO.selectONE(tno);
        TodoDTO dto = modelMapper.map(vo, TodoDTO.class);
        return dto;
    }

    //수정
    public void update(TodoDTO todoDTO) throws Exception{
        TodoVo vo = modelMapper.map(todoDTO, TodoVo.class);
        todoDAO.update(vo);  //실제에도 적용.
    }

    //삭제
    public void delete(Long tno) throws Exception{
        todoDAO.delete(tno);
    }

}
