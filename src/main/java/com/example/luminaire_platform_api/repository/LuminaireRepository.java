package com.example.luminaire_platform_api.repository;

import com.example.luminaire_platform_api.model.Luminaire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LuminaireRepository extends JpaRepository<Luminaire, Long> {
}
