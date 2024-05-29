package com.busanit501.samplejsp501.todo.service;

import com.busanit501.samplejsp501.todo.dao.MemberDAO;
import com.busanit501.samplejsp501.todo.domain.MemberVo;
import com.busanit501.samplejsp501.todo.dto.MemberDTO;
import com.busanit501.samplejsp501.todo.util.MapperUtil;
import org.modelmapper.ModelMapper;

public enum MemberService {
    INSTANCE;

    private MemberDAO memberDAO;
    private ModelMapper modelMapper;

    //생성자
    MemberService() {
        memberDAO = new MemberDAO();
        modelMapper = MapperUtil.INSTANCE.getModelMapper();          //기본 생성자 호출 후 할당하기.
    }

    //한개 조회
    public MemberDTO getSelectOne(String id, String pw) throws Exception{
        MemberVo vo = memberDAO.getPassword(id, pw);
        MemberDTO dto = modelMapper.map(vo, MemberDTO.class);
        return dto;
    }

    public void updateUUID(String id, String uuid) throws Exception{
        memberDAO.updateUUID(id, uuid);
    }

    public MemberDTO selectUUID(String uuid) throws Exception{
        MemberVo memberVo =memberDAO.selectUUID(uuid);
        MemberDTO dto = modelMapper.map(memberVo, MemberDTO.class);
        return dto;
    }

    public void insertMember(MemberDTO memberDTO) throws Exception{
        MemberVo memberVo = modelMapper.map(memberDTO, MemberVo.class);
        memberDAO.insert(memberVo);
    }

}
