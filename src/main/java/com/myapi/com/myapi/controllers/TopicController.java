package com.myapi.com.myapi.controllers;

import com.myapi.com.myapi.com.myapi.services.TopicService;
import com.myapi.com.myapi.model.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Lakshmi on 6/13/2018.
 */
@RestController
public class TopicController {

    @Autowired
    private TopicService topicService;

    @RequestMapping("/topics")
    public List<Topic> getAllTopics(){
        return topicService.getTopics();
    }

    @RequestMapping("/topics/{id}")
    public Topic getTopicById(@PathVariable String id){
        return topicService.getTopicById(id);
    }

    @RequestMapping(method= RequestMethod.POST, value="/topics")
    public void addTopic(@RequestBody Topic topic){

        topicService.addTopic(topic);
    }

    @RequestMapping(method=RequestMethod.PUT, value="/topics")
    public void updateTopic(@RequestBody Topic topic){
        topicService.updateTopic(topic);
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/topics/{id}")
    public void deleteTopic(@PathVariable  String id){
        topicService.deleteTopic(id);
    }
}
