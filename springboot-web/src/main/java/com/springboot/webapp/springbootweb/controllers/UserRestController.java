package com.springboot.webapp.springbootweb.controllers;

import java.util.Map;
//import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.webapp.springbootweb.models.User;
import com.springboot.webapp.springbootweb.models.dto.UserDto;

@RestController
@RequestMapping("/api")
public class UserRestController {

    @GetMapping("/details")
    public UserDto details(){
        User user = new User("Jonathan", "Cruz");

        UserDto userDto = new UserDto();
        userDto.setUser(user);
        userDto.setTitle("Hola Mundo Spring Boot con un DTO");

        return userDto;
    }

    // Devuelve una lista de usuarios
    @GetMapping("/list")
    public List<User> list(){

        User user_1 = new User("Jonathan", "Cruz");
        User user_2 = new User("Laura", "Villanueva");
        User user_3 = new User("David", "Segundo");
        
        List<User> lista_usuarios = Arrays.asList(user_1, user_2, user_3); //Es equivalente a las linead e abajo

        // List<User> lista_usuarios = new ArrayList<>();
        // lista_usuarios.add(user_1);
        // lista_usuarios.add(user_2);
        // lista_usuarios.add(user_3);
        return lista_usuarios;
    }
    
    @GetMapping("/details-map")
    public Map<String, Object> detailsMap(){
        User user_1 = new User("Jonathan", "Cruz");
        Map<String, Object> body_response = new HashMap<>();
        
        body_response.put("title", "Hola Mundo Spring Boot");
        body_response.put("user", user_1);
        
        return body_response;
    }

}
