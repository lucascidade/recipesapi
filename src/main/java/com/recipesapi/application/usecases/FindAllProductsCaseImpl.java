package com.recipesapi.application.usecases;

import com.recipesapi.infrastructure.entity.ProductEntity;
import com.recipesapi.infrastructure.persistence.repository.ProductEntityRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FindAllProductsCaseImpl implements FindAllProductsCase {

    private final ProductEntityRepository productEntityRepository;

    public FindAllProductsCaseImpl(ProductEntityRepository productEntityRepository) {
        this.productEntityRepository = productEntityRepository;
    }

    @Override
    public List<ProductEntity> execute() {
        return productEntityRepository.findAll();
    }
}
