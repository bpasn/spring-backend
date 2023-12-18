package com.ecommerce.backend.services;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import com.ecommerce.backend.Exception.BaseException;
import com.ecommerce.backend.controllers.categories.CreateCategoryRequest;
import com.ecommerce.backend.controllers.categories.UpdateCategoryRequest;
import com.ecommerce.backend.dto.CategoriesDTO;
import com.ecommerce.backend.dto.DataTableDTO;
import com.ecommerce.backend.interfaces.ICategory;
import com.ecommerce.backend.mapper.CategoryMapper;
import com.ecommerce.backend.repository.CategoriesRepository;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.ecommerce.backend.entities.Categories;

@Service
@Log4j2
public class CategoryService extends GenericServiceImp<Categories, CategoriesRepository, CategoriesDTO> implements ICategory {

    @Value("${APPLICATION.MOUNT_PATH}")
    private String BASE_PATH;

    public CategoryService(
            Helper helper,
            CategoriesRepository repository,
            CategoryMapper mappingClass) {
        super(repository, mappingClass);
    }

    @Override
    public String create(CreateCategoryRequest request){
        Categories c = new Categories();
        c.setName(request.name());
        this.getJpaRepository().save(c);
        return "Create Category Successfully";
    }
    public String update(UpdateCategoryRequest req){
        Categories c = this.getJpaRepository()
                .findById(Integer.parseInt(req.getId()))
                .orElseThrow(() -> new BaseException("Category not found!", HttpStatus.BAD_REQUEST));
        this.getJpaRepository().save(c);
        return "Update Category Successfully";
    }

    @Override
    public DataTableDTO<CategoriesDTO> getDataTable(
            Integer page,
            Integer pageSize){

        if(pageSize <=0)
            throw new BaseException("Page size is require minimum 1",HttpStatus.BAD_REQUEST);
        Integer offset = (pageSize * (page + 1)) - pageSize;
        CategoriesRepository repository = getJpaRepository();

        long _count = count();
        log.info("Category count : " + _count);

        List<CategoriesDTO> dto = repository
                .findByNative(pageSize, offset)
                .stream()
                .map(getMapping()::toDTO)
                .collect(Collectors.toList());
        DataTableDTO<CategoriesDTO> dataTableDTO = new DataTableDTO<>();
        dataTableDTO.setDataTable(dto);
        dataTableDTO.setCount(_count);
        return dataTableDTO;
    }

}
