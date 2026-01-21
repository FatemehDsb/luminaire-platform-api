package com.example.luminaire_platform_api.repository;

import com.example.luminaire_platform_api.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<AppUser, Long> {

    public Optional<AppUser> findByUsername(String name);
}
