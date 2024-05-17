package com.busanit501.demo.todo.domain;

import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@Builder
@ToString
@NoArgsConstructor
//@RequiredArgsConstructor
@AllArgsConstructor


public class TodoVo {
    private long tno;
    private String title;
    private LocalDate dueDate;
    private boolean finished;
}
