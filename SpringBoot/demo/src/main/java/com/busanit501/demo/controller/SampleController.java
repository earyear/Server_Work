package com.busanit501.demo.controller;

import com.busanit501.demo.dto.SampleDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//데이터 +화면 전달
@Controller
@Log4j2
public class SampleController {

    @GetMapping("/hello")
    public void hello(Model model) {
        log.info("hello!!! 안녕!");
        model.addAttribute("msg","Hello 안녕하십니까:)");
    }

    @GetMapping("/hello2")
    public void hello2(Model model) {
        log.info("hello!!! 안녕!");
        model.addAttribute("msg","Hello 안녕하십니꽈아아아:)");
    }

    //타임리프 연습
    @GetMapping("/ex/ex1")
    public void ex1(Model model) {
        log.info("연습!");
        List<String> list = Arrays.asList("씁","혈당스파이크","쉽지않네");
        model.addAttribute("list",list);
    }

    @GetMapping("/ex/ex2")
    public void ex2(Model model) {
        log.info("연습함다!");
        List<String> list = Arrays.asList("씁","혈당스파이크","쉽지않네");

        List<String> list2 = IntStream.range(1,10).mapToObj(i->"간식"+i)
                        .collect(Collectors.toList());

        model.addAttribute("list",list);
        model.addAttribute("list2",list2);

        Map<String, String> map =new HashMap<>();
        map.put("menu1","치킨");
        map.put("menu2","피자");

        model.addAttribute("map",map);

        SampleDTO sampleDTO = SampleDTO.builder()
                .name("이상용")
                .age("30")
                .build();

        model.addAttribute("dto",sampleDTO);

    }

    //타임리프 연습해보기.
    @GetMapping("/ex/ex3")
    public void ex3(Model model) {
        log.info("/ex/ex3~~~~~~~~~~~");
        List<String> list = Arrays.asList("도시락","라면","김밥","볶음밥");
        model.addAttribute("list",list);
    }
}
