package com.myapi.com.myapi.controllers;

import com.myapi.com.myapi.model.Topic;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Lakshmi on 6/13/2018.
 */
@RestController
public class TopicController {

    @RequestMapping("/topics")
    public List<Topic> getAllTopics(){
        return Arrays.asList(Topic.builder().id("SB").name("SpringBootApplication").description("Spring Boot Description").build(),
                Topic.builder().id("Java").name("Java 8").description("Java 8 Tutorial").build());
    }
}
