package com.ecommerce.backend;

import com.ecommerce.backend.entity.Categories;
import com.ecommerce.backend.entity.SubCategory;
import com.ecommerce.backend.repository.CategoriesRepository;
import com.ecommerce.backend.repository.SubCategoryRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.Arrays;

@Log4j2
@Component
public class SeedDatabase implements CommandLineRunner {


    @Autowired
    private CategoriesRepository cRepo;
    @Autowired
    private SubCategoryRepository scRepo;
    @Override
    public void run(String... args) throws Exception {
//        scRepo.deleteAll();
//        cRepo.deleteAll();
//        ObjectMapper objectMapper = new ObjectMapper();
//        File file = ResourceUtils.getFile("classpath:data.json");
//        ModelSeed models = objectMapper.readValue(file, ModelSeed.class);
//        models.getCategories().forEach((c, sc) -> {
//            Categories cate = new Categories();
//            cate.setName(c.toString().replaceAll("_"," "));
//            Categories category = cRepo.save(cate);
//            Arrays.stream(sc).toList().forEach(s -> {
//                SubCategory subCategory = new SubCategory();
//                subCategory.setCategory(category);
//                subCategory.setName(s.toString().replaceAll("_"," "));
//                scRepo.save(subCategory);
//            });
//        });
    }
}
