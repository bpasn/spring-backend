package com.ecommerce.backend.services;

import com.ecommerce.backend.interfaces.IGenericService;
import com.ecommerce.backend.mapper.MapperGeneric;
import com.ecommerce.backend.repository.GenericRepo;

import java.util.List;

public class GenericServiceImp<Entity,DTO> implements IGenericService<Entity> {
    private final GenericRepo<Entity> jpaRepository;

    private final MapperGeneric<Entity,DTO>  mapper;

    public GenericServiceImp(GenericRepo<Entity> jpaRepository, MapperGeneric<Entity,DTO> mapper){
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }
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
