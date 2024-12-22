package dev.crisdejchav.ForoHub.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.crisdejchav.ForoHub.configurations.security.JWTToken;
import dev.crisdejchav.ForoHub.configurations.security.TokenService;
import dev.crisdejchav.ForoHub.dto.User.UserLoginDTO;
import dev.crisdejchav.ForoHub.model.User;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/auth")
@Tag(name = "Auth", description = "Endpoints for authentication")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<?> loginRequest(@RequestBody @Valid UserLoginDTO request) {
         try {
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                    request.email(),
                    request.password()
            );
            Authentication authenticatedUser = authenticationManager.authenticate(authenticationToken);
            var JWTtoken = tokenService.generateToken((User) authenticatedUser.getPrincipal());
            return ResponseEntity.ok(new JWTToken(JWTtoken));
        } catch (AuthenticationException e) {
            return ResponseEntity.status(401).body("Authentication failed");
        }
    }
    
}
