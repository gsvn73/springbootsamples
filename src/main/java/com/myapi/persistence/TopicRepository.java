package com.myapi.persistence;

import com.myapi.model.Topic;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Lakshmi on 6/16/2018.
 */
public interface TopicRepository extends CrudRepository<Topic, String> {

}
