package com.jolipjo.lovebridge.domain.Game.Controller;

import com.jolipjo.lovebridge.domain.Game.DTO.GameDTO;
import com.jolipjo.lovebridge.domain.Game.Service.GameService;
import com.jolipjo.lovebridge.domain.member.dto.CustomMemberDetail;
import com.jolipjo.lovebridge.domain.member.entity.Member;
import com.jolipjo.lovebridge.domain.member.service.MemberService;
import org.springframework.security.core.AuthenticatedPrincipal;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String MoveGamePage(Model model) {
        GameDTO gameDTO = new GameDTO();
        System.out.println("Render MoveGame");
        Member member = memberService.getByEmail("email@email.com");
        Member member1 = memberService.getByEmail("qwer");
        gameDTO.setMyName(member.getNickname());
        gameDTO.setPartnerName(member1.getNickname());
        model.addAttribute("gameDTO", gameDTO);
        return "html/Game/MoveGame";
    }

    @PostMapping("/Wish")
    public String WishPage(Model model,
    @RequestParam(value = "fwish", required=false) String MWish,
    @RequestParam(value = "mwish", required = false) String FWish,
    @AuthenticationPrincipal CustomMemberDetail memberDetail
    ) {
        GameDTO gameDTO = new GameDTO();

        System.out.println("MWish: " + MWish);
        System.out.println("FWish: " + FWish);
        model.addAttribute("MWish", MWish);
        model.addAttribute("FWish", FWish);
        gameService.missionInsert(FWish,memberDetail.getMember().getId());
        gameDTO.setMyName("member");
        gameDTO.setPartnerName("member1");
        model.addAttribute("gameDTO", gameDTO);


        return "html/Game/MoveGame";
    }

    // 받는다.
    @PostMapping("/MoveGame")
    public String MoveGameCount(@RequestParam(value = "cnt") Integer count,
                                @RequestParam(value = "gender") String gender,
                                @RequestParam(value = "winner") String winner,
                                Model model) {

            System.out.println("Gender: " + gender);
            System.out.println("Count: " + count);
            System.out.println("Winner: " + winner);

            model.addAttribute("count", count);
            model.addAttribute("gender", gender);
            model.addAttribute("winner", winner);


        return "html/Game/MoveGame";
    }

    @GetMapping("/WheelGame")
    public String playWheelGame(Model model) {
        System.out.println("Render WheelGame");
        return "html/Game/WheelGame";
    }
}

