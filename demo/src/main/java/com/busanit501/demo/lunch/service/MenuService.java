package com.busanit501.demo.lunch.service;

import com.busanit501.demo.lunch.dao.MenuDAO;
import com.busanit501.demo.lunch.domain.MenuVo;
import com.busanit501.demo.lunch.dto.MenuDTO;
import com.busanit501.demo.todo.util.MapperUtil;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Log4j2
public enum MenuService {
    INSTANCE;

    private MenuDAO menuDAO;
    private ModelMapper modelMapper;

    //생성자
    MenuService() {
        menuDAO = new MenuDAO();
        modelMapper = MapperUtil.INSTANCE.getModelMapper();          //기본 생성자 호출 후 할당하기.
    }

    //기능
    // 모델 타입은 MenuDTO > VO로 변환

    // insert
    public void insert(MenuDTO menuDTO) throws Exception{
        MenuVo menuVo = modelMapper.map(menuDTO, MenuVo.class);  //menuDTO와 Menu.Vo를 맵핑함.

        //System.out.println("값 확인 : "+todoVo);
        log.info("MenuVo 확인 : " + menuVo);

        menuDAO.insert(menuVo);
    }

    // selectall
    public List<MenuDTO> listAll() throws Exception{
        List<MenuVo> VOList = menuDAO.selectAll();   //DB > DAO > VO > DTO
        log.info("MenuVo의 리스트확인 : " + VOList);
        List<MenuDTO> DTOList = VOList.stream()
                .map(menuVo -> modelMapper.map(menuVo, MenuDTO.class))
                .collect(Collectors.toList());

        return DTOList;
    }

    // selectone
    public MenuDTO selectOne(Long id) throws Exception{
        MenuVo vo = menuDAO.selectOneMenu(id);
        MenuDTO DTO = modelMapper.map(vo, MenuDTO.class);
        return DTO;
    }

    // update
    public void update(MenuDTO menuDTO) throws Exception{
        MenuVo menuVo = modelMapper.map(menuDTO, MenuVo.class);
        menuDAO.update(menuVo);
    }

    // delete
    public void delete(Long id) throws Exception{
        menuDAO.delete(id);
    }












    public void register(MenuDTO dto){
        System.out.println("debug register menu dto 확인중 :" + dto);
    }

    //임시 리스트 출력하는 기능
    public List<MenuDTO> getList(){
        //샘플 더미 데이터 생성
        List<MenuDTO> listSample = IntStream.range(0,10).mapToObj(i -> {
                    MenuDTO dto = new MenuDTO();
                    dto.setNo((long) i);
                    dto.setName("Sample 메뉴 이름 " + i);
                    dto.setDueDate(LocalDate.now());
                    return dto;
                }).collect(Collectors.toList());
        return listSample;
    }
}
