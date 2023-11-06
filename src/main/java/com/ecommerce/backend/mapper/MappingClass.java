package com.ecommerce.backend.mapper;

import org.mapstruct.control.NoComplexMapping;

@NoComplexMapping
public interface MappingClass<E,D> {
//    E toEntity(D d);
    D toDTO(E e);
}
