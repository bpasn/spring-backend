package com.ecommerce.backend.services;

import com.ecommerce.backend.dto.DataTableDTO;
import com.ecommerce.backend.interfaces.IGenericService;
import com.ecommerce.backend.mapper.MappingClass;
import com.ecommerce.backend.repository.GenericRepo;

import lombok.extern.log4j.Log4j2;

import java.util.List;
import java.util.stream.Collectors;


import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Log4j2
public class GenericServiceImp<E,R extends GenericRepo<E>, DTO> implements IGenericService<E, DTO> {
    private final R jpaRepository;
    private final MappingClass<E, DTO> mappingClass;
    public GenericServiceImp(R jpaRepository, MappingClass<E, DTO> mappingClass) {
        this.jpaRepository = jpaRepository;
        this.mappingClass = mappingClass;
    }

    public R getJpaRepository(){
        return jpaRepository;
    }
    public MappingClass<E, DTO> getMapping(){
        return mappingClass;
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
    public E getByName(String name) {
        return jpaRepository.getByName(name).orElse(null);
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

    @Override
    public boolean existsByName(String name) {
        return jpaRepository.existsByName(name);
    }

    @Override
    public DataTableDTO<DTO> getDataTable(
            Integer page,
            Integer pageSize) {
        DataTableDTO<DTO> dataTableDTO = new DataTableDTO<DTO>();
        Pageable p = PageRequest.of(page,pageSize).withSort(Sort.Direction.ASC,"id");
        List<DTO> lists = jpaRepository.findAll(p)
                .stream()
                .map(mappingClass::toDTO)
                .collect(Collectors.toList());
        dataTableDTO.setCount(count());
        dataTableDTO.setDataTable(lists);
        return dataTableDTO;
    }
}
