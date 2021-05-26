package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloWorldController {

//    @RequestMapping(value = "/greeting")
//    public String helloWorldController(@RequestParam(name = "name", required = false, defaultValue = "World!") String name, Model model) {
//        model.addAttribute("name", name);
//        return "greeting";
//    }

    @RequestMapping()
//    @PostMapping()
    public String postBody(@RequestBody(required = false) String str, Model model) {
        //System.out.println(str);
        if (str!=null) model.addAttribute("str", str);
        else model.addAttribute("str", "EMPTY");
        return "sample";
    }

//    @GetMapping()
//    public String getBody(@RequestBody(required = false) String str, Model model) {
//        System.out.println(str);
//        if (str!=null) model.addAttribute("str", str);
//        else model.addAttribute("str", "EMPTY");
//        return "sample";
//    }

}
