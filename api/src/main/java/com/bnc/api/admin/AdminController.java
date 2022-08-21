package com.bnc.api.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {


    @GetMapping("/adminPageForm")
    public String adminPage(){

        return "views/admin/registerCategory";
    }
}
