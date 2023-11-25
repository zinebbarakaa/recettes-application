package com.karizma.recettes.services;

import com.karizma.recettes.entities.Ingredient;
import com.karizma.recettes.models.request.IngredientRequest;
import com.karizma.recettes.models.response.IngredientResponse;


public interface IngredientService extends CrudService<IngredientRequest, IngredientResponse, Ingredient, Long> {
}
