package com.example.luminaire_platform_api.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
@Table(name = "luminaires")
public class Luminaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String itemNumber;
    private String name;
    private String type;

    // private String rating;

    @ManyToOne
    @JoinColumn(name= "manufacturer_id")
    @JsonManagedReference
    private Manufacturer manufacturer;

    public Luminaire(){}
    public Luminaire(String name, String type){
        this.name= name;
        this.type= type;

    }

    public Luminaire(String itemNumber, String name, String type, Manufacturer manufacturer) {
        this.itemNumber = itemNumber;
        this.name = name;
        this.type = type;
        this.manufacturer = manufacturer;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(String itemNumber) {
        this.itemNumber = itemNumber;
    }


}
