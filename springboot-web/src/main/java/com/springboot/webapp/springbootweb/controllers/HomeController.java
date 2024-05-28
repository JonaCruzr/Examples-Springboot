package com.springboot.webapp.springbootweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    //Ejemplo de "Redirect"
    @GetMapping({"", "/", "/home"}) //cualquiera de esas rutas cae aquí
    public String redirect() {
        return "redirect:/details";
    }
    
}
