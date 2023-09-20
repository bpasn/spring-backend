package com.firstApp.firstApp.repository;

import com.firstApp.firstApp.entity.SubDistrictEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubDistrictRepository extends JpaRepository<SubDistrictEntity,Integer> {
}
