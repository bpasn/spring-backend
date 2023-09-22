package com.firstApp.firstApp.services;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.firstApp.firstApp.Exception.BaseException;
import com.firstApp.firstApp.controllers.categories.ReqCreateCategory;
import com.firstApp.firstApp.entity.CategoriesEntity;
import com.firstApp.firstApp.interfaces.ICategory;
import com.firstApp.firstApp.repository.CategoriesRepository;

@Service
public class CategoryService implements ICategory {

    private final CategoriesRepository repository;
    private final Helper helper;

    public CategoryService(CategoriesRepository repository, Helper helper) {
        this.repository = repository;
        this.helper = helper;
    }

    @Override
    public String create(ReqCreateCategory request) throws IOException {
        if (repository.existsBycName(request.getCName())) {
            throw new BaseException("Categories is already.");
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

}
