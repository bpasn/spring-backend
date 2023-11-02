package com.ecommerce.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.google.cloud.storage.Acl.Entity;

@NoRepositoryBean
public interface GenericRepo<Entity> extends JpaRepository<Entity,Integer>{
    
}
