package com.example.luminaire_platform_api.controller;

import com.example.luminaire_platform_api.dto.ManufacturerResponseDTO;
import com.example.luminaire_platform_api.service.ManufacturerService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Validated
@RestController
@RequestMapping("/manufacturer")
public class ManufacturerController {

    private final ManufacturerService service;

    public ManufacturerController(ManufacturerService service){
        this.service= service;
    }

    @GetMapping
    public List<ManufacturerResponseDTO> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ManufacturerResponseDTO getById(@PathVariable Long id){
        return service.getById(id);
    }







}

