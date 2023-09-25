package com.firstApp.firstApp.services;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.firstApp.firstApp.Exception.BaseException;
import com.firstApp.firstApp.controllers.categories.CategoriesResponse;
import com.firstApp.firstApp.controllers.categories.CategoryMapper;
import com.firstApp.firstApp.controllers.categories.ReqCreateCategory;
import com.firstApp.firstApp.entity.CategoriesEntity;
import com.firstApp.firstApp.interfaces.ICategory;
import com.firstApp.firstApp.repository.CategoriesRepository;

@Service
public class CategoryService implements ICategory {

    private final CategoriesRepository repository;
    private final Helper helper;
    private final CategoryMapper categoryMapper;

    public CategoryService(CategoriesRepository repository, Helper helper,CategoryMapper mapper) {
        this.repository = repository;
        this.helper = helper;
        this.categoryMapper = mapper;
    }

    @Override
    public String create(ReqCreateCategory request) throws IOException {
        if (repository.existsBycName(request.getCName())) {
            throw new BaseException("Categories is already.", HttpStatus.BAD_REQUEST);
        }
        String pathImage = helper.saveFile(request.getCImage());
        CategoriesEntity categoriesEntity = new CategoriesEntity();
        categoriesEntity.setCDescription(request.getCDescription());
        categoriesEntity.setCImage(pathImage);
        categoriesEntity.setCName(request.getCName());
        repository.save(categoriesEntity);
        return pathImage;
    }

    @Override
    public String update(Integer id) {
        // todo Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public String delete(Integer id) {
        repository.deleteById(id);
        return "Delete successfully.";
    }

    @Override
    public List<CategoriesResponse> get() {
        // TODO Auto-generated method stub
        List<CategoriesEntity> categories = repository.findAll();
        return categoryMapper.entityToModal(categories);
    }

    @Override
    public CategoriesResponse getById(Integer id) {
        CategoriesEntity entity = repository.findById(id).orElseThrow(() -> new BaseException("Categories not found."));
        return categoryMapper.entityToModal(entity);
    }

}
