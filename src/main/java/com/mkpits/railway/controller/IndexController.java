package com.mkpits.railway.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @GetMapping("/index")
    public String indexPage(Model model){
        model.addAttribute("pageTitle","Country & City");
        return "index";
    }
}
