package com.ecommerce.backend.services;

import com.ecommerce.backend.entity.Categories;
import com.ecommerce.backend.entity.Product;
import com.ecommerce.backend.repository.GenericRepo;
import org.springframework.stereotype.Service;

import com.ecommerce.backend.controllers.categories.CategoriesDTO;
import com.ecommerce.backend.controllers.product.ProductDTO;


@Service
public class ProdService  {


//     @Override
//     @Transactional(rollbackOn = Exception.class)
//     public String create(ReqCreateProduct product) throws IOException {
//         Categories category = categoriesRepository.getByName(
//                 product.getCategoryName()
//         ).orElseThrow(
//                 () -> new BaseException("Category Name not found.",HttpStatus.BAD_REQUEST)
//         );
//         Product entity = new Product();
//         String image = helper.saveFileImageWithBase64(product.getImageBase64(), "static/products", product.getOriginalFile());

//         entity.setCategory(category);
//         entity.setName(product.getName());
//         entity.setDescription(product.getDescription());
//         entity.setPrice(product.getPrice());
//         entity.setStockQuantity(product.getStockQuantity());
// //        entity.setImage(image);

//         productRepository.save(entity);
//        return "Create Product Successfully";
//     }

    // public ProdService(
    //     GenericRepo<Product> jpaRepository, 
    //     Helper helper
    //     ) {
    //     super(jpaRepository,Categories.class,CategoriesDTO.class);
    //     this.helper = helper;
    // }

}
