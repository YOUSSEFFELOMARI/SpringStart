package com.eazybytes.sboot.controller;

import com.eazybytes.sboot.model.Person;
import com.eazybytes.sboot.repository.PersonRepository;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class DashboardController {

    @Autowired
    PersonRepository personRepository;
    @RequestMapping(value = "/dashboard")
    public String displayDashboard(Model model, Authentication authentication, HttpSession httpSession){
        Person person= personRepository.readByEmail(authentication.getName());
        model.addAttribute("username",person.getName());
        model.addAttribute("roles", authentication.getAuthorities().toString());
        if(null != person.getEazyClass() && null != person.getEazyClass().getName()){
            model.addAttribute("enrolledClass", person.getEazyClass().getName());
        }
        httpSession.setAttribute("logedInPerson",person);
        return "dashboard.html";
    }
}
