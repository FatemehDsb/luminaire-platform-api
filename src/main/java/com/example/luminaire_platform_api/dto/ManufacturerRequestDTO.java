package com.example.luminaire_platform_api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ManufacturerRequestDTO {

    @NotBlank(message = "name must be provided")
    @Size( min = 2, message = "name must contain at least 2 characters")
    private String name;

    private String country;
    private String websiteUrl;

    public ManufacturerRequestDTO() {
    }

    public ManufacturerRequestDTO(String name, String country, String websiteUrl) {
        this.name = name;
        this.country = country;
        this.websiteUrl = websiteUrl;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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
                ", country='" + country + '\'' +
                ", websiteUrl='" + websiteUrl + '\'' +
                '}';
    }
}
