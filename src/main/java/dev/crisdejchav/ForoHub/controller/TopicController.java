package dev.crisdejchav.ForoHub.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.crisdejchav.ForoHub.dto.Topic.TopicDTO;
import dev.crisdejchav.ForoHub.dto.Topic.UpdateTopicDTO;
import dev.crisdejchav.ForoHub.model.Topic;
import dev.crisdejchav.ForoHub.service.TopicService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("api/topics")
public class TopicController {

    @Autowired
    private TopicService topicService;

    @GetMapping
    public List<Topic> getAllPosts() {
        return topicService.getAllTopics();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Topic> getPostById(@PathVariable Long id) {
        Optional<Topic> topic = topicService.getTopic(id);
        if (topic.isPresent()) {
            return ResponseEntity.ok(topic.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Topic createPost(@RequestBody TopicDTO topic) {
        return topicService.createTopic(topic);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePostById(@PathVariable Long id) {
        topicService.deleteTopic(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Topic> updatePostById(@PathVariable Long id, @RequestBody UpdateTopicDTO topic) {
        Optional<Topic> updatedTopic = topicService.updateTopic(id, topic);
        if (updatedTopic.isPresent()) {
            return ResponseEntity.ok(updatedTopic.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    
}
