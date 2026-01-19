package com.example.luminaire_platform_api.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ManufacturerRequestDTO {

    @Valid
    @NotBlank(message = "name must be provided")
    @Size( min = 2, message = "name must contain at least 2 characters")
    private String name;


    public ManufacturerRequestDTO() {
    }

    public ManufacturerRequestDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ManufacturerRequestDTO{" +
                "name='" + name + '\'' +
                '}';
    }
}
