package com.jolipjo.lovebridge.domain.member.controller;

import com.jolipjo.lovebridge.common.FileUploader;
import com.jolipjo.lovebridge.domain.member.dto.*;
import com.jolipjo.lovebridge.domain.member.entity.Member;
import com.jolipjo.lovebridge.domain.member.entity.SecretCode;
import com.jolipjo.lovebridge.domain.member.service.MemberService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;
    private final FileUploader fileUploader;

    public MemberController(MemberService memberService, FileUploader fileUploader) {
        this.memberService = memberService;
        this.fileUploader = fileUploader;
    }

    /******API 사용법********/
    @GetMapping("/x")
    public String upload (@AuthenticationPrincipal CustomMemberDetail customMemberDetail) {

        /*현재 로그인 한 사용자*/
        Member member = customMemberDetail.getMember();
        System.out.println("member = " + member);
//
//        /*1번 사용자의 시크릿 코드를 새로 생성하는 메소드*/
//        memberService.createSecretCode(member.getId());
//        memberService.inviteSecretCode(21L, 15L);
        String secret = memberService.getSecretCode(member.getId()).getSecret_code();
        SecretCode secretCode = memberService.getMembersBySecretCode(secret);

        System.out.println("secretCode = " + secretCode);
//
//        /*1번 사용자의 시크릿 코드를 가져오는 메소드*/
//        SecretCode secretCode = memberService.getSecretCode(1L);
//
//        /*1번 사용자가 2번 사용자에게 시크릿 코드를 초대하는 메소드*/
//        memberService.inviteSecretCode(1L, 2L);
//
//        /*1번 시크릿코드와 연결된 사용자를 불러오는 메소드 */
//        memberService.getMembersBySecretCode(1L);
//
//        /*1번 사용자와 연결된 다른 사용저(파트너)의 ID를 가져오는 메소드*/
//        memberService.getPartner(1L);

        return "html/file-upload";
    }

    @PostMapping
    public String uploadPost (Model model,
                              @RequestParam(name = "file") MultipartFile file) {
        String url = fileUploader.saveFile(file);
        System.out.println("url = " + url);

        model.addAttribute("img", url);
        return "html/file-upload";
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
    public String findPassword() {
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
        mypageRequestDTO.setId(customMemberDetail.getMember().getId());
        memberService.updateMemberInfo(mypageRequestDTO);

        return "redirect:/member/mypage";
    }

    @PostMapping("/changePassword")
    public String changePassword(@AuthenticationPrincipal CustomMemberDetail customMemberDetail,
                                 @ModelAttribute ChangePasswordRequestDTO dto,
                                 RedirectAttributes model,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws ServletException {
        dto.setId(customMemberDetail.getMember().getId());
        Boolean result = memberService.changePassword(dto);

        model.addFlashAttribute("isChange", result);
        request.logout();

        return "redirect:/member/login";
    }

    @PostMapping("/secretCode")
    @ResponseBody
    public ResponseEntity<SecretCode> generateSecretCode(@AuthenticationPrincipal CustomMemberDetail customMemberDetail) {
        SecretCode secretCode = memberService.createSecretCode(customMemberDetail.getMember().getId());

        ResponseEntity<SecretCode> responseEntity = ResponseEntity.ok(secretCode);
        return responseEntity;

    }

    @PostMapping("/secretCode/invite")
    @ResponseBody
    public ResponseEntity<Boolean> inviteSecretCode(@AuthenticationPrincipal CustomMemberDetail customMemberDetail,
                                                  @RequestBody SecretCodeInviteDTO dto) {
        
        /*상대방 찾아옴*/
        Member member = memberService.getByEmail(dto.getEmail());
        
        /*상대방이 없으면 오류 반환*/
        if(member == null){
            ResponseEntity<Boolean> responseEntity = ResponseEntity.ok(false);
            return responseEntity;
        } 

        /*시크릿 코드 초대함*/
        memberService.inviteSecretCode(customMemberDetail.getMember().getId(), member.getId());
        ResponseEntity<Boolean> responseEntity = ResponseEntity.ok(true);

        return responseEntity;
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

    @PostMapping("/secession")
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
