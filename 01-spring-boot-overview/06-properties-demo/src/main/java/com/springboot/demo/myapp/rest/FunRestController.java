package com.springboot.demo.myapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController  {

//    Custom own properties
    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    @Value("${place.name}")
    private String placeName;

    @GetMapping("/teamInfo")
    public  String getTeamInfo() {
        return  "Coach: " + coachName + ", Team name: " + teamName + ", place: " + placeName ;
    }
    @GetMapping("/")
    public String sayHello () {
        return  "Hello springBoot...!";
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

