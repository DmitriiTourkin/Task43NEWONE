package com.example.HELLO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AppController {
    @Autowired
    private UserService userService;

    @RequestMapping("/homePage")
    public String viewHomePage() {
        return "HelloWorld";
    }
    @GetMapping("/registration")
    public String registration(Model model){
        Users users = new Users();
        System.out.println(users);
        model.addAttribute("user", users);
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(@ModelAttribute("user") Users users) {
        if(userService.addUser(users))  return "redirect:/login";
        else return "registration";
    }
}
