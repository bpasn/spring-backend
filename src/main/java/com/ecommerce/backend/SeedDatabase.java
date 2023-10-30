package com.ecommerce.backend;

import com.ecommerce.backend.controllers.categories.CategoriesResponse;
import com.ecommerce.backend.entity.CategoryEntity;
import com.ecommerce.backend.entity.SubCategory;
import com.ecommerce.backend.repository.CategoriesRepository;
import com.ecommerce.backend.repository.SubCategoryRepository;
import com.ecommerce.backend.services.CategoryService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Log4j2
@Component
public class SeedDatabase implements CommandLineRunner {


    @Autowired
    private CategoriesRepository cRepo;
    @Autowired
    private SubCategoryRepository scRepo;
    @Override
    public void run(String... args) throws Exception {
//        ObjectMapper objectMapper = new ObjectMapper();
//        File file = ResourceUtils.getFile("classpath:data.json");
//        ModelSeed models = objectMapper.readValue(file, ModelSeed.class);
//        models.getCategories().forEach((c, sc) -> {
//            CategoryEntity cate = new CategoryEntity();
//            cate.setName(c.toString());
//            CategoryEntity category = cRepo.save(cate);
//            Arrays.stream(sc).toList().forEach(s -> {
//                SubCategory subCategory = new SubCategory();
//                subCategory.setCategory(category);
//                subCategory.setName(s.toString());
//                scRepo.save(subCategory);
//            });
//        });
    }
}
