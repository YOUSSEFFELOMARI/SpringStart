package com.eazybytes.sboot.controller;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class DashboardController {
    @RequestMapping(value = "/dashboard")
    public String displayDashboard(Model model, Authentication authentication){
        model.addAttribute("username",authentication.getName());
        model.addAttribute("roles", authentication.getAuthorities().toString());
//        throw new RuntimeException("error");
        return "dashboard.html";
    }
}
