package com.ecommerce.backend.interfaces;

import java.util.List;

import com.ecommerce.backend.dto.DataTableDTO;

public interface IGenericService<Entity,DTO> {
    
   
    List<Entity> getAll();
    Entity getById(Integer id);
    Entity getByName(String name);

    List<DTO> getAllToDto();
    DTO getByIdToDto(Integer id);
    void delete(Entity e);
    void deleteById(Integer id);
    boolean existsByName(String name);
    long count();

    DataTableDTO<DTO> getDataTable(
        Integer page,
        Integer pageSize
    );
    
}
