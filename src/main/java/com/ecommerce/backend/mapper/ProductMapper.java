package com.ecommerce.backend.mapper;

import com.ecommerce.backend.dto.ProductDTO;
import com.ecommerce.backend.entities.Product;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper extends MappingClass<Product, ProductDTO> {

}
