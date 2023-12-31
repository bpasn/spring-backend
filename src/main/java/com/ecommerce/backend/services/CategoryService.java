package com.ecommerce.backend.services;

import java.io.IOException;
import java.util.List;

import com.ecommerce.backend.Exception.BaseException;
import com.ecommerce.backend.controllers.categories.CategoriesResponse;
import com.ecommerce.backend.controllers.categories.ReqCreateCategory;
import com.ecommerce.backend.interfaces.ICategory;
import com.ecommerce.backend.repository.CategoriesRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ecommerce.backend.controllers.categories.CategoryMapper;
import com.ecommerce.backend.controllers.categories.ReqUpdateCategory;
import com.ecommerce.backend.entity.CategoryEntity;

@Service
public class CategoryService implements ICategory {

    private final CategoriesRepository repository;
    private final Helper helper;
    private final CategoryMapper mapper;

    public CategoryService(CategoriesRepository repository, Helper helper, CategoryMapper mapper) {
        this.repository = repository;
        this.helper = helper;
        this.mapper = mapper;
    }

    @Override
    public String create(ReqCreateCategory request) throws IOException {
        if (repository.existsByName(request.getCName())) {
            throw new BaseException("Categories is already.", HttpStatus.BAD_REQUEST);
        }
        String pathImage = helper.saveFile(request.getCImage());
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setName(request.getCName());
        categoryEntity.setDescription(request.getCDescription());
        categoryEntity.setImage(pathImage);
        repository.save(categoryEntity);
        return pathImage;
    }

    @Override
    public String delete(Integer id) {
        repository.deleteById(id);
        return "Delete successfully.";
    }

    @Override
    public List<CategoriesResponse> get() {
        List<CategoryEntity> categories = repository.findAll();
        return mapper.entityToModal(categories);
    }

    @Override
    public CategoriesResponse getById(Integer id) {
        CategoryEntity entity = repository.findById(id).orElseThrow(() -> new BaseException("Categories not found."));
        return mapper.entityToModal(entity);
    }

    @Override
    public String update(ReqUpdateCategory request) throws IOException {
        CategoryEntity existCategory = repository.getByName(request.getCName()).orElse(null);

        existCategory.setDescription(request.getCDescription());
        existCategory.setName(request.getCName());
        request.getCImage().ifPresent((c -> {
            try {
                helper.deleteFile(existCategory.getImage());
                String savePath = helper.saveFile(c);
                existCategory.setImage(savePath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }));

        repository.save(existCategory);
        return "Update category success.";
    }

}
