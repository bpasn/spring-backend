package com.ecommerce.backend.repository;

import com.ecommerce.backend.entity.DistrictEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistrictRepository extends JpaRepository<DistrictEntity,Integer> {
}
