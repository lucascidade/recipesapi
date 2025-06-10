package com.recipesapi.domain.model;

import com.recipesapi.domain.enums.Category;

public record Product (
     Long id,
     String name,
     Category category,
     Integer quantity
)
{}
