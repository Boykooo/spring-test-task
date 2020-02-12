package com.test.controller;

import com.test.dto.Crendentials;
import com.test.dto.RegisterData;
import com.test.dto.token.TokenHolder;
import com.test.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterData registerData) {
        TokenHolder th = userService.register(registerData);
        return ResponseEntity.ok(th);
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid Crendentials crendentials) {
        TokenHolder th = userService.login(crendentials);
        return ResponseEntity.ok(th);
    }

}
