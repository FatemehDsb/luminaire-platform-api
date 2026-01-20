package com.example.luminaire_platform_api.repository;

import com.example.luminaire_platform_api.dto.ManufacturerResponseDTO;
import com.example.luminaire_platform_api.model.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ManufacturerRepository extends JpaRepository<Manufacturer, Long> {
    boolean existsByNameIgnoreCase(String name);
    List<Manufacturer> searchByName(@Param("keyword") String name);

}
