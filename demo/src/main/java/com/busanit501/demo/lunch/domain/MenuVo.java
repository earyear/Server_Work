package com.busanit501.demo.lunch.domain;

import lombok.*;

import java.time.LocalDate;

@Setter
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
