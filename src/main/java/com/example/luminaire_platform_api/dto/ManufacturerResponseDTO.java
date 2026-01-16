package com.example.luminaire_platform_api.dto;

public class ManufacturerResponseDTO {

    private Long id;
    private String name;;

    public ManufacturerResponseDTO() {
    }

    public ManufacturerResponseDTO( String name) {
        this.name = name;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "ManufacturerResponseDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
