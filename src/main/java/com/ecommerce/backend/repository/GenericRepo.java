package com.ecommerce.backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface GenericRepo<Entity> extends JpaRepository<Entity,Integer>{
    boolean existsByName(String name);
    <S extends Entity> Optional<S> getByName(String name);


}
