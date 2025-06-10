package com.recipesapi.infrastructure.ai;

import com.recipesapi.application.usecases.FindAllProductsCaseImpl;
import com.recipesapi.infrastructure.entity.ProductEntity;
import org.apache.http.HttpHeaders;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class RecipesSuggestCaseImpl implements RecipesSuggestCase {
    private final WebClient webClient;
    private final FindAllProductsCaseImpl findAllProductsCase;
    @Value("${google.api.key}")
    private String apiKey;

    public RecipesSuggestCaseImpl(WebClient.Builder builder, FindAllProductsCaseImpl findAllProductsCase) {
        this.webClient = builder
                .baseUrl("https://generativelanguage.googleapis.com")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
        this.findAllProductsCase = findAllProductsCase;
    }

    @Override
    public Mono<String> execute() {
        List<ProductEntity> products = findAllProductsCase.execute();

        if (products.isEmpty()) {
            return Mono.just("Nenhum ingrediente disponível no banco de dados.");
        }

        String listaIngredientes = products.stream()
                .map(i -> i.getQuantity() + "x " + i.getName())
                .collect(Collectors.joining(", "));

        String prompt = "Com os seguintes ingredientes disponíveis: " + listaIngredientes +
                ", me sugira uma receita criativa, com nome e modo de preparo detalhado.";

        return chamarGemini(prompt);
    }

    private Mono<String> chamarGemini(String prompt) {
        String model = "models/gemini-2.0-flash";

        Map<String, Object> body = Map.of(
                "contents", List.of(
                        Map.of("parts", List.of(
                                Map.of("text", prompt)
                        ))
                )
        );

        return webClient.post()
                .uri(uriBuilder -> uriBuilder
                        .path("/v1beta/" + model + ":generateContent")
                        .queryParam("key", apiKey)
                        .build())
                .bodyValue(body)
                .retrieve()
                .bodyToMono(Map.class)
                .map(response -> {
                    List<Map<String, Object>> candidates = (List<Map<String, Object>>) response.get("candidates");
                    if (candidates != null && !candidates.isEmpty()) {
                        Map<String, Object> content = (Map<String, Object>) candidates.get(0).get("content");
                        List<Map<String, Object>> parts = (List<Map<String, Object>>) content.get("parts");
                        return (String) parts.get(0).get("text");
                    }
                    return "Não foi possível gerar uma resposta!";
                });
    }
}

