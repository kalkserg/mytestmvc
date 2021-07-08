package com.example.demo.controller;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class HelloWorldController {

    String messageIn ="";
    String messageOut ="";

//    @RequestMapping(value = "/greeting")
//    public String helloWorldController(@RequestParam(name = "name", required = false, defaultValue = "World!") String name, Model model) {
//        model.addAttribute("name", name);
//        return "greeting";
//    }

    //        @RequestMapping()
    @PostMapping(produces = "application/json")
    public ResponseEntity<String> postBody(@RequestBody(required = false)  String str, HttpServletRequest request, HttpServletResponse response, Model model) throws IOException, JSONException {
//    public String postBody(@RequestBody(required = false)  String str, HttpServletRequest request) {
        //System.out.println("POST "+str);
//        String text ="";

        //StringBuffer ref = request.getRequestURL();
//        String baseUrl = ServletUriComponentsBuilder.fromRequestUri(request)
//                .replacePath(null)
//                .build()
//                .toUriString();

        // text = "POST " + str + " " + " " + ref + "\n";
//        System.out.println(baseUrl);

//        if (str!=null) { text = text + str + " " + baseUrl + " " + ref + "\n"; model.addAttribute("str", text);}
//        else
//            model.addAttribute("str", text);
        messageIn = messageIn + str;
        messageOut = "{\"device\" : \"1F2395A\",\"data\" : \"0101000000000001\"}";
//        String text = "{ \"1F2395A\": {\"downlinkData\" : \"0101000000000000\" }}";
//        model.addAttribute("str", tmp);
//        PrintWriter out = response.getWriter();
//        response.setContentType("application/json");
//        response.setCharacterEncoding("UTF-8");
//        out.print(messageOut);
//        out.flush();

//        return "sample";
//        response.setContentType("application/json");
//        response.setCharacterEncoding("UTF-8");
//        response.getWriter().write(tmp);

//        return out;
        JSONObject resp = new JSONObject();
        resp.put("device", "1F2395A");
        resp.put("data", "0101000000000001");

        return new ResponseEntity<String>(resp.toString(), HttpStatus.CREATED);
        //return new ResponseEntity<String>( messageOut, HttpStatus.OK);
    }

    //{"device" : "{device}","time" : "{time}","data" : "{data}","seqNumber" : "{seqNumber}","lqi" : "{lqi}","operatorName" : "{operatorName}"}

    @GetMapping()
    public String getBody(@RequestBody(required = false)  String str, Model model) {
        System.out.println("GET "+ messageIn);
        System.out.println("GET "+ messageOut);
//        model.addAttribute("str", str);
//        text = text + "GET " + str + "\n";
        model.addAttribute("str", messageIn + messageOut);
        return "byby";
    }

}
