package com.myfunapp.springboot.contoller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fun")
public class FunAppController {

    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    @GetMapping("/teamInfo")
    public String getTeamInfo(){
        return "coach name is " +coachName +"team name " +teamName;
    }

    @GetMapping("")
    public String sayHello(){
        return "Hello Fun App";
    }

    @GetMapping("/workout")
    public String dailyWorkOut(){
        return "Run for 5k today";
    }

    @GetMapping("/fortune")
    public String fortuneOfToday(){
        return "today is your lucky day";
    }
}
