package com.karizma.recettes.mappers;

import com.karizma.recettes.entities.Recette;
import com.karizma.recettes.entities.User;
import com.karizma.recettes.models.request.RecetteRequest;
import com.karizma.recettes.models.request.UserRequest;
import com.karizma.recettes.models.response.RecetteResponse;
import com.karizma.recettes.models.response.UserResponse;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValueMapMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT,
        nullValueIterableMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
public interface UserMapper extends ApplicationMapper<UserRequest, UserResponse, User>
{
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);


}