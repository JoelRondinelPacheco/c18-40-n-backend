package com.example.demo.services;

public interface DtoMapper<DTO, ENTITY> {
    DTO entityToDTO(ENTITY entity);
    ENTITY dtoToEntity(DTO dto);
}
