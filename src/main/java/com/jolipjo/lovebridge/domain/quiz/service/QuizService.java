package com.jolipjo.lovebridge.domain.quiz.service;

import com.jolipjo.lovebridge.domain.paginaition.dto.PaginationDTO;
import com.jolipjo.lovebridge.domain.quiz.dao.QuizMapper;
import com.jolipjo.lovebridge.domain.quiz.dto.*;
import com.jolipjo.lovebridge.domain.quiz.entity.QuizAnswer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class QuizService {

    private final QuizMapper quizMapper;

    public QuizService(QuizMapper quizMapper) {
        this.quizMapper = quizMapper;
    }

    public List<QuizListResponseDTO> getQuizList(Long id) {

        List<QuizListResponseDTO> quizList = quizMapper.getQuizList(id);
        List<QuizListResponseDTO> subset = new ArrayList<>();
        List<Integer> indices = new ArrayList<>();

        for (int i = 0; i < quizList.size(); i++) {
            indices.add(i);
        }
        Collections.shuffle(indices);

        int count = 0;

        for (Integer index : indices) {
//            if (count >= subsetSize) {
//                break;
//            }
            QuizListResponseDTO quiz = quizList.get(index);
            if (!subset.contains(quiz)) {
                subset.add(quiz);
                count++;
            }
        }

        return subset;
    }

    public List<QuizDetailAnswerResponseDTO> getQuizDetail(Long quizId, Long coupleId, Long quizNum) {
        QuizAnswerPKParameter quizAnswerPKParameter = new QuizAnswerPKParameter(
                quizId, coupleId, quizNum
        );

        return quizMapper.getQuizDetail(quizAnswerPKParameter);
    }

    @Transactional
    public void registAnswer(
            QuizDetailAnswerRequestDTO quizDetailAnswerRequestDTO,
            Long coupleId,
            Long memberId) {
        QuizAnswer quizAnswer = new QuizAnswer(
                quizDetailAnswerRequestDTO.getQuizAnswer(),
                LocalDateTime.now(),
                quizDetailAnswerRequestDTO.getQuizId(),
                coupleId,
                quizDetailAnswerRequestDTO.getQuizNum(),
                memberId
        );

        quizMapper.registAnswer(quizAnswer);
    }

    @Transactional
    public void quizAdd(Long coupleId) {
        quizMapper.quizAdd(coupleId);
    }

    public PaginationDTO<QuizService> getItemsWithPagination(int page, int size) {
        PaginationDTO<QuizService> paginationDTO = new PaginationDTO<>();
        paginationDTO.setCurrentPage(page);
        paginationDTO.setPageSize(size);

        int offset = (page - 1) * size;
        List<QuizService> items = quizMapper.selectItemsWithPagination(offset, size);
        paginationDTO.setItems(items);

        int totalItems = quizMapper.countTotalItems();
        paginationDTO.setTotalItems(totalItems);

        return paginationDTO;
    }

    public String getOneQuizTitle(Long quizId) {
        return quizMapper.getOneQuiz(quizId);
    }


//    public String getImgSrc() {
//        return quizMapper.getImgSrc();
//    }
}
