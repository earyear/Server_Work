package com.busanit501.ngylunchproject.service;

import com.busanit501.ngylunchproject.dto.PageRequestDTO;
import com.busanit501.ngylunchproject.dto.PageResponseDTO;
import com.busanit501.ngylunchproject.dto.ReplyDTO;

public interface ReplyService {
    // 댓글 , crud
    Long register(ReplyDTO replyDTO);
    ReplyDTO read(Long rno);
    void update(ReplyDTO replyDTO);
    void delete(Long rno);
    // 댓글 페이징 처리해서 목록 출력.
    PageResponseDTO<ReplyDTO> getListOfLunch(Long bno, PageRequestDTO pageRequestDTO);
}
