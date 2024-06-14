package com.busanit501.ngylunchproject.service;

import com.busanit501.ngylunchproject.dto.LunchDTO;
import com.busanit501.ngylunchproject.dto.LunchListReplyCountDTO;
import com.busanit501.ngylunchproject.dto.PageRequestDTO;
import com.busanit501.ngylunchproject.dto.PageResponseDTO;

public interface LunchService {
    Long register(LunchDTO lunchDTO);
    LunchDTO read(Long bno);
    void update(LunchDTO lunchDTO);
    void delete(Long bno);

    PageResponseDTO<LunchDTO> list(PageRequestDTO pageRequestDTO);

    PageResponseDTO<LunchListReplyCountDTO> listWithReplyCount(PageRequestDTO pageRequestDTO);
}
