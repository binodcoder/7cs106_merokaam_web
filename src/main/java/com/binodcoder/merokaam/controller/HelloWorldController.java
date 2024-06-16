package com.binodcoder.merokaam.controller;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {
    // new a controller method to show initial HTML form

    @RequestMapping("/showForm")
    public String showForm(){
        return "helloworld-form";
    }

    // need a controller method to process the HTML form


    @RequestMapping("/processForm")
    public String processForm(){
        return "helloworld";
    }

    //need a controller method to read form data and
    // add data to the model
    @RequestMapping("/processFormVersionTwo")
    public String letsShoutDude(HttpServletRequest request, Model model){
        //read the request parameter from the HTML form
        String theName=request.getParameter("studentName");

        //convert the data to all caps
        theName=theName.toUpperCase();

        //create the message
        String result="Yo! "+theName;

        //add message to the Model
        model.addAttribute("message", result);

        return "helloworld";

    }

    @RequestMapping("/processFormVersionThree")
    public String makeUpperCase(
            @RequestParam("studentName") String theName,
            Model model
    ){
        // now we can use the variable theName
        //convert the data to all caps
        theName=theName.toUpperCase();

        //create the message
        String result="Yo! "+theName;

        //add message to the Model
        model.addAttribute("message", result);

        return "helloworld";
    }
}
