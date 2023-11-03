package com.ecommerce.backend.interfaces;

import java.util.List;

public interface IGenericService<Entity,DTO> {
    
   
    List<Entity> getAll();
    Entity getById(Integer id);

    List<DTO> getAllToDto();
    DTO getByIdToDto(Integer id);
    Entity create(Entity entity);

    Entity update(Entity e);
    void delete(Entity e);
    void deleteById(Integer id);

    long count();
}
