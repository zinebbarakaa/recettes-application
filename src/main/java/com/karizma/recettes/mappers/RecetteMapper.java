package com.karizma.recettes.mappers;

import com.karizma.recettes.entities.Recette;
import com.karizma.recettes.models.request.RecetteRequest;
import com.karizma.recettes.models.response.RecetteResponse;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValueMapMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT,
        nullValueIterableMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
public interface RecetteMapper extends ApplicationMapper<RecetteRequest, RecetteResponse, Recette>
{
    RecetteMapper INSTANCE = Mappers.getMapper(RecetteMapper.class);

    @Mapping(target = "id", ignore = true)
    Recette responseToEntity(Recette recette);

}
