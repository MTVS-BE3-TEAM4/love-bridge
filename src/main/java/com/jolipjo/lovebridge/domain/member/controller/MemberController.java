package com.jolipjo.lovebridge.domain.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController {

    /*로그인 페이지*/
    @GetMapping("/login")
    public String login(Model model) {
        return "html/member/login";
    }

    /*로그인 처리 경로*/
    @PostMapping("/loginProc")
    public String loginProc(Model model) {
        return "redirect:/";
    }

    /*이메일 찾기 페이지*/
    @GetMapping("/find-email")
    public String findEmail(Model model) {
        return "html/member/find_email";
    }

    /*비번 찾기 페이지*/
    @GetMapping("/find-password")
    public String findPassword(Model model) {
        return "html/member/find_password";
    }

    /*회원가입 페이지*/
    @GetMapping("/join")
    public String join(Model model) {
        return "html/member/join";
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
