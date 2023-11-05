package com.ecommerce.backend.repository;

import com.ecommerce.backend.entity.Categories;


import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriesRepository extends GenericRepo<Categories> {
    @Query(value = """
            SELECT 
                * 
            FROM categories 
            WHERE
               categories.name like LOWER(CONCAT('%', :name,'%'))
            """,nativeQuery = true)
    List<Categories> findByNative(
            String name
    );

}
