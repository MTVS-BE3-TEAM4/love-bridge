package com.jolipjo.lovebridge.domain.Game.Controller;

import com.jolipjo.lovebridge.domain.Game.DTO.GameDTO;
import com.jolipjo.lovebridge.domain.Game.DTO.MiniGameDto;
import com.jolipjo.lovebridge.domain.Game.Service.GameService;
import com.jolipjo.lovebridge.domain.member.dto.CustomMemberDetail;
import com.jolipjo.lovebridge.domain.member.entity.Member;
import com.jolipjo.lovebridge.domain.member.entity.SecretCode;
import com.jolipjo.lovebridge.domain.member.service.MemberService;
import org.springframework.security.core.AuthenticatedPrincipal;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String MoveGamePage(@AuthenticationPrincipal CustomMemberDetail customMemberDetail, Model model) {
        GameDTO gameDTO = new GameDTO();
        Member member = customMemberDetail.getMember();
        SecretCode secretCode = memberService.getSecretCode(member.getId());
        Member my = member;
        Long partnerId;

        // 내가 남자인지 여자인지 게이인지 레즈인지
        if(member.getId() == secretCode.getF_member_id() ){
            partnerId = secretCode.getM_member_id();
            System.out.println("내 성별 ::" + member.getId());
            System.out.println("파트너의 성별은 남자여야되 :: " + partnerId);
        } else{
            partnerId = secretCode.getF_member_id();
            System.out.println("내 성별 ::" + member.getId());
            System.out.println("파트너의 성별은 남자여야되 :: " + partnerId);}

        Long MyMemberId = secretCode.getF_member_id();
        Long PartnerId = secretCode.getM_member_id();
        Member partner = memberService.getMemberById(PartnerId);

        MiniGameDto miniGameDtoMy = gameService.getMiniGameDtoMe(my.getId());
        MiniGameDto miniGameDtoPartner = gameService.getMiniGameDtoPartner(partner.getId());

        System.out.println("Render MoveGame");
        System.out.println("member ::" + member);
        System.out.println("secretCode :: " + secretCode);
        System.out.println("My ::" + my);
        System.out.println("Partner ::" + my);
        System.out.println("miniGameDtoMy ::" + miniGameDtoMy);
        System.out.println("miniGameDtoPartner ::" + miniGameDtoPartner);

        try {
            if (miniGameDtoMy == null || miniGameDtoPartner == null) {
                return "redirect:http://localhost:8080";
            } else {
                gameDTO.setAttendCnt(miniGameDtoMy.getAttendCnt());
            }
        } catch (NullPointerException e) {
            return "redirect:http://localhost:8080";
        }


        gameDTO.setMission(miniGameDtoMy.getMission());
        gameDTO.setMission(miniGameDtoPartner.getMission());
        System.out.println("내 미션 ::" + miniGameDtoMy.getMission());
        System.out.println("상대 미션 ::" + miniGameDtoPartner.getMission());
        gameDTO.setMyName(member.getNickname());
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
        Member member = memberService.getByEmail(memberDetail.getUsername());
        System.out.println("MoveGameApi_member :: " + member);
        MiniGameDto miniGameDtoMy = gameService.getMiniGameDtoMe(member.getId());

        gameDTO.setAttendCnt(miniGameDtoMy.getAttendCnt());
        gameDTO.setMission(miniGameDtoMy.getMission());

        model.addAttribute("attendCnt", gameDTO.getAttendCnt());
        model.addAttribute("mission", gameDTO.getMission());

        result.put("attendCnt", gameDTO.getAttendCnt());
        result.put("mission", gameDTO.getMission());
        return result;
    }



    @PostMapping("/Wish")
    @ResponseBody
    public Map<String, Object> WishPage(Model model,
                                        @RequestParam(value = "fwish") String FWish,
                                        @RequestParam(value = "mwish") String MWish,
                                        @AuthenticationPrincipal CustomMemberDetail memberDetail) {
        GameDTO gameDTO = new GameDTO();
        model.addAttribute("MWish", MWish);
        model.addAttribute("FWish", FWish);
        //gameService.missionInsert(FWish, memberDetail.getMember().getId());
        gameService.missionUpdate(FWish, memberDetail.getMember().getId());
        gameDTO.setMyName("member");
        gameDTO.setPartnerName("member1");
        gameDTO.setMission(FWish);
        model.addAttribute("gameDTO", gameDTO);
        Map<String, Object> result = new HashMap<>();
        result.put("mission", gameDTO.getMission());
        return result;

    }


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
                System.out.println("추가");
            } else if (count < 31) {
                gameService.updateAttendance(memberDetail.getMember().getId(), count);
                System.out.println("수정");
                if (count == 30){
                    gameService.deleteAttendanceByCount(memberDetail.getMember().getId(), count);
                    System.out.println("30이니까 삭제");
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

