package dev.crisdejchav.ForoHub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.crisdejchav.ForoHub.dto.Topic.TopicDTO;
import dev.crisdejchav.ForoHub.model.Topic;
import dev.crisdejchav.ForoHub.repository.TopicRepository;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;
    
    public Topic createTopic(TopicDTO topic) {
        if(topicRepository.existsByTitle(topic.title()) || topicRepository.existsByMessage(topic.message())) {
            throw new IllegalArgumentException("Topic already exists");
        }
        return topicRepository.save(new Topic(topic));
    }
}
