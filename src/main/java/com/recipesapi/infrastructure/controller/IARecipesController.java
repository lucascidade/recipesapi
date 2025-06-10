package com.recipesapi.infrastructure.controller;

import com.recipesapi.infrastructure.ai.RecipesSuggestCaseImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Tag(name= "RECIPES AI", description = "Endpoints para integração com Google Gemini AI")
@RestController
@RequestMapping("/recipes-ai")
public class IARecipesController {

    private final RecipesSuggestCaseImpl recipesSuggestCase;

    public IARecipesController(RecipesSuggestCaseImpl recipesSuggestCase) {
        this.recipesSuggestCase = recipesSuggestCase;
    }

    @Operation(summary = "Sugere receitas", description = "consulta produtos/ingredientes o banco para sugerir receitas!")
    @GetMapping
    public ResponseEntity<Mono<String>> sugerirReceita() {
        return ResponseEntity.ok(recipesSuggestCase.execute());
    }
}
