package com.jolipjo.lovebridge.domain.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member/")
public class UserLogin {

    @GetMapping("login")
    public String login() {
        return "login";
    }
}
