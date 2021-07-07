package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HelloWorldController {

    String text ="";
//    @RequestMapping(value = "/greeting")
//    public String helloWorldController(@RequestParam(name = "name", required = false, defaultValue = "World!") String name, Model model) {
//        model.addAttribute("name", name);
//        return "greeting";
//    }

        @RequestMapping()
//    @PostMapping()
    public String postBody(@RequestBody(required = false)  String str, HttpServletRequest request, Model model) {
//    public String postBody(@RequestBody(required = false)  String str, HttpServletRequest request) {
        //System.out.println(str);

        String ref = request.getRequestURI();
        String baseUrl = ServletUriComponentsBuilder.fromRequestUri(request)
                .replacePath(null)
                .build()
                .toUriString();


//        System.out.println(baseUrl);

        if (str!=null) { text = text + str + " " + baseUrl + " " + ref + "\n"; model.addAttribute("str", text);}
        else model.addAttribute("str", "EMPTY");
        return "sample";
        //return new ResponseEntity<String>("Ok", HttpStatus.OK);
    }

    //{"device" : "{device}","time" : "{time}","data" : "{data}","seqNumber" : "{seqNumber}","lqi" : "{lqi}","operatorName" : "{operatorName}"}

    @GetMapping()
    public String getBody(@RequestBody(required = false) String str, Model model) {
        //System.out.println(str);
        model.addAttribute("str", str);
//        model.addAttribute("str", text);
        return "byby";
    }

}
