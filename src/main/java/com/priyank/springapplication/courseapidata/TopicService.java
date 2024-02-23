package com.priyank.springapplication.courseapidata;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    public List<Topic> getAllTopics() {
        List<Topic> topics = new ArrayList<>();
        topicRepository.findAll()
                .forEach(topics::add);
        return topics;
    }

    public Topic getTopic(String id) {
        return topicRepository.findById(id).orElse(null);
    }

    public void addTopic(Topic topic) {
        topicRepository.save(topic);
    }

    public void updateTopic(String id, Topic topic) {
        Topic existingTopic = topicRepository.findById(id).orElse(null);

        existingTopic.setName(topic.getName());
        existingTopic.setDescription(topic.getDescription());

        topicRepository.save(existingTopic);
    }

    public void deleteTopic(String id) {
        topicRepository.deleteById(id);
    }
}
