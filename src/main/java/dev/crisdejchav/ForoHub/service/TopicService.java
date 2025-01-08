package dev.crisdejchav.ForoHub.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.crisdejchav.ForoHub.dto.Topic.TopicDTO;
import dev.crisdejchav.ForoHub.dto.Topic.UpdateTopicDTO;
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

    public List<Topic> getAllTopics() {
        return topicRepository.findAll();
    }

    public Optional<Topic> getTopic(long topicId) {
        return topicRepository.findById(topicId);
    }

    public void deleteTopic(Long id) {
        topicRepository.deleteById(id);
    }

    public Optional<Topic> updateTopic(Long id, UpdateTopicDTO topic) {
        Optional<Topic> topicOptional = topicRepository.findById(id);
        if (topicOptional.isPresent()) {
            Topic topicToUpdate = topicOptional.get();
            topicToUpdate.updateTopic(topic);
            return Optional.of(topicRepository.save(topicToUpdate));
        } else {
            return Optional.empty();
        }
    }
}
