package com.karizma.recettes.models.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class IngredientResponse {

    private String name;
    private int quantity;
}
