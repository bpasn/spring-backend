package com.ecommerce.backend.services;

import java.io.IOException;

import com.ecommerce.backend.Exception.BaseException;
import com.ecommerce.backend.entity.Categories;
import com.ecommerce.backend.entity.Product;
import com.ecommerce.backend.repository.CategoriesRepository;
import com.ecommerce.backend.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ecommerce.backend.controllers.product.ReqCreateProduct;
import com.ecommerce.backend.interfaces.IProduct;

import jakarta.transaction.Transactional;

@Service
public class ProdService  implements IProduct{

    private final Helper helper;
    private final CategoriesRepository categoriesRepository;
    private final ProductRepository productRepository;

    public ProdService(Helper helper,CategoriesRepository categoriesRepository,ProductRepository productRepository) {
        this.helper = helper;
        this.categoriesRepository = categoriesRepository;
        this.productRepository = productRepository;
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public String create(ReqCreateProduct product) throws IOException {
        Categories category = categoriesRepository.getByName(
                product.getCategoryName()
        ).orElseThrow(
                () -> new BaseException("Category Name not found.",HttpStatus.BAD_REQUEST)
        );
        Product entity = new Product();
        String image = helper.saveFileImageWithBase64(product.getImageBase64(), "static/products", product.getOriginalFile());

        entity.setCategory(category);
        entity.setName(product.getName());
        entity.setDescription(product.getDescription());
        entity.setPrice(product.getPrice());
        entity.setStockQuantity(product.getStockQuantity());
//        entity.setImage(image);

        productRepository.save(entity);
       return "Create Product Successfully";
    }

    @Override
    public String update() {
        // todo Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public String delete() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}
