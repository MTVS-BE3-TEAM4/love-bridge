package com.jolipjo.lovebridge.domain.paginaition.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PaginationMapper {
    int countTotalItems();

    <T> List<T> findAllByPage(int offset, int page);
}
