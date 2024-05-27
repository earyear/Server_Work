package com.busanit501.demo.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/lunchMenu") //화면상에서 접근하는 URL주소 맵핑해주는 역할 (클래스 앞 O, 메서드 앞 O)
@Log4j2
public class lunchMenuController {
    @RequestMapping("/list")
    public void list(){
        log.info("list 화면 테스트 콘솔");
    }

    @GetMapping("/register")
//    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public void register(){
        log.info("register 등록 화면");
    }

    @PostMapping("/register")
    public void registerPost(){ log.info("post 테스트콘솔");}
}
