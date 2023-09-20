package com.firstApp.firstApp.repository;

import com.firstApp.firstApp.entity.DistrictEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistrictRepository extends JpaRepository<DistrictEntity,Integer> {
}
