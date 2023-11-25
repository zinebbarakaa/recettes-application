package com.karizma.recettes.mappers;

import org.mapstruct.MappingTarget;

import java.util.List;

public interface ApplicationMapper<RQ,RS,ET>
{
    ET requestToEntity(RQ entityRequest);
    List<ET> listrequestToEntity( List<RQ> entityRequest);
    RS entityToResponse(ET entity);

    List<RS> listToResponseList(List<ET> entities);


}
