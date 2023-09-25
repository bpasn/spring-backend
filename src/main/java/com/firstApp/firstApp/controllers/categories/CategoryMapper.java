package com.firstApp.firstApp.controllers.categories;

import org.mapstruct.Mapper;

import com.firstApp.firstApp.entity.CategoriesEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoriesResponse entityToModal(CategoriesEntity categoriesEntity);
    List<CategoriesResponse> entityToModal(List<CategoriesEntity> entitys);
}
