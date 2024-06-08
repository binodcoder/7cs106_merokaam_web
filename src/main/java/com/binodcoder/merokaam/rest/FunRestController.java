package main.java.com.binodcoder.merokaam.rest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class FunRestController {
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
