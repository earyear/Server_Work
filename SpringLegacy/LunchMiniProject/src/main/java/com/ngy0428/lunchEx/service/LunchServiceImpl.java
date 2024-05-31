package com.ngy0428.lunchEx.service;

import com.ngy0428.lunchEx.domain.LunchVO;
import com.ngy0428.lunchEx.dto.LunchDTO;
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
  public List<LunchDTO> listAll() {
    List<LunchVO> sampleLists = lunchMapper.listAll();
    // lunchVo -> lunchDTO
   List<LunchDTO> dtoLists = sampleLists.stream().map(vo -> modelMapper.map(vo, LunchDTO.class))
        .collect(Collectors.toList());
    return dtoLists;
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

}







