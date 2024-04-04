package com.rental.rent.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.rental.rent.dto.AuthRequest;
import com.rental.rent.dto.AuthResponse;
import com.rental.rent.dto.RegisterRequest;
import com.rental.rent.entity.User;
import com.rental.rent.enums.Role;
import com.rental.rent.repository.UserRepository;

@Service
public class AuthService {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthenticationManager authenticationManager;

    public User register(RegisterRequest request) {
        if (request.getRole() == null) {
            request.setRole(Role.USER);
        }

        User user = new User();
        try{
            user.setEmail(request.getEmail());
        user.setName(request.getName());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(request.getRole());
        userRepository.save(user);
        }catch(Exception e){
            System.out.println(e);
        }
       

        return user;

    }

    public AuthResponse login(AuthRequest request) {
    
            authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(), request.getPassword()));
                
        return new AuthResponse("Successfull login"); // Fixed code
    }

}

