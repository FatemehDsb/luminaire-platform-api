package com.example.luminaire_platform_api.service;

import com.example.luminaire_platform_api.dto.LuminaireResponseDTO;
import com.example.luminaire_platform_api.model.Luminaire;
import com.example.luminaire_platform_api.repository.LuminaireRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LuminaireService {

    private final LuminaireRepository repository;
    
    public LuminaireService(LuminaireRepository repository){
        this.repository = repository;
    }

    public List<LuminaireResponseDTO> getAll(){

        List<Luminaire> luminairesList = repository.findAll();
        return
              luminairesList.stream()
                .map(this::toResponseDto)
                .toList();
    }


    //ToDTO
    public LuminaireResponseDTO toResponseDto(Luminaire luminaire){
        return new LuminaireResponseDTO(
                luminaire.getItemNumber(), luminaire.getType(), luminaire.getName());
    }

    //ToEntiry
}
