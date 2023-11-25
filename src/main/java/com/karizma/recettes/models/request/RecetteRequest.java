package com.karizma.recettes.models.request;

import com.karizma.recettes.entities.Ingredient;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.util.List;
@Data
@Builder
public class RecetteRequest {

    private Long id;
    @NotNull (message = "Le champ ne peut pas être nul.")
    @Size(min = 5 , max = 50)
    private String nom ;
    @NotNull
    private List<IngredientRequest> ingredientRequests;
    @NonNull
    private List<String> preparationSteps;
}
