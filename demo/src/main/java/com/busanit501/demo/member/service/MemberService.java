package com.busanit501.demo.member.service;

import com.busanit501.demo.member.dto.MemberDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//enum 열거형 상수
public enum MemberService {
    INSTANCE;

    public void register(MemberDTO dto){
        System.out.println("debug register menu dto 확인중 :" + dto);
    }

    //임시 리스트 출력하는 기능
    public List<MemberDTO> getList(){
        //샘플 더미 데이터 생성
        List<MemberDTO> listSample = IntStream.range(0,10).mapToObj(i -> {
                    MemberDTO dto = new MemberDTO();
                    dto.setNo((long) i);
                    dto.setName("Sample 회원 이름 " + i);
                    dto.setDueDate(LocalDate.now());
                    return dto;
                }).collect(Collectors.toList());
        return listSample;
    }
}
