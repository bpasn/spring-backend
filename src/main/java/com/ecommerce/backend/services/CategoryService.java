package com.ecommerce.backend.services;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import com.ecommerce.backend.controllers.categories.CategoriesDTO;
import com.ecommerce.backend.controllers.categories.ReqCreateCategory;
import com.ecommerce.backend.interfaces.ICategory;
import com.ecommerce.backend.mapper.MapperGeneric;
import com.ecommerce.backend.repository.GenericRepo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.ecommerce.backend.controllers.categories.CategoryMapper;
import com.ecommerce.backend.entity.Categories;

@Service
public class CategoryService extends GenericServiceImp<Categories,CategoriesDTO> implements ICategory {

    private final Helper helper;
    private final CategoryMapper mapper;
    private final MapperGeneric<Categories,CategoriesDTO> mapperGeneric;
    private final GenericRepo<Categories> repository;
    @Value("${APPLICATION.MOUNT_PATH}")
    private String BASE_PATH;

    
    public CategoryService(Helper helper, CategoryMapper mapper, MapperGeneric<Categories,CategoriesDTO> mapperGeneric,GenericRepo<Categories> repository) {
        super(repository,mapperGeneric);
        this.repository = repository;
        this.helper = helper;
        this.mapper = mapper;
        this.mapperGeneric = mapperGeneric;
    }

    @Override
    public String create(ReqCreateCategory request) throws IOException {
        Categories c = new Categories();
        c.setName(request.name());
        super.create(c);
        return "Create Category Successfully";
    }

    @Override
    public List<CategoriesDTO>getToDTO(){
        return this.getAll().stream().map(mapper::toDTO).collect(Collectors.toList());
    }

//
//    @Override
//    public String create(ReqCreateCategory request) throws IOException {
//        if (repository.existsByName(request.getCName())) {
//            throw new BaseException("Categories is already.", HttpStatus.BAD_REQUEST);
//        }
//        //new Object create data to table category;
//        Categories categories = new Categories();
//        categories.setName(request.getCName());
//        repository.save(categories);
//        return "Create Category Successfully.";
//    }
//
//    @Override
//    public String delete(Integer id) {
//        repository.deleteById(id);
//        return "Delete successfully.";
//    }
//
//    @Override
//    public List<CategoriesResponse> get() {
//        List<Categories> categories = repository.findAll();
//        return mapper.entityToModal(categories);
//    }
//
//    @Override
//    public CategoriesResponse getById(Integer id) {
//        Categories entity = repository.findById(id).orElseThrow(() -> new BaseException("Categories not found."));
//        return mapper.entityToModal(entity);
//    }
//
//    @Override
//    public String update(ReqUpdateCategory request) throws IOException {
//        Categories existCategory = repository.getByName(request.getCName()).orElse(null);
//
//        existCategory.setName(request.getCName());
////        request.getCImage().ifPresent((c -> {
////            try {
////                helper.deleteFile(existCategory.getImage());
////                Path output = Paths.get(BASE_PATH)
////                        .resolve("static/categories")
////                        .resolve(Objects.requireNonNull(c.getOriginalFilename()));
////                helper.saveFileImage(c,output);
////                existCategory.setImage(output.toString());
////            } catch (IOException e) {
////                e.printStackTrace();
////            }
////        }));
//
//        repository.save(existCategory);
//        return "Update category success.";
//    }

}
