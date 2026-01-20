package com.example.luminaire_platform_api.controller;

import com.example.luminaire_platform_api.dto.LuminaireResponseDTO;
import com.example.luminaire_platform_api.service.LuminaireService;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/luminaire")
public class LuminaireController {

    private final LuminaireService service;

    public LuminaireController(LuminaireService service){
        this.service=service;
    }

    @GetMapping
    public List<LuminaireResponseDTO> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public LuminaireResponseDTO getById(@PathVariable Long id){
        return service.getById(id);
    }

    @PostMapping
    public LuminaireResponseDTO addLuminaire(@RequestParam @NotBlank @Size(min=2, message = "query must be at least 2 chatacters long")
                                             String queries){
        return service.addLuminaire(queries);
    }
}
