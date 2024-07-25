package com.jolipjo.lovebridge.domain.paginaition.controller;

import com.jolipjo.lovebridge.domain.paginaition.dto.PaginationDTO;
import com.jolipjo.lovebridge.domain.paginaition.service.PaginationService;
import com.jolipjo.lovebridge.domain.quiz.dto.QuizListResponseDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/items")
public class paginationController {

    private final PaginationService itemService;

    public paginationController(PaginationService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/quiz")
    public String getItemListQuiz(@RequestParam(name = "page", defaultValue = "1") int page,
                              @RequestParam(name = "size", defaultValue = "5") int size,
                              Model model) {
        PaginationDTO<QuizListResponseDTO> paginationDTO = itemService.getItemsWithPagination(page, size);
        model.addAttribute("paginationDTO", paginationDTO);
        return "html/quiz/quiz-list";
    }
}
