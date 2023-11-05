package com.ecommerce.backend.repository;

import com.ecommerce.backend.entity.Product;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends GenericRepo<Product> {
}
