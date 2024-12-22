package dev.crisdejchav.ForoHub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.crisdejchav.ForoHub.dto.User.UserDTO;
import dev.crisdejchav.ForoHub.model.User;
import dev.crisdejchav.ForoHub.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Tag(name = "User", description = "Endpoints for user management")
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    /**   
     * Register a new user
     * @param user UserDTO user to be registered
     * @return ResponseEntity<User>  Returns the registered user

    */

    @Operation(summary = "Register a new user", description = "Register a new user")
    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@Parameter(description = "User object to be registered", required = true) @Valid @RequestBody UserDTO user) {
        User newUser = userService.registerUser(user);
        System.out.println("User registered");
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }
    

}
