package com.example.hellospringboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/printing")
    public String printing()  {
        return "Welcome to Darts-ip!";
    }

}
