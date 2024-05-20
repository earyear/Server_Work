package com.busanit501.demo.todo.service;

import com.busanit501.demo.todo.dao.TodoDAO;
import com.busanit501.demo.todo.domain.TodoVo;
import com.busanit501.demo.todo.dto.TodoDTO;
import com.busanit501.demo.todo.util.MapperUtil;
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
//        TodoVo todoVo = TodoVo.builder()
//                .title("test")
//                .dueDate(LocalDate.now())
//                .finished(false)
//                        .build();
        //System.out.println("값 확인 : "+todoVo);
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








    public void register(TodoDTO dto){
        System.out.println("debug register dto 확인중 :" + dto);
    }

    //임시 리스트 출력하는 기능
    public List<TodoDTO> getList(){
        //샘플 더미 데이터 생성
        List<TodoDTO> listSample = IntStream.range(0,10).mapToObj(i -> {
                    TodoDTO dto = new TodoDTO();
                    dto.setTno((long) i);
                    dto.setTitle("Sample Todo Title " + i);
                    dto.setDueDate(LocalDate.now());
                    return dto;
                }).collect(Collectors.toList());
        return listSample;
    }

}
