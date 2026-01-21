package com.example.luminaire_platform_api.service;

import com.example.luminaire_platform_api.model.AppUser;
import com.example.luminaire_platform_api.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository){
        this.repository = repository;
    }
    public List<AppUser> getAllUsers(){
        return repository.findAll();

    }
}
