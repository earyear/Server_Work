package com.ngy0428.lunchEx.controller;


import com.ngy0428.lunchEx.dto.LunchDTO;
import com.ngy0428.lunchEx.service.LunchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

// 데이터만 전달. API 서버, API REST 서버,
//@RestController
// 화면 + 데이터 전달.
@Controller
// 화면상에서 접근하는 URL 주소를 맵핑 해주는 역할.
// 설정은 , 클래스 앞에도 가능하고, 메서드 앞에도 가능함.
@RequestMapping("/lunch")
@Log4j2
@RequiredArgsConstructor
public class LunchController {

  final LunchService lunchService;

  @GetMapping("/list")
  public  void listTest(Model model) {
        log.info("lunch list 조회 화면 테스트 콘솔");
        List<LunchDTO> dtoList = lunchService.listAll();
        // 서버 -> 화면, 모델
    model.addAttribute("dtoList", dtoList);

  }

  @GetMapping({"/read", "/update"})
  public  void readTest(Long mno, Model model) {
    log.info("Lunch list 조회 화면 테스트 콘솔");
    // C -> S -> Mapper -> DB
    // C <- S <- Mapper <- DB
    LunchDTO lunchDTO = lunchService.getOne(mno);
    // 서버 -> 화면, 모델
    model.addAttribute("lunchDTO", lunchDTO);

  }

  // 수정 관련 로직 처리  .
  @PostMapping("/update")
  public String updateTest(LunchDTO lunchDTO, RedirectAttributes redirectAttributes){
    log.info("수정시 mno 확인 : " + lunchDTO);
    lunchService.update(lunchDTO);
    return "redirect:/lunch/list";

  }


  @PostMapping("/delete")
  public String deleteTest(Long mno, RedirectAttributes redirectAttributes){
    log.info("삭제시 mno 확인 : " + mno);
    lunchService.delete(mno);
    return "redirect:/lunch/list";

  }


//  @RequestMapping(value = "/register", method = RequestMethod.GET)
  @GetMapping("/register")
  public void registerGetTest() {
    log.info("lunch register 등록 화면 Get  테스트 콘솔");
  }

  @PostMapping("/register")
  //@Valid : 유효성 체크 하겠다 의미.
  // BindingResult : 유효성 검사 실패시, 실패 관련 내용이 자동으로 담기는 도구
  // RedirectAttributes , 서버 -> 화면으로 , 쿼리 스트링으로 내용 전달.
  public String registerPostTest(@Valid LunchDTO lunchDTO, BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes) {
//    log.info("lunch register 등록 화면 Post 테스트 콘솔");
//    log.info(" lunchDTO lunchDTO 타입 원래 register 확인.  : " + lunchDTO );
    log.info("post 작업 중. ");

    // 유효성 검사 실패시에만 동작을함.
    if(bindingResult.hasErrors()) {
      log.info("bindingResult.hasErrors() 실행됨. ");
      redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors() );
      return "redirect:/lunch/register";
    }
    lunchService.insert(lunchDTO);
    return "redirect:/lunch/list";

  }


}







