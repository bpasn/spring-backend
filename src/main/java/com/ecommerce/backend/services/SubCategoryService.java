package com.ecommerce.backend.services;

import com.ecommerce.backend.dto.SubCategoryDTO;
import com.ecommerce.backend.entities.SubCategory;
import com.ecommerce.backend.mapper.MappingClass;
import com.ecommerce.backend.repository.SubCategoryRepository;
import org.springframework.stereotype.Service;

@Service("subCategoryService")
public class SubCategoryService extends GenericServiceImp<SubCategory, SubCategoryRepository, SubCategoryDTO>{
    public SubCategoryService(
            SubCategoryRepository jpaRepository,
            MappingClass<SubCategory, SubCategoryDTO> mappingClass
    ) {
        super(jpaRepository, mappingClass);
    }


}
