package com.ecommerce.backend.mapper;

import com.ecommerce.backend.dto.SubCategoryDTO;
import com.ecommerce.backend.entities.SubCategory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface SubCategoryMapping extends MappingClass<SubCategory, SubCategoryDTO> {
    @Mapping(source = "subCategory",target = "categoryName", qualifiedByName = "categoryName")
    SubCategoryDTO toDTO(SubCategory subCategory);

    @Named("categoryName")
    default String categoryName(SubCategory subCategory){
        if(subCategory == null){
            return null;
        }
        String categoryName = subCategory.getCategory().getName();
        return categoryName;
    }

}
