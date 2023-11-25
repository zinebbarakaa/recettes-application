package com.karizma.recettes.controllers;

import com.karizma.recettes.models.request.RecetteRequest;
import com.karizma.recettes.models.response.RecetteResponse;
import com.karizma.recettes.services.RecettesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/recettes")
@RequiredArgsConstructor
public class RecettteController {
    private final RecettesService   recetteService;
    @PostMapping
    public ResponseEntity<RecetteResponse> addRecettes(@RequestBody @Validated RecetteRequest request)
    {
        RecetteResponse recetteResponse = recetteService.add(request);
        return new ResponseEntity<>(recetteResponse, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<RecetteResponse>> getAllReccettes()
    {
        List<RecetteResponse> recettes = recetteService.get();
        return new ResponseEntity<>(recettes, HttpStatus.OK);
    }
    @GetMapping("get-one/{nom}")
    public ResponseEntity<RecetteResponse> getRecettesByNom(@PathVariable String nom) {
         RecetteResponse recetteResponse = recetteService.findByNom(nom);
        return new ResponseEntity<>(recetteResponse, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<RecetteResponse> updateRecettes(@PathVariable Long id, @RequestBody RecetteRequest request) {

        RecetteResponse updateRecette = recetteService.update(request, id);
        return new ResponseEntity<>(updateRecette, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        recetteService.delete(id);
        return new ResponseEntity<>("rectte est supprimee ", HttpStatus.OK);
    }

}
