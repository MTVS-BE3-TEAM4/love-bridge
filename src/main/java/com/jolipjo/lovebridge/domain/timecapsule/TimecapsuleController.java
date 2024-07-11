package com.jolipjo.lovebridge.domain.timecapsule;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/timecapsule")
public class TimecapsuleController {

    @GetMapping
    public String timeMain(Model model){

        model.addAttribute("message", "춘식이는 각성하라");

        return "html/timecapsule/timecapsule-list";
    }

    @GetMapping("/add")
    public String aa(Model model){

        model.addAttribute("message", "춘식이는 각성하라");

        return "html/timecapsule/timecapsule-view";
    }

    @GetMapping("/write")
    public String write(){

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
