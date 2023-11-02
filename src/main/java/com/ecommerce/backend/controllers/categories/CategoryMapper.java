package com.ecommerce.backend.controllers.categories;

import org.mapstruct.Mapper;

import com.ecommerce.backend.entity.Categories;
import com.ecommerce.backend.mapper.MapperGeneric;

@Mapper(componentModel = "spring")
public interface CategoryMapper extends MapperGeneric<Categories,CategoriesDTO> {
    // source is Getter exp. getCName()
    // target is field to mapper to modal
    // @Mapping(source = "name", target = "categoryName")
    // CategoriesDTO entityToModal(Categories categories);
    // default List<CategoriesDTO> entityToModal(List<Categories> category) {
    //     return category.stream().map(this::entityToModal).collect(Collectors.toList());
    // };
}
