package com.myapi.com.myapi.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Lakshmi on 6/13/2018.
 */
@RestController
public class HelloWorldController {

    @RequestMapping("/hello")
    public String sayHi(){
        return "HI";
    }
}
