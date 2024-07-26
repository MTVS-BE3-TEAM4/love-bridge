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
                              @RequestParam(value = "size", defaultValue = "5") int size,
                              @RequestParam(value = "page", defaultValue = "1") int page,
                              Model model) {

        Member member = customMemberDetail.getMember();
        SecretCode secretCode = memberService.getSecretCode(member.getId());
        if (secretCode == null) {
            redirectAttributes.addFlashAttribute("message", "커플이 아닙니다. Quiz 리스트를 볼 수 없습니다.");
            return "redirect:/";
        }

        List<QuizListResponseDTO> quizList = quizService.getQuizList(secretCode.getCouple_id());
        model.addAttribute("quizList", quizList);
        System.out.println("@@@size: " + quizList.size());

        PaginationDTO<QuizListResponseDTO> paginationDTO = new PaginationDTO<>(page, size, quizList, quizList.size());
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

    @GetMapping("/{quizNum}/{quizId}")
    public String quizDetailView(
            @PathVariable("quizNum") Long quizNum,
            @PathVariable("quizId") Long quizId,
            Model model,
            @AuthenticationPrincipal CustomMemberDetail customMemberDetail,
            QuizDetailAnswerRequestDTO quizDetailAnswerRequestDTO) {

        List<QuizDetailAnswerResponseDTO> responseDTO = quizService.getQuizDetail(
                quizId,
                memberService.getSecretCode(customMemberDetail.getMember().getId()).getCouple_id(),
                quizNum
        );
        model.addAttribute("responseDTOs", responseDTO);
        model.addAttribute("quizNum", quizNum);
        model.addAttribute("title", quizService.getOneQuizTitle(quizId));
        model.addAttribute("requestDTO", quizDetailAnswerRequestDTO);
        return "html/quiz/quiz-view";
    }

    @PostMapping("/{quizNum}/{quizId}")
    public String quizAnswerRegist(
            @PathVariable("quizNum") Long quizNum,
            @PathVariable("quizId") Long quizId,
            @ModelAttribute("requestDTO") QuizDetailAnswerRequestDTO quizDetailAnswerRequestDTO,
            @AuthenticationPrincipal CustomMemberDetail customMemberDetail) {

        Long coupleId = memberService.getSecretCode(customMemberDetail.getMember().getId()).getCouple_id();

        // 답변 등록
        quizService.registAnswer(
                quizDetailAnswerRequestDTO,
                coupleId,
                customMemberDetail.getMember().getId()
        );

        // 상대방과 자신 모두 등록되었는지 확인
        List<QuizListResponseDTO> quizList = quizService.getQuizList(coupleId);
        if (quizList.size() > 1) {
            // DB QUIZ_LIST 에 완료여부 업데이트
            quizService.updateIsQuizComplete(coupleId, quizId, quizNum);
        }

        return "redirect:/quiz/" + quizNum + "/" + quizId;
    }



}
