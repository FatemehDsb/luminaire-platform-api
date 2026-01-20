package com.example.luminaire_platform_api.controller;

import com.example.luminaire_platform_api.dto.LuminaireResponseDTO;
import com.example.luminaire_platform_api.service.LuminaireService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Validated
@RestController
@RequestMapping("/luminare")
public class LuminaireController {

    private final LuminaireService service;

    public LuminaireController(LuminaireService service){
        this.service=service;
    }

    @GetMapping
    public List<LuminaireResponseDTO> getAll(){
        return service.getAll();
    }
}
