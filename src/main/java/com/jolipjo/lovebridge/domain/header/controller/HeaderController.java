package com.jolipjo.lovebridge.domain.header.controller;

import com.jolipjo.lovebridge.domain.member.dto.CustomMemberDetail;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/include/header")
public class HeaderController {
//    @GetMapping
//    public Boolean loginStatus() {
//
//        boolean status = false;
//        try {
//            status = SecurityContextHolder.getContext().getAuthentication().isAuthenticated();
//
//
//        } catch (Exception e) {
//            System.out.print(e.getMessage());
//        }
//
//        return status;
//
//
//    }
    @GetMapping
    public boolean loginStatus(@AuthenticationPrincipal CustomMemberDetail customMemberDetail) {

       return customMemberDetail != null;
    }
}
