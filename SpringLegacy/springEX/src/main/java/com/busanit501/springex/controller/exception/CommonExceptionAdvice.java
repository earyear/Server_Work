package com.busanit501.springex.controller.exception;

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
    //REST API, RestController, 화면없이 데이터만 전달시 유용함.
    //결론, 데이터만 전달하기...
//    @ResponseBody
//    @ExceptionHandler(NumberFormatException.class) //숫자관련 에러
//    public String exceptNumberFormat(NumberFormatException e) {
//        log.error("-----error-----");
//        log.error(e.getMessage());
//        return "it's error! change your value!!";
//    }

    @ResponseBody
    @ExceptionHandler(Exception.class) //포괄적으로 에러처리
    public String commonException(Exception e) {
        StringBuffer buffer = new StringBuffer("<ul>");
        buffer.append("<li>").append(e.getMessage()).append("</li>");

        Arrays.stream(e.getStackTrace()).forEach(element ->
                buffer.append("<li>").append(element.toString()).append("</li>")
        );  //키와 값인 형태로 저장됨.
        buffer.append("</ul>");

        log.error("-----error-----");

        return buffer.toString();
    }

    //예제, 404 NOT FOUND 발생시, 유저에게 화면 보여주기
    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String notFound(){
        return "custom 404 not found";
    }
}
