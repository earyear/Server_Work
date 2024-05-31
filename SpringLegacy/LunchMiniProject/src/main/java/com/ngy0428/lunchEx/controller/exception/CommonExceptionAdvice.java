package com.ngy0428.lunchEx.controller.exception;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.Arrays;

@ControllerAdvice
@Log4j2
public class CommonExceptionAdvice {

  // REST API , RestController, 화면없이 데이터만 전달시
  // ResponseBody, http 전달시, 헤더와 바디(데이터)
  // 결론, 데이터만 전달 하기.
//  @ResponseBody
//  // 예외가 발생했을 경우 처리할 클래스를 지금은 구체적으로 작성하지만,
//  // 일반적으로, 상위 개념인 Exception으로 처리할 예정.
//  @ExceptionHandler(NumberFormatException.class)
//  public String exceptNumberFormat(NumberFormatException numberFormatException) {
//
//    log.error("----------error----------------");
//    log.error("numberFormatException.getMessage() : " + numberFormatException.getMessage());
//    return "Number Format Exception !!!";
//
//  }

  // 좀더 포괄적으로 예외를 처리 해보자.
  @ResponseBody
  @ExceptionHandler(Exception.class)
  // 예외가 발생한 모든 정보를,   exception 인스턴스에 담아 둠.
  public String commonException(Exception exception) {

    // 자바에서 단순 String 이용시, 메모리 낭비가 심하다.
    // StringBuffer, StringBuilder를 이용하면, 효율적인 메모리 관리가 된다.
    StringBuffer buffer = new StringBuffer("<ul>");

    buffer.append("<li>"+ exception.getMessage() + "</li>");
    // 예외가 발생하는 목록들을 반복문으로 추가하는 로직.
    Arrays.stream(exception.getStackTrace()).forEach(elem ->
    buffer.append("<li>"+ elem + "</li>"));
    // 닫는 태그.
    buffer.append("</ul>");

    return buffer.toString();

  }

  //예제, 404 Not Found 발생시 , 유저에게 화면 보여주기.
  @ExceptionHandler(NoHandlerFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public String notFound() {
    // 404 페이지로 전달.
    // custom404.jsp 만들예정.
    return "custom404";
  }

}







