package com.jolipjo.lovebridge.domain.Game;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/Game")
public class GameController {

    // 보낸다.
    @GetMapping("/MoveGame")
    public String MoveGamePage(Model model) {
        System.out.println("Render MoveGame");
        return "html/Game/MoveGame";
    }

    @PostMapping("/Wish")
    public String WishPage(Model model,
    @RequestParam(value = "fwish", required=false) String MWish,
    @RequestParam(value = "mwish", required = false) String FWish) {
        System.out.println("MWish: " + MWish);
        System.out.println("FWish: " + FWish);
        model.addAttribute("MWish", MWish);
        model.addAttribute("FWish", FWish);
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

