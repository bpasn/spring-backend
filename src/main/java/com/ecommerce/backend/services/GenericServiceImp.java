package com.ecommerce.backend.services;

import com.ecommerce.backend.interfaces.IGenericService;
import com.ecommerce.backend.mapper.MappingClass;
import com.ecommerce.backend.repository.GenericRepo;

import java.util.List;
import java.util.stream.Collectors;

public class GenericServiceImp<E, DTO> implements IGenericService<E, DTO> {
    private final GenericRepo<E> jpaRepository;
    private final MappingClass<E, DTO> mappingClass;

    public GenericServiceImp(GenericRepo<E> jpaRepository, MappingClass<E, DTO> mappingClass) {
        this.jpaRepository = jpaRepository;
        this.mappingClass = mappingClass;
    }

    @Override
    public List<E> getAll() {
        return jpaRepository.findAll();
    }

    @Override
    public E getById(Integer id) {
        return jpaRepository.findById(id).orElse(null);
    }

    @Override
    public List<DTO> getAllToDto() {
        return jpaRepository
                .findAll()
                .stream()
                .map(mappingClass::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public DTO getByIdToDto(Integer id) {
        return mappingClass.toDTO(jpaRepository.findById(id).orElse(null));
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
