package com.jolipjo.lovebridge.domain.paginaition.dao;

import com.jolipjo.lovebridge.domain.quiz.dto.QuizListResponseDTO;

import java.util.List;

public interface PaginationMapper {

    List<QuizListResponseDTO> findAllByPage(int offset, int size);
}
