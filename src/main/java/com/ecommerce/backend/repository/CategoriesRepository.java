package com.ecommerce.backend.repository;

import com.ecommerce.backend.entity.Categories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriesRepository extends JpaRepository<Categories, Integer> {
    Boolean existsByName(String name);
    Optional<Categories> getByName(String name);

}
