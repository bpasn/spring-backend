package com.firstApp.firstApp.repository;

import com.firstApp.firstApp.entity.ProvinceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvinceRepository extends JpaRepository<ProvinceEntity,Integer> {
}
