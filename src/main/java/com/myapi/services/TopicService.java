package com.myapi.services;

import com.myapi.model.Topic;
import com.myapi.persistence.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Created by Lakshmi on 6/14/2018.
 */
@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    private List<Topic> topics = new ArrayList<>( Arrays.asList(Topic.builder().id("SB").name("SpringBootApplication").description("Spring Boot Description").build(),
                Topic.builder().id("Java").name("Java 8").description("Java 8 Tutorial").build()));

    public List<Topic> getTopics() {
        List<Topic> allTopics = new ArrayList<>();
        topicRepository.findAll().forEach(allTopics::add);
        return allTopics;
    }

    public Topic getTopicById(String id) throws Exception{
        Optional<Topic> topic = topicRepository.findById(id);
        if (topic.isPresent()){
            return topic.get();
        }else{
            throw new Exception("Not found");
        }
        //return topics.stream().filter(a->a.getId().equals(id)).findFirst().get();
    }

    public void addTopic(Topic topic){
        topicRepository.save(topic);
    }

    public void updateTopic(Topic topic) {
//        for(int i =0; i<topics.size(); i++){
//            if(topics.get(i).getId().equals(topic.getId())){
//                topics.set(i, topic);
//            }
//        }
        topicRepository.save(topic);
    }

    public void deleteTopic(String topicId){
        //topics.removeIf(t->t.getId().equals(topicId));
        topicRepository.deleteById(topicId);
    }
}
