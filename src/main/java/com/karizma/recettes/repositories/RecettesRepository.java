package com.karizma.recettes.repositories;

import com.karizma.recettes.entities.Recette;
import com.karizma.recettes.models.response.RecetteResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RecettesRepository extends JpaRepository<Recette,Long> {
    Optional<Recette> findByNom(String nom );
}
