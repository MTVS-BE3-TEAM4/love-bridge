package com.jolipjo.lovebridge.domain.Game.Controller;

import com.jolipjo.lovebridge.domain.Game.DTO.GameDTO;
import com.jolipjo.lovebridge.domain.Game.DTO.MiniGameDto;
import com.jolipjo.lovebridge.domain.Game.Service.GameService;
import com.jolipjo.lovebridge.domain.member.dto.CustomMemberDetail;
import com.jolipjo.lovebridge.domain.member.entity.Member;
import com.jolipjo.lovebridge.domain.member.entity.SecretCode;
import com.jolipjo.lovebridge.domain.member.service.MemberService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/Game")
public class GameController {

    private final MemberService memberService;
    private final GameService gameService;

    public GameController(MemberService memberService, GameService gameService) {
        this.memberService = memberService;
        this.gameService = gameService;

    }

    // 보낸다.
    @GetMapping("/MoveGame")
    public String MoveGamePage(@AuthenticationPrincipal CustomMemberDetail customMemberDetail, Model model,
                               RedirectAttributes redirectAttributes) {
        GameDTO gameDTO = new GameDTO();
        Member myMember = customMemberDetail.getMember();
        SecretCode secretCode = memberService.getSecretCode(myMember.getId());
        Long partnerId = 0L;

        Boolean isMale=false;
        if (secretCode == null || secretCode.getF_member_id() == null || secretCode.getM_member_id() == null) {
            redirectAttributes.addFlashAttribute("message", "커플이 아닙니다. MINI GAME 을 볼 수 없습니다.");
            return "redirect:/";
        }

        if (myMember.getGender().equals("F")) {
            partnerId = memberService.getMemberById(secretCode.getM_member_id()).getId();
        } else {
            partnerId = memberService.getMemberById(secretCode.getF_member_id()).getId();
        }
        Member partner = memberService.getMemberById(partnerId);

        // miniGame db 에 데이터 있는지 확인하고 없으면 insert
        MiniGameDto miniGameDtoMy = gameService.getMiniGameDtoMe(myMember.getId());
        MiniGameDto miniGameDtoPartner = gameService.getMiniGameDtoPartner(partnerId);
        if (miniGameDtoMy == null) {
            gameService.insertMission("", myMember.getId());
            miniGameDtoMy = gameService.getMiniGameDtoMe(myMember.getId());
        }
        if (miniGameDtoPartner == null) {
            gameService.insertMission("", partnerId);
            miniGameDtoPartner = gameService.getMiniGameDtoPartner(partnerId);
        }

        //남 여 판별
        if (myMember.getGender().equals("M")){
            miniGameDtoMy.setGender("M");
            miniGameDtoPartner.setGender("F");
        }else {
            miniGameDtoMy.setGender("F");
            miniGameDtoPartner.setGender("M");
        }

        model.addAttribute("MyGender", miniGameDtoMy.getGender());
        model.addAttribute("partnerGender", miniGameDtoPartner.getGender());

        try {
            if (miniGameDtoMy == null || miniGameDtoPartner == null) {
                return "redirect:http://localhost:8080";
            } else {
                gameDTO.setAttendCnt(miniGameDtoMy.getAttendCnt());
            }
        } catch (NullPointerException e) {
            return "redirect:http://localhost:8080";
        }

        gameDTO.setAttendCnt(miniGameDtoPartner.getAttendCnt());
        gameDTO.setMission(miniGameDtoMy.getMission());
        gameDTO.setMission(miniGameDtoPartner.getMission());
        gameDTO.setMyName(myMember.getNickname());
        gameDTO.setPartnerName(partner.getNickname());
        model.addAttribute("gameDTO", gameDTO);
        model.addAttribute("attendCnt", gameDTO.getAttendCnt());
        model.addAttribute("mission", miniGameDtoMy.getMission());
        model.addAttribute("partnerMission",miniGameDtoPartner.getMission());



        return "html/Game/MoveGame";
    }

    @GetMapping("/MoveGameApi")
    @ResponseBody
    public Map<String,Object> MoveGameApi(Model model, @AuthenticationPrincipal CustomMemberDetail memberDetail) {
        Map<String, Object> result = new HashMap<>();

        GameDTO gameDTO = new GameDTO();
        Member member = memberDetail.getMember();
        SecretCode secretCode = memberService.getSecretCode(member.getId());
        Member my = member;
        Long partnerId;
        Boolean isMale=false;

        // 내가 남자인지 여자인지 게이인지 레즈인지
        if(member.getId() == secretCode.getF_member_id() ){
            partnerId = secretCode.getM_member_id();
        } else{
            partnerId = secretCode.getF_member_id();
            isMale=true;
        }

        Long MyMemberId = secretCode.getF_member_id();
        Long PartnerId = secretCode.getM_member_id();
        Member partner = memberService.getMemberById(PartnerId);

        MiniGameDto miniGameDtoMy = gameService.getMiniGameDtoMe(my.getId());
        MiniGameDto miniGameDtoPartner = gameService.getMiniGameDtoPartner(partner.getId());

        //남 여 판별
        if (isMale){
            miniGameDtoMy.setGender("M");
            miniGameDtoPartner.setGender("F");
        }else {
            miniGameDtoMy.setGender("F");
            miniGameDtoPartner.setGender("M");
        }

        // 출석일수
        model.addAttribute("myAttendCnt", miniGameDtoMy.getAttendCnt());
        model.addAttribute("partnerAttendCnt", miniGameDtoPartner.getAttendCnt());
        model.addAttribute("myGender", miniGameDtoMy.getGender());
        model.addAttribute("partnerGender", miniGameDtoPartner.getGender());
        result.put("myAttendCnt", miniGameDtoMy.getAttendCnt());
        result.put("partnerAttendCnt", miniGameDtoPartner.getAttendCnt());
        result.put("MyGender", miniGameDtoMy.getGender());
        result.put("partnerGender", miniGameDtoPartner.getGender());
        return result;
    }

    @ResponseBody
    @PostMapping("/Wish")
    public String WishPage(Model model,
                           @RequestParam(value = "mission") String mission,
                           @AuthenticationPrincipal CustomMemberDetail memberDetail) {
        System.out.println("mission :: " + mission );
        gameService.missionUpdate(mission, memberDetail.getMember().getId());
        return mission;
    }


//    @PostMapping("/Wish")
//    @ResponseBody
//    public Map<String, Object> WishPage(Model model,
//                                        @RequestParam(value = "fwish") String FWish,
//                                        @RequestParam(value = "mwish") String MWish,
//                                        @AuthenticationPrincipal CustomMemberDetail memberDetail) {
//        GameDTO gameDTO = new GameDTO();
//        model.addAttribute("MWish", MWish);
//        model.addAttribute("FWish", FWish);
//        //gameService.missionInsert(FWish, memberDetail.getMember().getId());
//        gameService.missionUpdate(FWish, memberDetail.getMember().getId());
//        gameDTO.setMyName("member");
//        gameDTO.setPartnerName("member1");
//        gameDTO.setMission(FWish);
//        model.addAttribute("gameDTO", gameDTO);
//        Map<String, Object> result = new HashMap<>();
//        result.put("mission", gameDTO.getMission());
//        return result;
//
//    }


    // 받는다.
    @PostMapping("/MoveGame")
    public String MoveGameCount(
            @RequestParam(value = "cnt") Integer count,
            @RequestParam(value = "gender") String gender,
            @RequestParam(value = "winner") String winner,
            Model model, @AuthenticationPrincipal CustomMemberDetail memberDetail) {
            GameDTO gameDTO = new GameDTO();
            model.addAttribute("count", count);
            model.addAttribute("gender", gender);
            model.addAttribute("winner", winner);
            System.out.println("count :: " + count);
            if (count == 0) {
                gameService.attendanceInsert(count, memberDetail.getMember().getId());
            } else if (count < 31) {
                gameService.updateAttendance(memberDetail.getMember().getId(), count);
                if (count == 30){
                    gameService.deleteAttendanceByCount(memberDetail.getMember().getId(), count);
                }
            }
                model.addAttribute("gameDTO", gameDTO);
                return "html/Game/MoveGame";
    }

    @GetMapping("/WheelGame")
    public String playWheelGame(Model model) {
        System.out.println("Render WheelGame");
        return "html/Game/WheelGame";
    }


}

