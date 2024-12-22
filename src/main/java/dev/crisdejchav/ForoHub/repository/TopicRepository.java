package dev.crisdejchav.ForoHub.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import dev.crisdejchav.ForoHub.model.Topic;

public interface TopicRepository extends JpaRepository<Topic, Long> {
    Boolean existsByTitle(String title);
    Boolean existsByMessage(String message);

}