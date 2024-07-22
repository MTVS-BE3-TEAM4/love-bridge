package com.jolipjo.lovebridge.domain.quiz.dao;

import com.jolipjo.lovebridge.domain.quiz.dto.QuizDetailAnswer;
import com.jolipjo.lovebridge.domain.quiz.dto.QuizListResponseDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QuizMapper {
    List<QuizListResponseDTO> getQuizList();

    String getQuizDetail(int id);

    void registAnswer(QuizDetailAnswer quizDetailAnswer);
}
