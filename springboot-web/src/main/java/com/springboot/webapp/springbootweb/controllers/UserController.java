package com.springboot.webapp.springbootweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.springboot.webapp.springbootweb.models.User;

@Controller
public class UserController {
    // Este metodo manda datos a una vista (a details.html)
    @GetMapping("/details")
    public String details(Model model){
        User user_1 = new User("Jonathan", "Cruz");
        model.addAttribute("title", "Hola Mundo Spring Boot");
        model.addAttribute("user", user_1);
        
        return "details";
    }

}
