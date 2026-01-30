package com.example.luminaire_platform_api.controller;

import com.example.luminaire_platform_api.dto.LoginRequestDTO;
import com.example.luminaire_platform_api.security.JwtService;
import com.example.luminaire_platform_api.service.CustomUserDetailService;
import com.example.luminaire_platform_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authentication")
public class AuthController {

    @Value("${app.welcome-message}")
    String message;
    Service service;

    private final AuthenticationManager authenticationManager;
    private final CustomUserDetailService UserdetailService;

    private final JwtService jwtService;

    public AuthController( Service service, AuthenticationManager authenticationManager, CustomUserDetailService userDetailService, JwtService jwtService){
        this.service = service;
        this.authenticationManager = authenticationManager;
        UserdetailService = userDetailService;
        this.jwtService = jwtService;
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDTO loginRequestDTO){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequestDTO.getName(),
                        loginRequestDTO.getPassword()
                )
        );
        UserDetails user = UserdetailService.loadUserByUsername(loginRequestDTO.getName());
        String token = jwtService.generateToken(user);
        return  ResponseEntity.ok(token);
    }


}
