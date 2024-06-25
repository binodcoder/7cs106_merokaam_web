package com.binodcoder.merokaam.rest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api")
public class FunRestController {
    //inject properties for: app.name and team.name

    @Value("${app.name}")
    private String appName;

    @Value("${team.name}")
    private String teamName;

    @GetMapping("/appinfo")
    public  String getAppInfo(){
        return teamName;
    }
    //expose "/" that return "hello world"
    @GetMapping("/")
    public String sayHello(){
        return "Hello Worldbbb";
    }

    //expose a new endpoint for "workout"

    @GetMapping("/workout")
    public String getDailyWorkout(){
        return "Run a hard 5K! ";
    }

    //expose a new end point for "fortune"

    @GetMapping("/fortune")
    public String getDailyFortune(){
        return "Today is your lucky day";
    }
}
