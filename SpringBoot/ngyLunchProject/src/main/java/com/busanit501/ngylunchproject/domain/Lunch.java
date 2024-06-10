package com.busanit501.ngylunchproject.domain;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity

public class Lunch extends BaseEntity{
    // pk, = not null, primary key
    @Id
    // pk 숫자를 자동 증가를 어떤 방식으로 하겠니? 해당 마리아 디비에서 사용하는 증가 번호 정책을 이용하겠습니다.
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long bno;

    @Column(length = 500,nullable = false)
    private String title;

    @Column(length = 2000, nullable = false)
    private String content;

    @Column(length = 50, nullable = false)
    private String writer;
    // 등록시간,
    // 수정시간, 많은 테이블에서 공통적으로 사용하니, 인터페이스로 분리해서 재사용할 예정.

    public void changeTitleAndContent(String title, String content, String writer) {
        this.title = title;
        this.content = content;
        this.writer = writer;
    }
}
