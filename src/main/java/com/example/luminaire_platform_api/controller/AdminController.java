package com.example.luminaire_platform_api.controller;

import com.example.luminaire_platform_api.model.AppUser;
import com.example.luminaire_platform_api.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final UserService service;

    public AdminController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<AppUser>> getALlUsers(){
        return ResponseEntity.ok(service.getAllUsers());
    }
}
