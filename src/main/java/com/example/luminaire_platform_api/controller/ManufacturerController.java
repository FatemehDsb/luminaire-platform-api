package com.example.luminaire_platform_api.controller;

import com.example.luminaire_platform_api.service.ManufacturerService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("/luminaires")
public class ManufacturerController {

    private final ManufacturerService service;

    public ManufacturerController(ManufacturerService service){
        this.service= service;
    }




}

