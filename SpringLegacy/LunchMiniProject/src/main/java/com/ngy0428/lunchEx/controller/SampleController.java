package com.ngy0428.lunchEx.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Log4j2
public class SampleController {

  // 방금 만든 컨트롤러 패키지 경로 주소를 등록하러가기.
  // servlet-context.xml 파일에 등록. 초기 설정.

  @GetMapping("/hello")
  public void helloTest() {
    // 테스트 : 웹브라우저,
    // http://localhost:8080/hello
    // 아직 화면 연결은 안했음.
    // 콘솔에서 로그 확인.

    log.info("Hello World! Spring");
  }
}







