package dev.crisdejchav.ForoHub.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DashboardController {

    @GetMapping("/")
    public ResponseEntity<String> DashboardView() {
        return ResponseEntity.ok().body("Dashboard response");
    }
}
