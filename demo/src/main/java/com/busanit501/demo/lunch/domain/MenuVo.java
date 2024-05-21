package com.busanit501.demo.lunch.domain;

import lombok.*;

import java.time.LocalDate;

//@Setter  DTO에서 이미 setter했기에 필요없음.
@Getter
@Builder
@ToString
@NoArgsConstructor
//@RequiredArgsConstructor
@AllArgsConstructor


public class MenuVo {
    private long no;
    private String name;
    private LocalDate dueDate;
}
