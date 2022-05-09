package com.example.diplom.diplom.controllers.accountControllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @GetMapping("/admin-panel")
    public String getAllAdresses() {
        return "admin/admin-panel/admin-panel";
    }
}
