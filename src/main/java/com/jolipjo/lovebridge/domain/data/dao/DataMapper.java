package com.jolipjo.lovebridge.domain.data.dao;

import com.jolipjo.lovebridge.domain.data.dto.Rate;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DataMapper {
    void insertRate(Rate rate);
}
