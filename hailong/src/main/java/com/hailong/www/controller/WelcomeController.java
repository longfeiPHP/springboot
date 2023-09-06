package com.hailong.www.controller;

import com.hailong.www.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/welcome")
public class WelcomeController {

    @GetMapping("/well")
    public String hello(@RequestParam("name") String name, Model model) {
        model.addAttribute("msg", "<span style='color:red'>" + name + "<span>");
        return "welcome";
    }

    @GetMapping("list")
    public String list(Model model) {
        List<Person> list = Arrays.asList(
                new Person("张三", 12, new Date()),
                new Person("李四", 13, new Date())
        );
        model.addAttribute("list", list);
        return "list";
    }
}
