package com.myapi.controllers;

import com.myapi.services.TopicService;
import com.myapi.model.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Topic> getTopicById(@PathVariable String id)
    {
        try {
            Topic topic = topicService.getTopicById(id);
            return new ResponseEntity<Topic>(topic, HttpStatus.OK);
        }catch(Exception e){
            return ResponseEntity.notFound().build();
        }
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
