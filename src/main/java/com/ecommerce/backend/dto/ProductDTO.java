package com.ecommerce.backend.dto;

/**
 * ProductDTO
 */
public record ProductDTO(
        String id ,
        String name,
        String title,
        String description,
        Integer price,
        Integer stockQuantity
) {}
