package com.springboot.webapp.springbootweb.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.webapp.springbootweb.models.User;
import com.springboot.webapp.springbootweb.models.dto.VarDto;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/var")
public class PathVariableController {

    @Value("${config.username}") //@Value sirve para inyectar datos desde un archivo ".properties"
    private String username;

    @Value("${config.message}")
    private String message;

    @Value("${config.code}")
    private Integer code;

    @Value("${config.listOfValues}")
    private String[] listOfValues;

    @Autowired
    private Environment environment;
    
    @GetMapping("/baz/{datos}")
    public VarDto baz(@PathVariable String datos) {
        
        VarDto varDto = new VarDto();
        varDto.setVar(datos);

        return varDto;
    }

    /*
     * Parar multiples @PathVariable
     */
     @GetMapping("/mix/{product}/{id}")
     public Map<String, Object> mixPath(@PathVariable String product, @PathVariable Long id) {
         Map<String, Object> json = new HashMap<>();

         json.put("product", product);
         json.put("id", id);

         return json;
     }
     
     /*
      * Recibe un JSON
      */
      @PostMapping("/create")
      public User createUser(@RequestBody User user) {
          // Hacer algo con el usuario, por ejemplo persistirlo en la base de datos
          return user;
      }

      /*
       * Inyectar datos del archivo de configuraciones
       */
      @GetMapping("/values")
      public Map<String, Object> values(){
        Map<String, Object> map = new HashMap<>();
        map.put("user", username);
        map.put("code", code);
        map.put("message", message);
        map.put("message_environment", environment.getProperty("config.message"));
        map.put("listOfValues", listOfValues);
        return map;
      }
      
}
