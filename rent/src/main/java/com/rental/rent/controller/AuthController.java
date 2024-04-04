package com.rental.rent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.rental.rent.dto.AuthRequest;
import com.rental.rent.dto.AuthResponse;
import com.rental.rent.dto.RegisterRequest;
import com.rental.rent.entity.User;
import com.rental.rent.service.AuthService;

@Controller
public class AuthController {

     @Autowired
    AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<User> register(
            @RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(
            @RequestBody AuthRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

    
}
