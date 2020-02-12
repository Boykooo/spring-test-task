package com.test.controller;

import com.test.security.CurrentUser;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
@RequiredArgsConstructor
public class TestAuthController {

    private final CurrentUser currentUser;

    @GetMapping
    public ResponseEntity test() {
        return ResponseEntity.ok(currentUser.getLogin());
    }

}
