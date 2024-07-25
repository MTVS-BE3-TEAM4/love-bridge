package com.jolipjo.lovebridge.domain.Game.Controller;

import com.jolipjo.lovebridge.domain.Game.DTO.GameDTO;
import com.jolipjo.lovebridge.domain.Game.DTO.MiniGameDto;
import com.jolipjo.lovebridge.domain.Game.Service.GameService;
import com.jolipjo.lovebridge.domain.member.dto.CustomMemberDetail;
import com.jolipjo.lovebridge.domain.member.entity.Member;
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

        System.out.println("Render MoveGame");
        Member member = customMemberDetail.getMember();
        Member member1 = memberService.getPartnerInfo(member.getId());

        MiniGameDto miniGameDto = gameService.getMiniGameDto(member.getId());
        MiniGameDto miniGameDto1 = gameService.getMiniGameDto(member1.getId());
        try {
            if (miniGameDto == null) {
                return "redirect:http://localhost:8080";
            } else {
                gameDTO.setAttendCnt(miniGameDto.getAttendCnt());
            }
        } catch (NullPointerException e) {
            return "redirect:http://localhost:8080";
        }


        gameDTO.setMission(miniGameDto.getMission());
        gameDTO.setMyName(member.getNickname());
        gameDTO.setPartnerName(member1.getNickname());
        model.addAttribute("gameDTO", gameDTO);
        model.addAttribute("attendCnt", gameDTO.getAttendCnt());
        model.addAttribute("mission", gameDTO.getMission());

        return "html/Game/MoveGame";
    }

    @GetMapping("/MoveGameApi")
    @ResponseBody
    public Map<String,Object> MoveGameApi(Model model, @AuthenticationPrincipal CustomMemberDetail memberDetail) {
        Map<String, Object> result = new HashMap<>();

        GameDTO gameDTO = new GameDTO();
        Member member = memberService.getByEmail(memberDetail.getUsername());
        System.out.println("member :: " + member);
        MiniGameDto miniGameDto = gameService.getMiniGameDto(member.getId());
        gameDTO.setAttendCnt(miniGameDto.getAttendCnt());
        gameDTO.setMission(miniGameDto.getMission());

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

