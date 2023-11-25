package com.karizma.recettes.models.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class IngredientRequest {
    private Long id;
    @NotNull(message = "Le champ ne peut pas être nul.")
    @Size(min = 5,max = 50)
    private String name;
    @NotNull(message = "Le champ ne peut pas être nul.")
    private int quantity;
}
