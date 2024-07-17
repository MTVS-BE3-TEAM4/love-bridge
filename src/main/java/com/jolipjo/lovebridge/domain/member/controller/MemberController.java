package com.jolipjo.lovebridge.domain.member.controller;

import com.jolipjo.lovebridge.domain.member.dao.MemberMapper;
import com.jolipjo.lovebridge.domain.member.dto.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/member")
public class MemberController {

    private final MemberMapper mapper;

    public MemberController(MemberMapper mapper) {
        this.mapper = mapper;
    }

    /*로그인 페이지*/
    @GetMapping("/login")
    public String login(Model model) {
        JoinRequestDTO dto = new JoinRequestDTO();

        dto.setEmail("aaa");
        mapper.secret(dto);

        return "html/member/login";
    }

    /*로그인 처리 경로*/
    @PostMapping("/loginProc")
    public String loginProc(@ModelAttribute LoginRequestDTO loginRequestDTO,
                            Model model) {
        System.out.println("loginRequestDTO = " + loginRequestDTO);
        return "redirect:/";
    }

    /*이메일 찾기 페이지*/
    @GetMapping("/find-email")
    public String findEmail(Model model) {
        return "html/member/find_email";
    }

    @PostMapping("/find-email")
    public String findEmail(@ModelAttribute FindEmailRequestDTO dto,
                            RedirectAttributes model){
        System.out.println("dto = " + dto);
        FindEmailResponseDTO responseDTO = new FindEmailResponseDTO();
        responseDTO.setIsExist(true);
        model.addFlashAttribute("isExist", responseDTO);
        return "redirect:/member/find-email";

    }

    /*비번 찾기 페이지*/
    @GetMapping("/find-password")
    public String findPassword(Model model) {
        return "html/member/find_password";
    }

    @PostMapping("/find-password")
    public String findPassword(@ModelAttribute FindPasswordRequestDTO dto,
                               RedirectAttributes model) {
        System.out.println("dto = " + dto);
        FindPasswordResponseDTO responseDTO = new FindPasswordResponseDTO();

        responseDTO.setPasswordReset(true);
        model.addFlashAttribute("isReset", responseDTO);
        return "redirect:/member/find-password";
    }

    /********TODO: 나머지 타임리프 데이터 연결!**************/

    /*회원가입 페이지*/
    @GetMapping("/join")
    public String join(Model model) {

        return "html/member/join";
    }

    @PostMapping("/joinProc")
    public String join(@ModelAttribute JoinRequestDTO joinRequestDTO,
                       RedirectAttributes model) {
        System.out.println("joinRequestDTO = " + joinRequestDTO);
        return "redirect:/member/join-complete";
    }

    /*회원가입 완료 페이지*/
    @GetMapping("/join-complete")
    public String joinComplete(Model model) {

        return "html/member/join_complete";
    }

    /*회원탈퇴 페이지*/
    @GetMapping("/secession")
    public String secession(Model model) {
        return "html/member/secession_confirm";
    }

    /*회원탈퇴 완료 페이지*/
    @GetMapping("/secession-complete")
    public String secessionComplete(Model model) {
        return "html/member/secession_complete";
    }
}
