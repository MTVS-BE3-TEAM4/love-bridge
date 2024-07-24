package com.jolipjo.lovebridge.domain.timecapsule.controller;

import com.jolipjo.lovebridge.domain.member.dto.CustomMemberDetail;
import com.jolipjo.lovebridge.domain.member.dto.JoinRequestDTO;
import com.jolipjo.lovebridge.domain.member.entity.Member;
import com.jolipjo.lovebridge.domain.timecapsule.dto.TimecapsuleListDTO;
import com.jolipjo.lovebridge.domain.timecapsule.dto.TimecapsuleViewDTO;
import com.jolipjo.lovebridge.domain.timecapsule.dto.TimecapsuleWriteDTO;
import com.jolipjo.lovebridge.domain.timecapsule.service.TimecapsuleService;
import org.apache.logging.log4j.LogManager;
import org.springframework.cglib.core.Local;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/timecapsule")
public class TimecapsuleController {

    //private static final Logger logger =  LogManager.getLogger(TimecapsuleController.class);
    private final TimecapsuleService timeservice;

    public TimecapsuleController(TimecapsuleService timeservice) {

        this.timeservice = timeservice;

    }

    @GetMapping
    public String gettimeMain(@AuthenticationPrincipal CustomMemberDetail customMemberDetail,
                              Model model){

        Member member = customMemberDetail.getMember();
        List<TimecapsuleListDTO> listDTOList = timeservice.findAllList(member.getId());
        //로그인 한놈
        //member.getId();
        System.out.println("listDTOList = " + listDTOList);

        model.addAttribute("listDTOList", listDTOList);

        System.out.println("member= " + member);

        model.addAttribute("message", "춘식이는 gettimeMain 각성하라");

        return "html/timecapsule/timecapsule-list";
    }

    @PostMapping
    public String posttimeMain(Model model){

        model.addAttribute("message", "이것은 gettimeMain 포스트");

        return "html/timecapsule/timecapsule-list";
    }


    @GetMapping("/view")
    public String getview(Model model) {

        //리스트형태로받아서
        List<TimecapsuleViewDTO> viewDTOList = timeservice.findAllView();
        //모달로 넣어주겠다
        model.addAttribute("viewDTOList", viewDTOList);
        System.out.println("viewDTOList: " + viewDTOList);

        return "html/timecapsule/timecapsule-view";
    }


    @PostMapping("/view")
    public String postview(Model model){

        model.addAttribute("message", "춘식아 view 포스트다");

        return "html/timecapsule/timecapsule-view";
    }

    @GetMapping("/write")
    public String getwrite(Model model){

        model.addAttribute("message", "춘식아 write 겟이다");
        System.out.println("춘식아겟");

        return "html/timecapsule/timecapsule-write";
    }


    @PostMapping("/write")
    public String postwrite(@ModelAttribute TimecapsuleWriteDTO dto,
                            @AuthenticationPrincipal CustomMemberDetail customMemberwriteDetail,
                            Model model){
        //멤버 id받아서 넘길곳
//        Member member = customMemberwriteDetail.getMember();
//        List<TimecapsuleListDTO> writeDTOList = timeservice.findAllList(member.getId());

        //춘식이 컨트롤러에서 몰래 데이터빼오기
        Long a = customMemberwriteDetail.getMember().getId();
        System.out.println("아이디 : " + customMemberwriteDetail.getMember().getId());

        //입력값 받아서 보내주는 dto
        dto.setMemberId(a.toString());
//        model.addAttribute("listDTOList", a);
        timeservice.registNewWirte(dto);


        //System.out.println(member);



        //List<TimecapsuleWriteDTO> writeDTO = timeservice.findAllWrite();

        System.out.println("봉인일 : " + dto.getTcsealingdate());
        System.out.println("개봉일 : " + dto.getTcreleasedate());
        System.out.println("제목 : " + dto.getTctitle());
        System.out.println("내용 :" + dto.getTctitle());
        //System.out.println("아이디 : " + member);

        //model.addAttribute("viewDTOList", viewDTOList);

        return  "redirect:/timecapsule";
        //return "html/timecapsule/timecapsule-list";

    }

}
