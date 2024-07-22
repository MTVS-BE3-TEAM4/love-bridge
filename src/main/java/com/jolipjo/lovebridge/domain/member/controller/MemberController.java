package com.jolipjo.lovebridge.domain.member.controller;

import com.jolipjo.lovebridge.domain.member.dto.*;
import com.jolipjo.lovebridge.domain.member.entity.Member;
import com.jolipjo.lovebridge.domain.member.entity.SecretCode;
import com.jolipjo.lovebridge.domain.member.service.MemberService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    /******API 사용법********/
    @GetMapping
    public String test(@AuthenticationPrincipal CustomMemberDetail customMemberDetail) {

        /*현재 로그인 한 사용자*/
        Member member = customMemberDetail.getMember();
        System.out.println("member = " + member);

        /*1번 사용자의 시크릿 코드를 새로 생성하는 메소드*/
        memberService.createSecretCode(1L);

        /*1번 사용자의 시크릿 코드를 가져오는 메소드*/
        SecretCode secretCode = memberService.getSecretCode(1L);

        /*1번 사용자가 2번 사용자에게 시크릿 코드를 초대하는 메소드*/
        memberService.inviteSecretCode(1L, 2L);

        /*1번 시크릿코드와 연결된 사용자를 불러오는 메소드 */
        memberService.getMembersBySecretCode(1L);

        /*1번 사용자와 연결된 다른 사용저(파트너)의 ID를 가져오는 메소드*/
        memberService.getPartner(1L);

        return "html/member/login";
    }

    /*로그인 페이지*/
    @GetMapping("/login")
    public String login() {
        return "html/member/login";
    }

    /*이메일 찾기 페이지*/
    @GetMapping("/find-email")
    public String findEmail() {

        return "html/member/find_email";
    }

    @PostMapping("/find-email")
    public String findEmail(@ModelAttribute FindEmailRequestDTO dto,
                            RedirectAttributes model){

        FindEmailResponseDTO responseDTO = new FindEmailResponseDTO();

        Member member = memberService.getByEmail(dto.getEmail());

        if(member == null){
            responseDTO.setIsExist(false);
            model.addFlashAttribute("isExist", responseDTO);
        } else{
            responseDTO.setIsExist(true);
            model.addFlashAttribute("isExist", responseDTO);
        }

        return "redirect:/member/find-email";
    }

    /*비번 찾기 페이지*/
    @GetMapping("/find-password")
    public String findPassword(@AuthenticationPrincipal CustomMemberDetail member) {
        System.out.println("member = " + member.getMember());
        return "html/member/find_password";
    }

    @PostMapping("/find-password")
    public String findPassword(@ModelAttribute FindPasswordRequestDTO dto,
                               RedirectAttributes model) {
        System.out.println("dto = " + dto);
        FindPasswordResponseDTO responseDTO = new FindPasswordResponseDTO();

        responseDTO.setPasswordReset(false);
        model.addFlashAttribute("isReset", responseDTO);
        return "redirect:/member/find-password";
    }


    /*회원가입 페이지*/
    @GetMapping("/join")
    public String join() {
        return "html/member/join";
    }

    @PostMapping("/joinProc")
    public String join(@ModelAttribute JoinRequestDTO joinRequestDTO,
                       RedirectAttributes model,
                       HttpServletRequest request,
                       HttpServletResponse response) throws ServletException {
        memberService.join(joinRequestDTO);
        model.addFlashAttribute("nickname", joinRequestDTO.getNickname());

        /*회원가입 후 자동 로그인*/
        request.login(joinRequestDTO.getEmail(), joinRequestDTO.getPassword());

        return "redirect:/member/join-complete";
    }

    @GetMapping("/mypage")
    public String myPage(@AuthenticationPrincipal CustomMemberDetail customMemberDetail,
                        Model model) {
        Member member = customMemberDetail.getMember();
        MypageResponseDTO response = memberService.getMypageInfo(member.getId());
        model.addAttribute("member", response);

        return "html/mypage/mypage";
    }

    @PostMapping("/mypage")
    public String myPageUpdate(@AuthenticationPrincipal CustomMemberDetail customMemberDetail,
                               @ModelAttribute MypageRequestDTO mypageRequestDTO,
                               RedirectAttributes model) {
        System.out.println("mypageRequestDTO = " + mypageRequestDTO);
        return "redirect:/member/mypage";
    }

    @GetMapping("/admin")
    public String admin2() {
        return "html/admin/adminPage";
    }

    /*회원가입 완료 페이지*/
    @GetMapping("/join-complete")
    public String joinComplete() {
        return "html/member/join_complete";
    }

    /*회원탈퇴 페이지*/
    @GetMapping("/secession")
    public String secession() {
        return "html/member/secession_confirm";
    }

    @PostMapping("/secessionProc")
    public String secessionProc() {
        System.out.println("secessionProc");
        return "redirect:/member/secession-complete";
    }

    /*회원탈퇴 완료 페이지*/
    @GetMapping("/secession-complete")
    public String secessionComplete() {
        return "html/member/secession_complete";
    }
}
