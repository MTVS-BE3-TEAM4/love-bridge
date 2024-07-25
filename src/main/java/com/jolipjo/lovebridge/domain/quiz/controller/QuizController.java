package com.jolipjo.lovebridge.domain.quiz.controller;

import com.jolipjo.lovebridge.domain.member.dto.CustomMemberDetail;
import com.jolipjo.lovebridge.domain.member.entity.Member;
import com.jolipjo.lovebridge.domain.quiz.dto.*;
import com.jolipjo.lovebridge.domain.quiz.service.QuizService;
import org.springframework.context.MessageSource;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/quiz")
public class QuizController {

    private final QuizService quizService;
    private final MessageSource messageSource;

    public QuizController(QuizService quizService, MessageSource messageSource) {
        this.quizService = quizService;
        this.messageSource = messageSource;
    }

    @GetMapping
    public String quizGetList(
                              QuizListResponseDTO quizListResponseDTO, Model model) {

//        Member member = customMemberDetail.getMember();

        List<QuizListResponseDTO> quizList = quizService.getQuizList();
        model.addAttribute("quizList", quizList);

        return "html/quiz/quiz-list";
    }

    @GetMapping("{id}")
    public String quizDetailView(@PathVariable("id") Long id, Model model) {

        String quizGetTitle = quizService.getQuizDetail(id);
        model.addAttribute("quizGetTitle", quizGetTitle);

        return "html/quiz/quiz-view";
    }

    @PostMapping("/{id}")
    public String quizAnswerRegist(QuizDetailAnswer quizDetailAnswer) {

        quizService.registAnswer(quizDetailAnswer);

        return "html/quiz/quiz-view";
    }


}
