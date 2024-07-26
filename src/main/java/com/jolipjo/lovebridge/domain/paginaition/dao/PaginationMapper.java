package com.jolipjo.lovebridge.domain.paginaition.dao;

import com.jolipjo.lovebridge.domain.quiz.dto.QuizListResponseDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PaginationMapper {

    List<QuizListResponseDTO> findAllByPage(@Param("offset") int offset,@Param("size") int size);

    int countTotalItems();
}
