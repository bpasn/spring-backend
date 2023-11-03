package com.ecommerce.backend.mapper;

import com.ecommerce.backend.dto.CategoriesDTO;
import com.ecommerce.backend.entity.Categories;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface CategoryMapper extends MappingClass<Categories, CategoriesDTO> {
    // source is Getter exp. getCName()
    // target is field to mapper to modal
    @Mappings({
            @Mapping(source = "name", target = "categoryName"),
    })
    CategoriesDTO toDTO(Categories categories);

    @Override
    @Mapping(source = "categoryName", target = "name")
    Categories toEntity(CategoriesDTO dto);

}
