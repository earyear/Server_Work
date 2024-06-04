package com.ngy0428.lunchEx.service;

import com.ngy0428.lunchEx.domain.LunchVO;
import com.ngy0428.lunchEx.dto.LunchDTO;
import com.ngy0428.lunchEx.dto.PageRequestDTO;
import com.ngy0428.lunchEx.dto.PageResponseDTO;
import com.ngy0428.lunchEx.mapper.LunchMapper;
import lombok.extern.log4j.Log4j2;
import org.apache.ibatis.annotations.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
public class LunchServiceImpl implements LunchService {

  @Autowired
  private LunchMapper lunchMapper;

  @Autowired
  private ModelMapper modelMapper;

  @Override
  public void insert(LunchDTO lunchDTO) {

    LunchVO lunchVO = modelMapper.map(lunchDTO, LunchVO.class);
    lunchMapper.insert(lunchVO);
  }

  @Override
//  public List<LunchDTO> listAll(PageRequestDTO pageRequestDTO)
  public PageResponseDTO<LunchDTO> listAll(PageRequestDTO pageRequestDTO) {
    List<LunchVO> sampleLists = lunchMapper.listAll(pageRequestDTO);
    // lunchVo -> lunchDTO
    List<LunchDTO> dtoLists = sampleLists.stream().map(vo -> modelMapper.map(vo, LunchDTO.class))
        .collect(Collectors.toList());
    // 두번째 자료, PageRequestDTO, 파라미터꺼 사용. 1차 문제점.
    // 검색 결과에 대한 , page, size , 사용해야 하는데, 요청시 받은 정보를 계속 사용한 점.

    // 세번째 전체 갯수. 2차 문제, 무조건 전체 갯수를 리턴.
    // 해결 : 만들어 두었던, 검색 결과 적용도 되고, 적용 안해도 가능한 메서드 이용.
    int total = lunchMapper.getCount2(pageRequestDTO);

    log.info("=========================현재: LunchServiceImpl, pageRequestDTO getPage: 값 확인 :" + pageRequestDTO.getPage());

    // PageResponseDTO.<TodoDTO>withAll().build();
    PageResponseDTO<LunchDTO> pageResponseDTO = PageResponseDTO.<LunchDTO>withAll()
            .pageRequestDTO(pageRequestDTO)
            .dtoList(dtoLists)
            .total(total)
            .build();

    log.info("=========================현재: LunchServiceImpl, pageResponseDTO getPage : 값 확인 :" + pageResponseDTO.getPage());

    return pageResponseDTO;
  }

  @Override
  public LunchDTO getOne(Long mno) {
    LunchVO lunchVO = lunchMapper.getOne(mno);
    LunchDTO lunchDTO = modelMapper.map(lunchVO, LunchDTO.class);
    return lunchDTO;
  }

  @Override
  public void delete(Long mno) {
    lunchMapper.delete(mno);
  }

  @Override
  public void update(LunchDTO lunchDTO) {
    LunchVO lunchVO = modelMapper.map(lunchDTO, LunchVO.class);
    lunchMapper.update(lunchVO);
  }

  @Override
  public int getCount() {
    int result = lunchMapper.getCount();
    return result;
  }

  @Override
  public int getCount2(PageRequestDTO pageRequestDTO) {
    int result = lunchMapper.getCount2(pageRequestDTO);
    return result;
  }
}







