package com.ecommerce.backend.controllers.categories;

import com.ecommerce.backend.entity.Categories;
import org.mapstruct.Mapper;

import org.mapstruct.Mapping;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    // source is Getter exp. getCName()
    // target is field to mapper to modal
    @Mapping(source = "name", target = "categoryName")
    CategoriesDTO entityToModal(Categories categories);
    default List<CategoriesDTO> entityToModal(List<Categories> category) {
        return category.stream().map(this::entityToModal).collect(Collectors.toList());
    };
}
