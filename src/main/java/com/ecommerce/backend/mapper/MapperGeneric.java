package com.ecommerce.backend.mapper;


public interface MapperGeneric<Entity , DTO> {
    DTO toDTO(Entity e);
    Entity toEntity(DTO d);
}
