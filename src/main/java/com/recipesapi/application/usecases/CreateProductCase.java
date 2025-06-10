package com.recipesapi.application.usecases;

import com.recipesapi.infrastructure.entity.ProductEntity;

public interface CreateProductCase {
    ProductEntity execute(ProductEntity product);
}
