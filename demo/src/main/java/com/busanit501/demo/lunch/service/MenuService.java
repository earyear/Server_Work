package com.busanit501.demo.lunch.service;

import com.busanit501.demo.lunch.dto.MenuDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//enum 열거형 상수
public enum MenuService {
    INSTANCE;

    public void register(MenuDTO dto){
        System.out.println("debug register menu dto 확인중 :" + dto);
    }

    //임시 리스트 출력하는 기능
    public List<MenuDTO> getList(){
        //샘플 더미 데이터 생성
        List<MenuDTO> listSample = IntStream.range(0,10).mapToObj(i -> {
                    MenuDTO dto = new MenuDTO();
                    dto.setNo((long) i);
                    dto.setName("Sample 메뉴 이름 " + i);
                    dto.setDueDate(LocalDate.now());
                    return dto;
                }).collect(Collectors.toList());
        return listSample;
    }
}
