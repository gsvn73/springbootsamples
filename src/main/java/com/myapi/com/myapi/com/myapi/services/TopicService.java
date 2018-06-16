package com.myapi.com.myapi.com.myapi.services;

import com.myapi.com.myapi.model.Topic;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Lakshmi on 6/14/2018.
 */
@Service
public class TopicService {

    private List<Topic> topics = new ArrayList<>( Arrays.asList(Topic.builder().id("SB").name("SpringBootApplication").description("Spring Boot Description").build(),
                Topic.builder().id("Java").name("Java 8").description("Java 8 Tutorial").build()));

    public List<Topic> getTopics() {
        return topics;
    }

    public Topic getTopicById(String id){
        return topics.stream().filter(a->a.getId().equals(id)).findFirst().get();
    }

    public void addTopic(Topic topic){
        topics.add(topic);
    }

    public void updateTopic(Topic topic) {
        for(int i =0; i<topics.size(); i++){
            if(topics.get(i).getId().equals(topic.getId())){
                topics.set(i, topic);
            }
        }
    }

    public void deleteTopic(String topicId){
        topics.removeIf(t->t.getId().equals(topicId));
    }
}
