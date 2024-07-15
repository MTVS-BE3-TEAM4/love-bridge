package com.jolipjo.lovebridge.Game;

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
    // 받는다.
    @PostMapping("/MoveGame")
    public String MoveGameCount(@RequestParam("cnt") Integer count,
                                @RequestParam("gender") String gender,
                                @RequestParam("winner") String winner,
                                Model model) {
        System.out.println("Gender: " + gender);
        System.out.println("Count: " + count);
        System.out.println("Winner: " + winner);
        model.addAttribute("count", count);
        model.addAttribute("gender", gender);
        model.addAttribute("winner", winner);
        return "html/Game/MoveGame";
    }
}
