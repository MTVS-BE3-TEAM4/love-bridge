package com.jolipjo.lovebridge.domain.quiz.service;

import com.jolipjo.lovebridge.domain.quiz.dao.QuizMapper;
import com.jolipjo.lovebridge.domain.quiz.dto.QuizListResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {

    private final QuizMapper quizMapper;

    public QuizService(QuizMapper quizMapper) {
        this.quizMapper = quizMapper;
    }

    public List<QuizListResponseDTO> getQuizList() {
        return quizMapper.getQuizList();
    }
}
