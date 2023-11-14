package com.ecommerce.backend.services;

import com.ecommerce.backend.entities.Categories;
import com.ecommerce.backend.entities.Product;
import com.ecommerce.backend.interfaces.IProduct;
import com.ecommerce.backend.mapper.ProductMapper;
import com.ecommerce.backend.repository.GenericRepo;

import com.ecommerce.backend.repository.ProductRepository;
import io.jsonwebtoken.io.IOException;
import jakarta.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ecommerce.backend.Exception.BaseException;
import com.ecommerce.backend.controllers.product.CreateProductRequest;
import com.ecommerce.backend.dto.ProductDTO;

@Service
public class ProductService extends GenericServiceImp<Product,ProductRepository, ProductDTO> implements IProduct {

    private final GenericRepo<Categories> categoriesRepository;

     public ProductService(
            Helper helper,
            ProductRepository repository,
            ProductMapper mappingClass,
            GenericRepo<Categories> categoriesRepository
            ) {
        super(repository, mappingClass);
        this.categoriesRepository = categoriesRepository;
    }

    @Transactional
    @Override
    public String create(CreateProductRequest product) throws IOException {
        Categories category = categoriesRepository.getByName(
                product.getCategoryName()).orElseThrow(
                        () -> new BaseException("Category Name not found.", HttpStatus.OK));
        Product entity = new Product();
        entity.setCategories(category);
        entity.setName(product.getName());
        entity.setDescription(product.getDescription());
        entity.setPrice(product.getPrice());
        entity.setQuantity(product.getStockQuantity());
        this.getJpaRepository().save(entity);
        return "Create Product Successfully";
    }
}
