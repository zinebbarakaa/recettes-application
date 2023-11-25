package com.karizma.recettes.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Recette {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String nom;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Ingredient> ingredients;

    @ElementCollection
    private List<String> preparationSteps;

    private int preparationTime;

    private String photo;

    @ManyToOne
    private User user;

}
