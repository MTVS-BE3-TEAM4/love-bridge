package com.jolipjo.lovebridge.domain.adminPage;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/adminPage")
    public String adminPage(Model model)
    {
        System.out.println("Render Admin Page");
        return "html/admin/adminPage";
    }

    @GetMapping("/UserManagement")
    public String UserManager(Model model)
    {
        System.out.println("Render User Management");
        return "html/admin/UserManager";
    }

    @GetMapping("/NoticeManager")
    public String NoticeManager(Model model)
    {
        System.out.println("Render Notice Manager");
        return "html/admin/NoticeManager";
    }

    @GetMapping("/BoardManager")
    public String BoardManager(Model model)
    {
        System.out.println("Render Board Manager");
        return "html/admin/BoardManager";
    }

    @GetMapping("/InquiryManager")
    public String InquiryManager(Model model)
    {
        System.out.println("Render Inquiry Manager");
        return "html/admin/InquiryManager";
    }
}
