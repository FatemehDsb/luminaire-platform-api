package com.example.luminaire_platform_api.dto;

public class LuminaireResponseDTO {

    private String itemNumber;
    private String type;
    private String name;

    public LuminaireResponseDTO(String itemNumber, String type, String name) {
        this.itemNumber = itemNumber;
        this.type = type;
        this.name = name;
    }

    public LuminaireResponseDTO() {
    }

    public String getItemNumber() {
        return itemNumber;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }
}
