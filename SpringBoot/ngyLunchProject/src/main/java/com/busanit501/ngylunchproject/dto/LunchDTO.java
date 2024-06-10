package com.busanit501.ngylunchproject.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

//서버 유효성 체크
public class LunchDTO {
  private Long bno;

  @NotEmpty
  @Size(min = 2, max = 100)
  private String title;

  @NotEmpty
  private String content;

  private String writer;
  private LocalDateTime regDate;
  private LocalDateTime modDate;

}







