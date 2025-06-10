package com.recipesapi.infrastructure.persistence.repository;

import com.recipesapi.infrastructure.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ProductEntityRepository extends JpaRepository<ProductEntity, Long> {
    List<ProductEntity> findAll();
}
