package com.firstApp.firstApp.repository;

import com.firstApp.firstApp.entity.CategoryEntity;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriesRepository extends JpaRepository<CategoryEntity, Integer> {
    Boolean existsByName(String name);
    Optional<CategoryEntity> getByName(String name);

}
