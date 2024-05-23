package com.busanit501.demo.lunch.service;

import com.busanit501.demo.lunch.dao.MemberDAO;
import com.busanit501.demo.todo.domain.MemberVo;
import com.busanit501.demo.todo.dto.MemberDTO;
import com.busanit501.demo.lunch.util.MapperUtil;
import org.modelmapper.ModelMapper;

public enum MenuMemberService {
    INSTANCE;

    private MemberDAO memberDAO;
    private ModelMapper modelMapper;

    //생성자
    MenuMemberService() {
        memberDAO = new MemberDAO();
        modelMapper = MapperUtil.INSTANCE.getModelMapper();          //기본 생성자 호출 후 할당하기.
    }

    //한개 조회
    public MemberDTO getSelectOne(String id, String pw) throws Exception{
        MemberVo vo = memberDAO.getPassword(id, pw);
        MemberDTO dto = modelMapper.map(vo, MemberDTO.class);
        return dto;
    }

    //uuid 업데이트
    public void updateUUID(String id, String uuid) throws Exception{
        memberDAO.updateUUID(id, uuid);
    }

    //uuid 조회
    public MemberDTO selectUUID(String uuid) throws Exception{
        MemberVo memberVo =memberDAO.selectUUID(uuid);
        MemberDTO dto = modelMapper.map(memberVo, MemberDTO.class);
        return dto;
    }

    //회원가입
    public void insertMember(MemberDTO memberDTO) throws Exception{
        MemberVo memberVo = modelMapper.map(memberDTO, MemberVo.class);
        memberDAO.insert(memberVo);
    }

}
