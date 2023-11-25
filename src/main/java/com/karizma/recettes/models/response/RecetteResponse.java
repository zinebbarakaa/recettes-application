package com.karizma.recettes.models.response;

import com.karizma.recettes.entities.Ingredient;
import com.karizma.recettes.entities.User;
import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class RecetteResponse {
    private String nom;
    private List<IngredientResponse> ingredients;


    private List<String> preparationSteps;

    private int preparationTime;

    private String photo;

    @ManyToOne
    private User user;
}
