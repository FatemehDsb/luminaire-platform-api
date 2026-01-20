package com.example.luminaire_platform_api.controller;

import com.example.luminaire_platform_api.dto.ManufacturerRequestDTO;
import com.example.luminaire_platform_api.dto.ManufacturerResponseDTO;
import com.example.luminaire_platform_api.service.ManufacturerService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.apache.coyote.BadRequestException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/search")
    public List<ManufacturerResponseDTO> searchManufacturer(@RequestParam
                                                            @NotBlank
                                                            @Size(min=2, message= "query must be at least 2 characters long")
                                                            String query){
        return service.searchByName(query);
    }

    @PostMapping
    public ManufacturerResponseDTO addManufacturer(@Valid @RequestBody ManufacturerRequestDTO requestDTO) throws BadRequestException {
        return service.addManufacturer(requestDTO);
    }







}

