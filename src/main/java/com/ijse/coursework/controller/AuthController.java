package com.ijse.coursework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ijse.coursework.dto.LoginDto;
import com.ijse.coursework.security.jwt.JwtUtils;

@RestController
@CrossOrigin(origins = "*")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping("/auth/login")
    public ResponseEntity<String> login(@RequestBody LoginDto login) {

        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwtToken = jwtUtils.generateJwtToken(authentication);

        return ResponseEntity.status(200).body(jwtToken);
    }
}
