package com.ngy0428.lunchEx.sample;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@ToString
@RequiredArgsConstructor
@Service
public class SampleService {

  // 생성자를 이용한 주입 방식.
  // 오류코드를 확인 하기가 좀더 편함.
  @Autowired
  @Qualifier("event")
  private SampleDAO sampleDAO;

  // 주입 받는데, final 설정 하는 방식.
  // @RequiredArgsConstructor, 세트로 같이 설정해야 함.
  // 학습용.

//  private final SampleDAO sampleDAO;

  // 결론, 2가지다, 주입하는 방법론.

}







