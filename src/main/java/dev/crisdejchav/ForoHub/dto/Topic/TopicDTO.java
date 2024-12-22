package dev.crisdejchav.ForoHub.dto.Topic;

import dev.crisdejchav.ForoHub.model.Course;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TopicDTO(
    @NotBlank(message = "The title is required.")
    String title,
    @NotBlank(message = "The message is required.")
    String message,
    @NotBlank(message = "The author is required.")
    String author,
    @NotNull(message = "The course is required.")
    Course course
) {
    
}
