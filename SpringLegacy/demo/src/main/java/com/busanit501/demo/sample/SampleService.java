package com.busanit501.demo.sample;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@ToString
public class SampleService {

    //1) 생성자를 이용한 주입 방식
    @Autowired
    @Qualifier("event") //학습용
    private SampleDAO sampleDAO;

    //2) 필드 주입
    //@RequiredArgsConstructor와 세트로 설정해야 함. 오류코드를 확인하기 편함.
//    private final SampleDAO sampleDAO;
}
