package com.ecommerce.backend.repository;

import com.ecommerce.backend.entity.CategoryEntity;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriesRepository extends JpaRepository<CategoryEntity, Integer> {
    Boolean existsByName(String name);
    Optional<CategoryEntity> getByName(String name);

}
