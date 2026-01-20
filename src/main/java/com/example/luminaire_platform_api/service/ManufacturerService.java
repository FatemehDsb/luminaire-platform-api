package com.example.luminaire_platform_api.service;

import com.example.luminaire_platform_api.dto.ManufacturerRequestDTO;
import com.example.luminaire_platform_api.dto.ManufacturerResponseDTO;
import com.example.luminaire_platform_api.exception.ResourceNotFoundException;
import com.example.luminaire_platform_api.model.Manufacturer;
import com.example.luminaire_platform_api.repository.ManufacturerRepository;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManufacturerService {

    private final ManufacturerRepository repository;

    public ManufacturerService(ManufacturerRepository repository){
        this.repository = repository;
    }

    public List<ManufacturerResponseDTO> getAll(){
        List<Manufacturer> manufacturerList = repository.findAll();
        ManufacturerResponseDTO manufacturerResponseDTO ;
        return
                manufacturerList
                        .stream()
                        .map(this::toResponseDTO)
                        .toList();
    }

    public ManufacturerResponseDTO getById(Long id){
        Manufacturer manufacturer = repository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException(
                        "Manufacturer not found with id" + id));
        return  toResponseDTO(manufacturer);
    }

    public ManufacturerResponseDTO addManufacturer(ManufacturerRequestDTO requestDTO) throws BadRequestException {
        if (repository.existsByNameIgnoreCase(requestDTO.getName())) {
            throw new BadRequestException("Manufacturer already exists");
        }
        Manufacturer manufacturer = repository.save(toEntity(requestDTO));
                return toResponseDTO(manufacturer);
    }

    public List<ManufacturerResponseDTO> searchByName(String name){
        return repository.searchByName(name)
                .stream()
                .map(this::toResponseDTO)
                .toList();
    }

    //DTO TO ENTITY
    public Manufacturer toEntity(ManufacturerRequestDTO manufacturerRequestDTO){
        return new Manufacturer(manufacturerRequestDTO.getName());
    }

    //ENTITY TO DTO
    public ManufacturerResponseDTO toResponseDTO(Manufacturer manufacturer){
        return new ManufacturerResponseDTO(manufacturer.getName());
    }
}
