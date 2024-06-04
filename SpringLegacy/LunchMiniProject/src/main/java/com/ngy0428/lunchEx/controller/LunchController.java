package com.ngy0428.lunchEx.controller;


import com.ngy0428.lunchEx.dto.LunchDTO;
import com.ngy0428.lunchEx.dto.PageRequestDTO;
import com.ngy0428.lunchEx.dto.PageResponseDTO;
import com.ngy0428.lunchEx.service.LunchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.awt.print.Pageable;
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
  public  void listTest(Model model, PageRequestDTO pageRequestDTO) {
    log.info("lunch list 조회 화면 테스트 콘솔");
    // 서버 -> 화면, 모델
//    List<LunchDTO> dtoList = lunchService.listAll(pageRequestDTO);
//    model.addAttribute("dtoList", dtoList);
    PageResponseDTO<LunchDTO> pageResponseDTO = lunchService.listAll(pageRequestDTO);
    model.addAttribute("pageResponseDTO", pageResponseDTO);

//    파라미터로 받은 pageResponseDTO는 따로 모델에 안넣어도 화면 전달 가능함.
//    spring mvc에서 있는 자동 기능
  }

  @GetMapping({"/read", "/update"})
  public  void readTest(Long mno, PageRequestDTO pageRequestDTO, Model model) {
    log.info("Lunch list 조회 화면 테스트 콘솔");
    // C -> S -> Mapper -> DB
    // C <- S <- Mapper <- DB
    LunchDTO lunchDTO = lunchService.getOne(mno);
    // 서버 -> 화면, 모델
    model.addAttribute("lunchDTO", lunchDTO);

  }

  // 수정 관련 로직 처리  .
  @PostMapping("/update")
  public String updateTest(@Valid LunchDTO lunchDTO, BindingResult bindingResult, PageRequestDTO pageRequestDTO, RedirectAttributes redirectAttributes){
    log.info("수정시 mno 확인 : " + lunchDTO);

    int page = pageRequestDTO.getPage();
    int size = pageRequestDTO.getSize();

    // 유효성 검사 실패시에만 동작을함.
    if(bindingResult.hasErrors()) {
      log.info("현재: 수정중 오류 확인. bindingResult.hasErrors() 실행됨. ");
      redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors() );
      log.info("page : " + page + " size : " + size + " Mno : " + lunchDTO.getMno());
      // 서버 -> 화면으로 , 데이터 전달, 방식 :쿼리스트링 하는 방식.
      redirectAttributes.addAttribute("page",page );
      redirectAttributes.addAttribute("size",size );
      redirectAttributes.addAttribute("mno", lunchDTO.getMno());
      return "redirect:/lunch/update";
    }

    redirectAttributes.addAttribute("page",page );
    redirectAttributes.addAttribute("size",size );
    redirectAttributes.addAttribute("mno", lunchDTO.getMno());
    lunchService.update(lunchDTO);
    return "redirect:/lunch/list";

  }


  @PostMapping("/delete")
  public String deleteTest(Long mno, PageRequestDTO pageRequestDTO, RedirectAttributes redirectAttributes){
    log.info("삭제시 mno 확인 : " + mno);
    log.info("화면에서 전달된 검색 재료 getLink 확인 : " + pageRequestDTO.getLink());


//    현재는 link로 한번에 다 가져오기 때문에 필요없음
//    int page = pageRequestDTO.getPage();
//    int size = pageRequestDTO.getSize();

//    방법 1. 방식 : 직접 URL에 포함시켜 리다이렉트함.
//    return "redirect:/lunch/list?page="+page+"&size="+size;

//    방법 2. 서버 -> 화면으로 , 데이터 전달, 방식 :쿼리스트링 하는 방식.
//    redirectAttributes.addAttribute("page",page );
//    redirectAttributes.addAttribute("size",size );
//    return "redirect:/lunch/list";  쿼리스트링 형식이므로 뒤에 적을 필요 없음.

    lunchService.delete(mno);
    return "redirect:/lunch/list?"+pageRequestDTO.getLink();

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







