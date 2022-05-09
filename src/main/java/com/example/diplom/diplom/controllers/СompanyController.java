package com.example.diplom.diplom.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class СompanyController {

    @GetMapping("/company")
    public String getPageRegistration() {
        return "home";
    }
}
