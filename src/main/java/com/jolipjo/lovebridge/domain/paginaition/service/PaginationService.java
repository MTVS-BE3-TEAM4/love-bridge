package com.jolipjo.lovebridge.domain.paginaition.service;

import com.jolipjo.lovebridge.domain.paginaition.dao.PaginationMapper;
import com.jolipjo.lovebridge.domain.paginaition.dto.PaginationDTO;
import com.jolipjo.lovebridge.domain.quiz.dto.QuizListResponseDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaginationService {

    private final PaginationMapper paginationMapper;

    public PaginationService(PaginationMapper paginationMapper) {
        this.paginationMapper = paginationMapper;
    }


    public PaginationDTO<QuizListResponseDTO> getItemsWithPagination(int page, int size) {

        int offset = (page - 1) * size;

        PaginationDTO<QuizListResponseDTO> paginationDTO = new PaginationDTO<>();

        // 퀴즈 리스트
        paginationDTO.setItems(paginationMapper.findAllByPage(offset, size));


        // 총 몇개의 퀴즈가 있는가?
        paginationDTO.setTotalItems(offset);

        // 페이지 수
        paginationDTO.setPageSize(size);

        return paginationDTO;
    }
}
