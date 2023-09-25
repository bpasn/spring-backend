package com.firstApp.firstApp.controllers.categories;

import org.mapstruct.Mapper;

import com.firstApp.firstApp.entity.CategoriesEntity;
import org.mapstruct.Mapping;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    // source is Getter exp. getCName()
    // target is field to mapper to modal
    @Mapping(source = "CName",target = "categoryName")
    @Mapping(source = "CDescription",target = "description")
    @Mapping(source = "CImage",target = "image")
    CategoriesResponse entityToModal(CategoriesEntity categoriesEntity);

    @Mapping(source = "CName",target = "categoryName")
    @Mapping(source = "CDescription",target = "description")
    @Mapping(source = "CImage",target = "image")
    List<CategoriesResponse> entityToModal(List<CategoriesEntity> entitys);
}
