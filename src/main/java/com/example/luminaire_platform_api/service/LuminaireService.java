package com.example.luminaire_platform_api.service;

import com.example.luminaire_platform_api.dto.LuminaireRequestDTO;
import com.example.luminaire_platform_api.dto.LuminaireResponseDTO;
import com.example.luminaire_platform_api.dto.ManufacturerRequestDTO;
import com.example.luminaire_platform_api.exception.BadRequestException;
import com.example.luminaire_platform_api.exception.ResourceNotFoundException;
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

    public LuminaireResponseDTO getById(Long id){
       Luminaire luminaire= repository.findById(id)
               .orElseThrow(()-> new ResourceNotFoundException(
                       "Luminaire not found with this id " + id));
       return toResponseDto(luminaire);
    }

    public LuminaireResponseDTO addLuminaire(LuminaireRequestDTO requestDTO) throws BadRequestException {
        if(repository.existsByNameIgnoreCase(requestDTO.getName())){
            throw new BadRequestException("Luminaire already exist");
        }
        Luminaire luminaire = repository.save(toEntity(requestDTO));
       return toResponseDto(luminaire);
    }



    //ToDTO
    public LuminaireResponseDTO toResponseDto(Luminaire luminaire){
        return new LuminaireResponseDTO(
                luminaire.getItemNumber(), luminaire.getType(), luminaire.getName());
    }

    //ToEntity

    public Luminaire toEntity(LuminaireRequestDTO luminaireRequestDTO){
        return new Luminaire(luminaireRequestDTO.getName(), luminaireRequestDTO.getType(), luminaireRequestDTO.getItemNumber(), luminaireRequestDTO.getManufacturer());
    }
}
