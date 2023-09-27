package com.ecommerce.backend.repository;

import com.ecommerce.backend.entity.SubDistrictEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubDistrictRepository extends JpaRepository<SubDistrictEntity,Integer> {
}
