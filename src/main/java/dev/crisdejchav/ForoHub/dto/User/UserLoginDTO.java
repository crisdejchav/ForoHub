package dev.crisdejchav.ForoHub.dto.User;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserLoginDTO(
    @NotBlank(message = "email is required")
    @Email(message = "email is invalid")
    String email,
    @NotBlank(message = "password is required")
    @Size(min = 6, max = 300, message = "password must be at least 6 characters long and no more than 300")
    String password
) {

}
