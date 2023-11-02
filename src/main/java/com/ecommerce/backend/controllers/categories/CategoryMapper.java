package com.ecommerce.backend.controllers.categories;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

import com.ecommerce.backend.entity.Categories;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    // source is Getter exp. getCName()
    // target is field to mapper to modal
    @Mappings({
        @Mapping(source = "name", target = "categoryName"),
    })
    CategoriesDTO toDTO(Categories categories);

    @Mapping(source = "categoryName", target = "name")
    Categories toEntity(CategoriesDTO dto);

   
}
