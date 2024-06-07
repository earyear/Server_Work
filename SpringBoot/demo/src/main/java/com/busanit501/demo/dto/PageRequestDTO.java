package com.busanit501.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageRequestDTO {
    @Builder.Default
    private int page = 1;

    @Builder.Default
    private int size = 10;

    // 제목, 내용, 작성자
    // 검색 종류 , t, c, w, tc,tw, twc
    private String type;

    private String keyword;

}
