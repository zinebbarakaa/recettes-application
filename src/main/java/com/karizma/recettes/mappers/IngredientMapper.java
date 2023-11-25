package com.karizma.recettes.mappers;

import com.karizma.recettes.entities.Ingredient;
import com.karizma.recettes.entities.User;
import com.karizma.recettes.models.request.IngredientRequest;
import com.karizma.recettes.models.request.UserRequest;
import com.karizma.recettes.models.response.IngredientResponse;
import com.karizma.recettes.models.response.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValueMapMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT,
        nullValueIterableMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
public interface IngredientMapper extends ApplicationMapper<IngredientRequest, IngredientResponse, Ingredient>
{
    IngredientMapper INSTANCE = Mappers.getMapper(IngredientMapper.class);
}
