package com.springboot.webapp.springbootweb.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.webapp.springbootweb.models.dto.ParamDto;

import jakarta.servlet.http.HttpServletRequest;;

@RestController
@RequestMapping("/api/params")
public class RequestParamsController {
    
    @GetMapping("/foo")
    public ParamDto foo(@RequestParam(name = "msg", required = false, defaultValue = "Mensaje por default") String message) {
        ParamDto params = new ParamDto();
        params.setMessage(message);

        return params;
    }

    @GetMapping("/bar")
    public ParamDto bar(@RequestParam(required = false) String text, 
                        @RequestParam(required = false) Integer code) {
    
        ParamDto params = new ParamDto(code, text);

        return params;
    }

    /*
     * Otra forma de obtener los parametros de la peticion 
     * es con el objeto "HttpServletRequest"
     */
    @GetMapping("/request")
    public ParamDto reguest(HttpServletRequest request) {
        Integer code = 0;
        try {
            code = Integer.parseInt(request.getParameter("code")); //obtiene el parametro code y lo pasa a Integer
        } catch (NumberFormatException e) {
            System.err.println("Error: " + e);
        }
        String message = request.getParameter("message");
        ParamDto params = new ParamDto(code, message);
        return params;
    }
    
}
