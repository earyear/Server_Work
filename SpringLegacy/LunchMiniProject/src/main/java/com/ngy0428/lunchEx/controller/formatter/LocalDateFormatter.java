package com.ngy0428.lunchEx.controller.formatter;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class LocalDateFormatter implements Formatter<LocalDate> {
  // 클라이언트로 부터 전달 받은 날짜 형식 문자열을, "yyyy-MM-dd"
  // LocalDate 타입으로 변환 해주기.
  @Override
  public LocalDate parse(String text, Locale locale) throws ParseException {
    return LocalDate.parse(text, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
  }

  // LocalDate -> 문자열 타입으로 변환 해주기.
  @Override
  public String print(LocalDate object, Locale locale) {
    return DateTimeFormatter.ofPattern("yyyy-MM-dd").format(object);
  }
}







