package com.hailong.www.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/welcome")
public class WelcomeController {

    @GetMapping("/well")
    public String hello(@RequestParam("name") String name, Model model) {
        model.addAttribute("msg",name);
        return "welcome";
    }
}
