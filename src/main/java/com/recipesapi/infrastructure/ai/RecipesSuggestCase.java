package com.recipesapi.infrastructure.ai;

import reactor.core.publisher.Mono;

public interface RecipesSuggestCase {
    Mono<String> execute();
}
