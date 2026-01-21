package com.example.luminaire_platform_api.controller;

import com.example.luminaire_platform_api.service.CustomUserDetailService;
import com.example.luminaire_platform_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authentication")
public class AuthController {

    @Value("${app.welcome-message}")
    String message;
    Service service;

//    private final AuthenticationManager authenticationManager;
//    private final CustomUserDetailService customUserDetailService;
//



}
