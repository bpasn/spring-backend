package com.ecommerce.backend.repository;

import com.ecommerce.backend.entities.Categories;


import jakarta.persistence.Index;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriesRepository extends GenericRepo<Categories> {
    @Query(value = "SELECT * FROM CATEGORIES LIMIT :limit OFFSET :offset",nativeQuery = true)
//    WHERE
//    categories.name like LOWER(CONCAT('%', :name,'%'))
    List<Categories> findByNative(
            Integer limit,
            Integer offset
    );

}
