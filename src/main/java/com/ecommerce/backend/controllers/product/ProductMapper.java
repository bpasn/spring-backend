package com.ecommerce.backend.controllers.product;

import org.mapstruct.Mapper;

import com.ecommerce.backend.mapper.MapperGeneric;

@Mapper(componentModel = "spring")
public interface ProductMapper<Entity,DTO> extends MapperGeneric<Entity,DTO>{
    
}
