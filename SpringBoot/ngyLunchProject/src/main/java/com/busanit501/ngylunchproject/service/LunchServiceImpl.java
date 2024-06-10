package com.busanit501.ngylunchproject.service;


import com.busanit501.ngylunchproject.dto.LunchDTO;
import com.busanit501.ngylunchproject.domain.Lunch;
import com.busanit501.ngylunchproject.dto.PageRequestDTO;
import com.busanit501.ngylunchproject.dto.PageResponseDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.busanit501.ngylunchproject.repository.LunchRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
// all or nothing, 전부 혹은 아무것도 못함.
@Transactional
public class LunchServiceImpl implements LunchService {

  // 의존성 주입
  private final LunchRepository lunchRepository;
  private final ModelMapper modelMapper;

  @Override
  public Long register(LunchDTO lunchDTO) {
    // 화면에서 작성한 게시글 내용이 DTO 있고, -> VO 대신 entity 클래스 이용중.
    Lunch lunch = modelMapper.map(lunchDTO, Lunch.class);
    Long bno = lunchRepository.save(lunch).getBno();
    return bno;
  }

  @Override
  public LunchDTO read(Long bno) {
    // 1차 영속성 컨텍스트에서 조회한 내용을 가져오기.
    Optional<Lunch> result = lunchRepository.findById(bno);
    // 만약 있다면, 엔티티 타입으로 담기.(VO 같은 개념) //만약 있다면, 엔티티 타입으로 담기(VO)
    Lunch lunch = result.orElseThrow();
    // 엔티티 -> DTO 변환.  //엔티티 > DTO
    LunchDTO lunchDTO = modelMapper.map(lunch, LunchDTO.class);

    return lunchDTO;
  }


  @Override
  public void update(LunchDTO lunchDTO) {
    Optional<Lunch> result= lunchRepository.findById(lunchDTO.getBno());
    Lunch lunch = result.orElseThrow();
    //변경한다면. 제목, 내용, 작성자 변경
    lunch.changeTitleAndContent(lunchDTO.getTitle(), lunchDTO.getContent(), lunchDTO.getWriter());
    lunchRepository.save(lunch);
  }

  //REST방식일 때는 유효성 체크해서 없다는 메세지 전달해야함.
  @Override
  public void delete(Long bno) {
    lunchRepository.deleteById(bno);
  }

  @Override
  public PageResponseDTO<LunchDTO> list(PageRequestDTO pageRequestDTO) {
    String[] types = pageRequestDTO.getTypes();
    String keyword = pageRequestDTO.getKeyword();
    Pageable pageable = pageRequestDTO.getPageable("bno");

    //vo
    Page<Lunch> result = lunchRepository.searchAll(types,keyword,pageable);

    //Entity(vo) > DTO
    List<LunchDTO> dtoList = result.getContent().stream()
            .map(lunch -> modelMapper.map(lunch,LunchDTO.class))
            .collect(Collectors.toList());

    //화면에 전달할 준비물 작업 완료, 1.페이지,사이즈(requestDTO) 2.검색 필터된 리스트 3.전체개수
    PageResponseDTO pageResponseDTO = PageResponseDTO.<LunchDTO>withAll()
            .pageRequestDTO(pageRequestDTO)
            .dtoList(dtoList)
            .total((int) result.getTotalElements())
            .build();

    return pageResponseDTO;
  }


}







