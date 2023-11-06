package com.ecommerce.backend.mapper;

import com.ecommerce.backend.dto.CategoriesDTO;
import com.ecommerce.backend.entities.Categories;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoryMapper extends MappingClass<Categories, CategoriesDTO> {
    // source is Getter exp. getCName()
    // target is field to mapper to modal
    @Mappings({
            @Mapping(source = "name", target = "categoryName"),
            @Mapping(expression = "java(c.getId().toString())" ,target = "id")
    })
    CategoriesDTO toDTO(Categories c);

}
