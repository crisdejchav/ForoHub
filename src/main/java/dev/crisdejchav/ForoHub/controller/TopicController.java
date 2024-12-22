package dev.crisdejchav.ForoHub.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import dev.crisdejchav.ForoHub.dto.Topic.TopicDTO;
import dev.crisdejchav.ForoHub.model.Topic;
import dev.crisdejchav.ForoHub.service.TopicService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/topic")
public class TopicController {

    @Autowired
    private TopicService TopicService;

    @PostMapping
    public ResponseEntity<?> newTopic(@RequestBody @Valid TopicDTO topic, UriComponentsBuilder uri) {
        
        Topic newTopic = TopicService.createTopic(topic);

        UriComponentsBuilder uriBuilder = uri.path("/topic/{id}");
        URI url = uriBuilder.path("/topics/{id}").buildAndExpand(newTopic.getId()).toUri();
        return ResponseEntity.created(url).body(url);
    }
}
