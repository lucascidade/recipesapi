package com.recipesapi.application.usecases;

import com.recipesapi.infrastructure.entity.ProductEntity;
import com.recipesapi.infrastructure.persistence.repository.ProductEntityRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateProductCaseImpl implements CreateProductCase{

    private final ProductEntityRepository repository;

    public CreateProductCaseImpl(ProductEntityRepository repository) {
        this.repository = repository;
    }

    @Override
    public ProductEntity execute(ProductEntity product) {
        return repository.save(product);
    }
}
