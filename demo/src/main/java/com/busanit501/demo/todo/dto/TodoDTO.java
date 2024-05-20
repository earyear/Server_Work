package com.busanit501.demo.todo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Builder
// set/get/toString/equals/hashCode 등 다 포함됨.
@Data
// 인자값이 없는 생성자, 기본생성자
@NoArgsConstructor
// 모든 인자값을 가지는 생성자.
@AllArgsConstructor
public class TodoDTO {
    // 인스턴스 멤버.
    private Long tno;
    private String title;
    private LocalDate dueDate;
    private boolean finished;


}







