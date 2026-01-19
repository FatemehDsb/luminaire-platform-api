package com.example.luminaire_platform_api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name= "manufactures")
public class Manufacturer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String contactEmail;
    @OneToMany(mappedBy = "manufacturer" )
    @JsonBackReference
    private Set<Luminaire> luminaires;


    public Manufacturer(){

    }
    public Manufacturer(String name, String contactEmail ){
        this.name=name;
        this.contactEmail= contactEmail;
    }

    public Manufacturer(String name) {
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

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public Set<Luminaire> getLuminaires() {
        return luminaires;
    }

    public void setLuminaires(Set<Luminaire> luminaires) {
        this.luminaires = luminaires;
    }
}

