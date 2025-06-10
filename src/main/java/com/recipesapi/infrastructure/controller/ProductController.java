package com.recipesapi.infrastructure.controller;

import com.recipesapi.application.usecases.CreateProductCaseImpl;
import com.recipesapi.application.usecases.FindAllProductsCaseImpl;
import com.recipesapi.infrastructure.entity.ProductEntity;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final CreateProductCaseImpl service;
    private final FindAllProductsCaseImpl findAll;
    public ProductController(CreateProductCaseImpl service, FindAllProductsCaseImpl findAll) {
        this.service = service;
        this.findAll = findAll;
    }

    @Operation(summary = "CADASTRAR PRODUTOS", description = "cria produtos para simular uma geladeira virtual" )
    @PostMapping
    public ResponseEntity<ProductEntity> createProduct(@RequestBody ProductEntity product) {
        return ResponseEntity.ok(service.execute(product));
    }

    @Operation(summary = "LISTAR PRODUTOS")
    @GetMapping("/list")
    public ResponseEntity<List<ProductEntity>> listProducts() {
        return ResponseEntity.ok(findAll.execute());


    }
}
