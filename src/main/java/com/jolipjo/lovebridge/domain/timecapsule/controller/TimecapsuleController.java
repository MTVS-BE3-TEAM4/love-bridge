package com.jolipjo.lovebridge.domain.timecapsule.controller;

import com.jolipjo.lovebridge.common.FileUploader;
import com.jolipjo.lovebridge.domain.member.dto.CustomMemberDetail;
import com.jolipjo.lovebridge.domain.member.dto.JoinRequestDTO;
import com.jolipjo.lovebridge.domain.member.entity.Member;
import com.jolipjo.lovebridge.domain.member.entity.SecretCode;
import com.jolipjo.lovebridge.domain.member.service.MemberService;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.time.LocalDate;
import java.util.List;
import java.time.LocalDate;




@Controller
@RequestMapping("/timecapsule")
public class TimecapsuleController {

    private final TimecapsuleService timeservice;
    private final FileUploader fileUploader;
    private final MemberService memberService;

    public TimecapsuleController(TimecapsuleService timeservice, FileUploader fileUploader, MemberService memberService) {

        this.timeservice = timeservice;
        this.fileUploader = fileUploader;
        this.memberService = memberService;
    }

    //타임캡슐메인
    @GetMapping
    public String gettimeMain(@AuthenticationPrincipal CustomMemberDetail customMemberDetail,
                              Model model){

//        Member member = customMemberDetail.getMember();
//        List<TimecapsuleListDTO> listDTOList = timeservice.findAllList(member.getId());

        Member member = customMemberDetail.getMember();
        SecretCode secretCode = memberService.getSecretCode(member.getId());

        List<TimecapsuleListDTO> listDTOList = timeservice.findAllList(secretCode.getF_member_id());
        List<TimecapsuleListDTO> listDTOList2 = timeservice.findAllList(secretCode.getM_member_id());
        listDTOList.addAll(listDTOList2);

        //현재시간 가져오기
        for (int i = 0; i < listDTOList.size(); i++) {
            TimecapsuleListDTO temp = listDTOList.get(i);
            System.out.println("temp : " + temp);

            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date currentTime = new Date();
            String date = format.format(currentTime);

            String end_dt = temp.getEnddate(); //db데이터날짜

            Date endDate = null;
            Date todate = null;
            try {
                endDate = format.parse(end_dt);
                todate = format.parse(date);
            } catch (ParseException e) {
                throw new RuntimeException("날자 연산 오류(타임캡슐)");
            }

            System.out.println("endDate:" + endDate);
            System.out.println("todate:" + todate);

            int compare = endDate.compareTo(todate);

            System.out.println("compare:" + compare);

            if (compare <= 0) {
                System.out.println("풀기");

            } else {
                System.out.println("잠구기");
                temp.setTitle("봉인한 기간이 끝날때까지 기다려주세요");
                temp.setContent("봉인중");
                temp.setImage("https://love-bridge-bucket.s3.amazonaws.com/default_image.png");
                listDTOList.set(i, temp);
            }
        }




        model.addAttribute("listDTOList", listDTOList);

        System.out.println("member= " + member);


        model.addAttribute("message", "춘식이는 gettimeMain 각성하라");

        return "html/timecapsule/timecapsule-list";
    }

    //타임캡슐메인
    @PostMapping
    public String posttimeMain(Model model){

        model.addAttribute("message", "이것은 gettimeMain 포스트");

        return "html/timecapsule/timecapsule-list";
    }


    //타입캡슐 상세화면 불러오기
    @GetMapping("/view/{id}")
    public String getview(@PathVariable Long id
                          ,Model model ) {

        //리스트형태로받아서
        List<TimecapsuleViewDTO> viewDTOList = timeservice.findidView(id);

        TimecapsuleViewDTO viewDTOList2 = timeservice.findidView(id).get(0);



        System.out.println("id = " + viewDTOList2.getId());

        //시작
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date currentTime = new Date();
        String date = format.format(currentTime);

        String end_dt = viewDTOList2.getTcreleasedate(); //db데이터날짜

        Date endDate = null;
        Date todate = null;
        try {
            endDate = format.parse(end_dt);
            todate = format.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException("날자 연산 오류(타임캡슐)");
        }

        System.out.println("endDate:" + endDate);
        System.out.println("todate:" + todate);

        int compare = endDate.compareTo(todate);

        System.out.println("compare:" + compare);

        if (compare <= 0) {
            System.out.println("풀기");

        } else {
            System.out.println("잠구기");
            viewDTOList2.setTctitle("봉인한 기간이 끝날때까지 기다려주세요");
            viewDTOList2.setTcdetail("봉인중");
            viewDTOList2.setImage("https://love-bridge-bucket.s3.amazonaws.com/default_image.png");
            viewDTOList.set(0, viewDTOList2);
        }
        //끝


        //모달로 넣어주겠다
        model.addAttribute("viewDTOList", viewDTOList);

        System.out.println("view/id 호출");
        System.out.println("viewDTOList: " + viewDTOList);


        return "html/timecapsule/timecapsule-view";
    }

    //타입캡슐 상세화면 불러오기
    @PostMapping("/view/{id}")
    public String postview(@PathVariable Long id, Model model){

        model.addAttribute("message", "춘식아 view 포스트다");

        return "html/timecapsule/timecapsule-view";
    }

    //타입캡슐 작성화면 불러오기
    @GetMapping("/write")
    public String getwrite(Model model){

        model.addAttribute("message", "춘식아 write 겟이다");
        System.out.println("춘식아겟");

        return "html/timecapsule/timecapsule-write";
    }

    //타입캡슐 작성화면 불러오기
    @PostMapping("/write")
    public String postwrite(@ModelAttribute TimecapsuleWriteDTO dto
                            ,@RequestParam(name = "file") MultipartFile file
                            ,@AuthenticationPrincipal CustomMemberDetail customMemberwriteDetail
                            ,TimecapsuleWriteDTO timecapsuleWriteDTO
                            ,Model model){



        //춘식이 컨트롤러에서 몰래 데이터빼오기
        Long a = customMemberwriteDetail.getMember().getId();
        System.out.println("아이디 : " + customMemberwriteDetail.getMember().getId());

        //입력값 받아서 보내주는 dto
        dto.setMemberId(a.toString());

        //파일럽로더 파일 불러오기
        String url = fileUploader.saveFile(file);

        //url을 DTO의 이미지에 넣기
        timecapsuleWriteDTO.setImage(url);
        //보여주기 //타임리프
        model.addAttribute("img", url);
        dto.setImage(url);
        //서비스 단으로 보내주기
        timeservice.registNewWirte(dto);

        System.out.println("봉인일 : " + dto.getTcsealingdate());
        System.out.println("개봉일 : " + dto.getTcreleasedate());
        System.out.println("제목 : " + dto.getTctitle());
        System.out.println("내용 :" + dto.getTctitle());
        System.out.println("url = " + url);

        return  "redirect:/timecapsule";
        //return "html/timecapsule/timecapsule-list";

    }

}
