package com.springboot.demo.myapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController  {
    @GetMapping("/")
    public String sayHello () {
        return  "Hello springboot...!";
    }

//     expose  a new endpoint for workout

    @GetMapping("/study")
    public String getDailyStudies() {
        return "Study more than yourself what you belive!";
    }

    @GetMapping("/well")
        public String getWellStudy() {
            return "Today hardwork pay tommorrow result";
        }
    }

