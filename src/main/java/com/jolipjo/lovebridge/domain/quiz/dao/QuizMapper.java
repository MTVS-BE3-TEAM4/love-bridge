package com.jolipjo.lovebridge.domain.quiz.dao;

import com.jolipjo.lovebridge.domain.quiz.dto.QuizAnswerDbParameter;
import com.jolipjo.lovebridge.domain.quiz.dto.QuizDetailAnswer;
import com.jolipjo.lovebridge.domain.quiz.dto.QuizDetailAnswerResponseDTO;
import com.jolipjo.lovebridge.domain.quiz.dto.QuizListResponseDTO;
import com.jolipjo.lovebridge.domain.quiz.service.QuizService;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QuizMapper {
    List<QuizListResponseDTO> getQuizList(Long id);

    List<QuizDetailAnswerResponseDTO> getQuizDetail(QuizAnswerDbParameter quizAnswerDbParameter);

    void registAnswer(QuizDetailAnswer quizDetailAnswer);


    void quizAdd(Long coupleId);

    List<QuizService> selectItemsWithPagination(int offset, int size);

    int countTotalItems();

    String getOneQuiz(Long quizId);
}
