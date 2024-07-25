package com.jolipjo.lovebridge.domain.paginaition.dao;

import com.jolipjo.lovebridge.domain.quiz.dto.QuizListResponseDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PaginationMapper {

    List<QuizListResponseDTO> findAllByPage(int offset, int size);
}
