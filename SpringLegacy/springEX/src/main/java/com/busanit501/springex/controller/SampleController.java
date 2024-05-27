package com.busanit501.springex.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Log4j2
public class SampleController {

    //경로 주소 등록하기 > servlet-context.xml에 파일 등록.
    @GetMapping("/hello")
    public void helloTest() {
        log.info("hello 세상아!");
    }
}
