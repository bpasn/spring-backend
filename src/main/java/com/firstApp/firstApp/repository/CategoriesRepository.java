package com.firstApp.firstApp.repository;

import com.firstApp.firstApp.entity.CategoriesEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriesRepository extends JpaRepository<CategoriesEntity, Integer> {
    Boolean existsBycName(String cName);
}
