package com.shovon.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class cc {
    @GetMapping("/hello")
    public String dude(Principal principal){
        if(principal != null) System.out.println(principal.getName());
        return "hello";
    }
}
