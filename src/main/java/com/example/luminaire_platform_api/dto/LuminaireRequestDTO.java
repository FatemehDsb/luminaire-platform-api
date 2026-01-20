package com.example.luminaire_platform_api.dto;

import com.example.luminaire_platform_api.model.Luminaire;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class LuminaireRequestDTO {
    @Valid
    @NotBlank(message = "itemNumber must be provided")
    @Size( min = 5, message = "itemNumber must contain at least 5 characters")
    private String itemNumber;

    @Valid
    @NotBlank(message = "type must be provided")
    @Size( min = 5, message = "type must contain at least 5 characters")
    private String type;

    @Valid
    @NotBlank(message = "name must be provided")
    @Size( min = 2, message = "name must contain at least 2 characters")
    private String name;

    public LuminaireRequestDTO(){
    }

    public LuminaireRequestDTO(String itemNumber, String type, String name) {
        this.itemNumber = itemNumber;
        this.type = type;
        this.name = name;
    }

    public String getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(String itemNumber) {
        this.itemNumber = itemNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
