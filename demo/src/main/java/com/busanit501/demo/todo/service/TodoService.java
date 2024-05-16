package com.busanit501.demo.todo.service;

import com.busanit501.demo.todo.dto.TodoDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//todo, 작성
//enum 열거형 상수
public enum TodoService {
    INSTANCE;

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
