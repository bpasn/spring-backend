package com.ecommerce.backend.repository;

import com.ecommerce.backend.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users,Integer> {
    Optional<Users> findByEmail(String email);
    boolean existsByEmail(String email);
}
