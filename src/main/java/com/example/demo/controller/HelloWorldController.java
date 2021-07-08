package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class HelloWorldController {

    String text ="";

//    @RequestMapping(value = "/greeting")
//    public String helloWorldController(@RequestParam(name = "name", required = false, defaultValue = "World!") String name, Model model) {
//        model.addAttribute("name", name);
//        return "greeting";
//    }

//        @RequestMapping()
    @PostMapping()
    public ResponseEntity postBody(@RequestBody(required = false)  String str, HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
//    public String postBody(@RequestBody(required = false)  String str, HttpServletRequest request) {
        System.out.println("POST "+str);
//        String text ="";

        StringBuffer ref = request.getRequestURL();
//        String baseUrl = ServletUriComponentsBuilder.fromRequestUri(request)
//                .replacePath(null)
//                .build()
//                .toUriString();

            text = "POST " + str + " " + " " + ref + "\n";
//        System.out.println(baseUrl);

//        if (str!=null) { text = text + str + " " + baseUrl + " " + ref + "\n"; model.addAttribute("str", text);}
//        else
            model.addAttribute("str", text);

        String tmp = "{\"device\" : \"1F2395A\",\"downlinkData\" : \"0101000000000000\"}";
//        model.addAttribute("str", tmp);
//        return "sample";
//        response.setContentType("application/json");
//        response.setCharacterEncoding("UTF-8");
//        response.getWriter().write(tmp);
        return new ResponseEntity (tmp, HttpStatus.OK);
    }

    //{"device" : "{device}","time" : "{time}","data" : "{data}","seqNumber" : "{seqNumber}","lqi" : "{lqi}","operatorName" : "{operatorName}"}

    @GetMapping()
    public String getBody(@RequestBody(required = false)  String str,Model model) {
        System.out.println("GET "+text);
//        model.addAttribute("str", str);
        text = text + "GET " + str + "\n";
        model.addAttribute("str", text);
        return "byby";
    }

}
