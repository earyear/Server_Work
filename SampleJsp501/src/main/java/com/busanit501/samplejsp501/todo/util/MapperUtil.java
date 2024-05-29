package com.busanit501.samplejsp501.todo.util;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

public enum MapperUtil {
    INSTANCE;

    //modelMapper 필요함. 주입, 포함 DI (Dependancy in.....)
    private ModelMapper modelMapper;

    MapperUtil() {
        this.modelMapper = new ModelMapper();

        this.modelMapper.getConfiguration()
                //vo와 dto간의 멤버의 일치성 여부 확인
                .setFieldMatchingEnabled(true)
                // 기본, public, dafault
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
                //VO <> DTO간의 검사를 정확하게 일치해야함.(꼼꼼하게 확인해달라)
                .setMatchingStrategy(MatchingStrategies.STRICT);
    }

    public ModelMapper getModelMapper() {
        return modelMapper;
    }
}
