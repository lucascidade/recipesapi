package com.recipesapi.application.usecases;

import com.recipesapi.infrastructure.entity.ProductEntity;

import java.util.List;

public interface FindAllProductsCase {
    List<ProductEntity> execute();
}
