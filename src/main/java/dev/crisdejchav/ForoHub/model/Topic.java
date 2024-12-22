package dev.crisdejchav.ForoHub.model;

import java.time.LocalDateTime;

import dev.crisdejchav.ForoHub.dto.Topic.TopicDTO;
import dev.crisdejchav.ForoHub.dto.Topic.UpdateTopicDTO;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "topics")
@Entity(name = "Topic")
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Getter
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String message;
    private LocalDateTime creationDate;
    private boolean status;
    private String author;
    @Enumerated(EnumType.STRING) @Column(name = "curse")
    private Course course;

    public Topic(TopicDTO topicDTO) {
        this.title = topicDTO.title();
        this.message = topicDTO.message();
        this.creationDate = createDate();
        this.status = true;
        this.author = topicDTO.author();
        this.course = topicDTO.course();
    }

    public Topic() {
    }

    public LocalDateTime createDate() {
        return LocalDateTime.now();
    }

    public void updateTopic(UpdateTopicDTO updateTopicDTO) {
        this.title = updateTopicDTO.title();
        this.message = updateTopicDTO.message();
    }

 

    public void deactivateTopic() {
        this.status = false;
    }
}