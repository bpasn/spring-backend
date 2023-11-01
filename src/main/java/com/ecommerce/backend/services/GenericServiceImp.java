package com.ecommerce.backend.services;

import com.ecommerce.backend.interfaces.IGenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public class GenericServiceImp<Entity> implements IGenericService<Entity> {
    @Autowired
    private JpaRepository<Entity, Integer> jpaRepository;

    @Override
    public List<Entity> getAll() {
        return jpaRepository.findAll();
    }

    @Override
    public Entity getById(Integer id) {
        return null;
    }

    @Override
    public Entity create(Entity entity) {
        return jpaRepository.save(entity);
    }

    @Override
    public Entity update(Entity e) {
        return jpaRepository.save(e);
    }

    @Override
    public void delete(Entity e) {
        jpaRepository.delete(e);
    }

    @Override
    public void deleteById(Integer id) {
        jpaRepository.deleteById(id);
    }

    @Override
    public long count() {
        return jpaRepository.count();
    }
}
