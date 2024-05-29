package com.busanit501.samplejsp501.todo.domain;

import lombok.*;

import java.time.LocalDate;

//@Setter          //DTO가 setter로 담기 때문에 VO에서는 값만 가져오면 되기에 setter 필요없음!
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TodoVo {
    private Long tno;
    private String title;
    private LocalDate dueDate;
    private boolean finished;
}
