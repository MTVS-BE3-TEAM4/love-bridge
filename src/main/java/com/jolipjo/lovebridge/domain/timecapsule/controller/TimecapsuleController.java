package com.jolipjo.lovebridge.domain.timecapsule.controller;

import com.jolipjo.lovebridge.domain.timecapsule.dto.TimecapsuleViewDTO;
import com.jolipjo.lovebridge.domain.timecapsule.service.TimecapsuleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/timecapsule")
public class TimecapsuleController {

    private final TimecapsuleService timeservice;

    public TimecapsuleController(TimecapsuleService timeservice) {

        this.timeservice = timeservice;

    }


    @GetMapping
    public String gettimeMain(Model model){

        model.addAttribute("message", "춘식이는 gettimeMain 각성하라");

        return "html/timecapsule/timecapsule-list";
    }
    @PostMapping
    public String posttimeMain(Model model){

        model.addAttribute("message", "이것은 gettimeMain 포스트");

        return "html/timecapsule/timecapsule-list";
    }

//    @GetMapping("/view")
//    public String getview(Model model){
//
//        //model.addAttribute("timecapsuleDTO", TimecapsuleViewDTO);
//        TimecapsuleViewDTO timecapsuleViewDTO = new TimecapsuleViewDTO();
//
//        timecapsuleViewDTO.setTcsealingdate("재호형");
//        timecapsuleViewDTO.setTcreleasedate("일어나");
//        timecapsuleViewDTO.setTctitle("코딩해야지");
//        timecapsuleViewDTO.setTcdetail("내용");
//
//        model.addAttribute("timecapsuleDTO", timecapsuleViewDTO);
//
//        return "html/timecapsule/timecapsule-view";
//    }

    @GetMapping("/view")
    public String getview(Model model) {

        List<TimecapsuleViewDTO> viewDTOList = timeservice.findAllView();
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
    public String postwrite(Model model){

        model.addAttribute("message", "춘식아 write 포스트다");
        System.out.println("춘식아포스트");
        return "html/timecapsule/timecapsule-write";
    }

//    @GetMapping("/{id}")
//    public String pp(@PathVariable("id")Long id, Model model){
//
//        model.addAttribute("message", "춘식이는 각성하라");
//
//        return "html/timecapsule/timecapsule-write";
//    }
}
