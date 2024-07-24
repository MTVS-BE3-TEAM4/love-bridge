package com.jolipjo.lovebridge.domain.admin;

import com.jolipjo.lovebridge.domain.admin.dto.MemberInfoDTO;
import com.jolipjo.lovebridge.domain.admin.service.AdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping
    public String adminPage() {

        return "html/admin/index";
    }

    @GetMapping("/member")
    public String memberManagementPage(Model model) {

        List<MemberInfoDTO> memberList = adminService.getAllMembers();
        System.out.println("memberList = " + memberList);
//        for(long i = 0; i < 5; i++) {
//            MemberInfoDTO dto = new MemberInfoDTO();
//            dto.setId(i);
//            dto.setEmail("email" + i);
//            dto.setBirth("birth" + i);
//            dto.setRole("role" + i);
//            dto.setGender("gender" + i);
//            dto.setSecretCode("secret" + i);
//            dto.setNickname("nickname" + i);
//            memberList.add(dto);
//        }

        model.addAttribute("members", memberList);

        return "html/admin/member";
    }

    @PostMapping("/member/{id}")
    @ResponseBody
    public ResponseEntity<Void> updateMemberInfo(@PathVariable("id") long id,
                                           @RequestBody MemberInfoDTO memberInfoDTO) {
        System.out.println("id = " + id);
        System.out.println("memberInfoDTO = " + memberInfoDTO);

        return ResponseEntity.ok().build();
    }
}
