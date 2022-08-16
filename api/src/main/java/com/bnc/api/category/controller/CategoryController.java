package com.bnc.api.category.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CategoryController {

    @GetMapping("/createCategoryForm")
    public String createCategoryForm(){

        return "views/category/registerCategory";
    }
}
