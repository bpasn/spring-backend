package com.firstApp.firstApp.controllers.categories;

import org.mapstruct.Mapper;

import com.firstApp.firstApp.entity.CategoryEntity;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    // source is Getter exp. getCName()
    // target is field to mapper to modal
    @Mapping(source = "name", target = "categoryName")
    CategoriesResponse entityToModal(CategoryEntity categoryEntity);
    default List<CategoriesResponse> entityToModal(List<CategoryEntity> category) {
        return category.stream().map(this::entityToModal).collect(Collectors.toList());
    };
}
