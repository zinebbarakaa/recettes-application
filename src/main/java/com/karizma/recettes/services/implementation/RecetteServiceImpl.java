package com.karizma.recettes.services.implementation;

import com.karizma.recettes.entities.Ingredient;
import com.karizma.recettes.entities.Recette;
import com.karizma.recettes.mappers.IngredientMapper;
import com.karizma.recettes.mappers.RecetteMapper;
import com.karizma.recettes.models.request.RecetteRequest;
import com.karizma.recettes.models.response.RecetteResponse;
import com.karizma.recettes.repositories.IngredientRepository;
import com.karizma.recettes.repositories.RecettesRepository;
import com.karizma.recettes.services.RecettesService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RecetteServiceImpl implements RecettesService {
    private final RecettesRepository recettesRepository;
    private final IngredientRepository ingredientRepository;

    @Override
    public RecetteResponse add(RecetteRequest request) {
        Recette recette = RecetteMapper.INSTANCE.requestToEntity(request);
        List<Ingredient>  listIngredient =  new ArrayList<>();
        if (request.getIngredientRequests() != null) {
              listIngredient = IngredientMapper.INSTANCE.listrequestToEntity(request.getIngredientRequests());
        }
        ingredientRepository.saveAll(listIngredient);
        recette.setIngredients(listIngredient);
        recettesRepository.save(recette);
        return RecetteMapper.INSTANCE.entityToResponse(recette);
    }

    @Override
    public List<RecetteResponse> get() {
        List<Recette> recettes = recettesRepository.findAll();
        return RecetteMapper.INSTANCE.listToResponseList(recettes);

    }

    @Override
    public RecetteResponse update(RecetteRequest request, Long id) {
        Optional<Recette> findrecette = recettesRepository.findById(id);
        if(findrecette.isEmpty()){
            throw new EntityNotFoundException("entity note found");
        }
        Recette recette = RecetteMapper.INSTANCE.requestToEntity(request);
        recettesRepository.save(recette);
        return RecetteMapper.INSTANCE.entityToResponse(recette);

    }

    @Override
    public void delete(Long id) {
        Recette recette = recettesRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("entity not Found "));
        recettesRepository.delete(recette);
    }

    @Override
    public RecetteResponse get(Long id) {
        Recette recette = recettesRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("entity not Found "));
         return RecetteMapper.INSTANCE.entityToResponse(recette);
    }

    @Override
    public RecetteResponse findByNom(String nom) {
        Recette recette = recettesRepository.findByNom(nom)
                .orElseThrow(() -> new EntityNotFoundException("entity not Found "));
        return RecetteMapper.INSTANCE.entityToResponse(recette);
    }
}
