package com.example.luminaire_platform_api.repository;

import com.example.luminaire_platform_api.model.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManufacturerRepository extends JpaRepository<Manufacturer, Long> {

}
