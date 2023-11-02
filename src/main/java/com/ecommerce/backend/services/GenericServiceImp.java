package com.ecommerce.backend.services;

import com.ecommerce.backend.interfaces.IGenericService;
import com.ecommerce.backend.repository.GenericRepo;

import java.util.List;



public class GenericServiceImp<E> implements IGenericService<E> {
    
    private final GenericRepo<E> jpaRepository;

    public GenericServiceImp(
        GenericRepo<E> jpaRepository
        ) {
        this.jpaRepository = jpaRepository;
    }
   

    @Override
    public List<E> getAll() {
        return jpaRepository.findAll();
    }

    @Override
    public E getById(Integer id) {
        return null;
    }

    @Override
    public E create(E e) {
        return jpaRepository.save(e);
    }

    @Override
    public E update(E e) {
        return jpaRepository.save(e);
    }

    @Override
    public void delete(E e) {
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
