package com.karizma.recettes.services;

import com.karizma.recettes.entities.Recette;
import com.karizma.recettes.models.request.RecetteRequest;
import com.karizma.recettes.models.response.RecetteResponse;

import java.util.Optional;

public interface RecettesService extends CrudService<RecetteRequest, RecetteResponse, Recette,Long>{
    RecetteResponse  findByNom(String nom );
}
