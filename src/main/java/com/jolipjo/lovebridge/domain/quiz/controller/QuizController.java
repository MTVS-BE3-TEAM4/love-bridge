package com.jolipjo.lovebridge.domain.quiz.controller;

import com.jolipjo.lovebridge.domain.member.dto.CustomMemberDetail;
import com.jolipjo.lovebridge.domain.member.entity.Member;
import com.jolipjo.lovebridge.domain.member.entity.SecretCode;
import com.jolipjo.lovebridge.domain.member.service.MemberService;
import com.jolipjo.lovebridge.domain.paginaition.controller.paginationController;
import com.jolipjo.lovebridge.domain.paginaition.dto.PaginationDTO;
import com.jolipjo.lovebridge.domain.paginaition.service.PaginationService;
import com.jolipjo.lovebridge.domain.quiz.dto.*;
import com.jolipjo.lovebridge.domain.quiz.service.QuizService;
import org.springframework.context.MessageSource;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/quiz")
public class QuizController {

    private final QuizService quizService;
    private final MessageSource messageSource;
    private final MemberService memberService;
    private final PaginationService itemService;

    public QuizController(QuizService quizService, MessageSource messageSource, MemberService memberService, PaginationService itemService) {
        this.quizService = quizService;
        this.messageSource = messageSource;
        this.memberService = memberService;
        this.itemService = itemService;
    }

    @GetMapping
    public String quizGetList(@AuthenticationPrincipal CustomMemberDetail customMemberDetail,
                              RedirectAttributes redirectAttributes,
                              @RequestParam(value = "size", defaultValue = "1") int size,
                              @RequestParam(value = "page", defaultValue = "5") int page,
                              Model model) {

        Member member = customMemberDetail.getMember();
        SecretCode secretCode = memberService.getSecretCode(member.getId());
        if(secretCode == null){
            redirectAttributes.addFlashAttribute("message", "커플이 아닙니다. Quiz 리스트를 볼 수 없습니다.");
            return "redirect:/";
        }

        List<QuizListResponseDTO> quizList = quizService.getQuizList(secretCode.getCouple_id());
        model.addAttribute("quizList", quizList);

        PaginationDTO<QuizListResponseDTO> paginationDTO = itemService.getItemsWithPagination(page, size);

        model.addAttribute("paginationDTO", paginationDTO);

        return "html/quiz/quiz-list";
    }

    @PostMapping
    public String createQuiz(@AuthenticationPrincipal CustomMemberDetail customMemberDetail) {

        Member member = customMemberDetail.getMember();
        SecretCode secretCode = memberService.getSecretCode(member.getId());

        quizService.quizAdd(secretCode.getCouple_id());

        return "redirect:/quiz";
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
