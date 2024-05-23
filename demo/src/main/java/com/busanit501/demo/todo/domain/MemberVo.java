package com.busanit501.demo.todo.domain;

import lombok.*;

@Builder
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class MemberVo {
    private String mid;
    private String mpw;
    private String mname;
    private String uuid;
}
