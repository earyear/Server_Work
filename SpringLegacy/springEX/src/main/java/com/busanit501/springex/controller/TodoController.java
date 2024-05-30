package com.busanit501.springex.controller;

import com.busanit501.springex.dto.TodoDTO;
import com.busanit501.springex.service.TodoService;
import lombok.Builder;
import org.springframework.validation.BindingResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/todo") //화면상에서 접근하는 URL주소 맵핑해주는 역할 (클래스 앞 O, 메서드 앞 O)
@Log4j2
@RequiredArgsConstructor  //lombok 이용해서 주입하기.
public class TodoController {

    final TodoService todoService;


    @GetMapping ("/list")
    public void list(Model model){
        log.info("todo list 조회 화면 테스트 콘솔");
        List<TodoDTO> dtoList = todoService.listAll();
        // 서버 -> 화면, 모델
        model.addAttribute("dtoList", dtoList);
    }

    @GetMapping(value = "/register")
    public String register(@Valid TodoDTO todoDTO, BindingResult bindingResult,
                           RedirectAttributes redirectAttributes){
        log.info("register 등록 화면 : ");

        // 유효성 검사 실패시에만 동작을함.
        if(bindingResult.hasErrors()) {
            log.info("bindingResult.hasErrors() 실행됨. ");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors() );
            return "redirect:/todo/register";
        }
        todoService.insert(todoDTO);
        return "redirect:/todo/list";
    }

    @GetMapping("/ex1") //입력 : ex1?name="lsy"&age=20
    public void ex1T(String name, int age){
        log.info("name : "+name+" age : "+age);
    }

    @GetMapping("/ex2") //입력 : ex2?age=20
    public void ex2T(@RequestParam(name ="name", defaultValue = "default lsy")String name, int age){
        log.info("name(이름 안넣기) : "+name+" age : "+age);
    }

    @GetMapping("/ex3")  //ex3?dueDate=2024-05-27
    public void ex3T(LocalDate dueDate){
        log.info("localdate타입 현재 날짜 : "+dueDate);
    }

    @PostMapping("/ex4")
    public void ex4T(TodoDTO todoDTO ){
        log.info("todoDTO의 값 : "+todoDTO);
    }

    @GetMapping("/ex5")
    public void ex5T(Model model){
        TodoDTO todoDTO = TodoDTO.builder()
                .tno(100L)
                .title("메뉴1")
                .writer("이상용")
                .dueDate(LocalDate.now())
                .finished(true)
                .build();
        model.addAttribute("menu", "잡채밥" );
        log.info("모델 타입으로 전달 : "+todoDTO);
    }

    @PostMapping("/ex6")
    public void ex6Test(@ModelAttribute("dto") TodoDTO todoDTO, Model model) {
        log.info("ex6 test...");
//    TodoDTO todoDTO = TodoDTO.builder()
//        .tno(100L)
//        .title("메뉴1")
//        .writer("이상용")
//        .dueDate(LocalDate.now())
//        .finished(true)
//        .build();
        model.addAttribute("menu","잡채밥");
        model.addAttribute("todoDTO",todoDTO);
    }

    @GetMapping("/ex7")
    public String ex7Test(RedirectAttributes redirectAttributes) {
        log.info("ex7 test...");

        redirectAttributes.addAttribute("menu","내일 점심은 칼국수");
        redirectAttributes.addAttribute("menu2","tomorrow lunch menu is noodle!");

        //일회용
        redirectAttributes.addFlashAttribute("result","라면");

        return "redirect:/todo/ex8";
    }

    @GetMapping("/ex8")
    public void ex8Test(Model model) {
        log.info("ex8 test...");
    }

    @GetMapping("/ex9")
    public void ex9Test(String name, int age) {
        log.info("ex9 test...");
        //강제로 예외 발생시킬 예정 > 숫자타입에 문자열 입력하여 강제 예외발생함.
        log.info("name : "+name+" age : "+age);
    }
}
