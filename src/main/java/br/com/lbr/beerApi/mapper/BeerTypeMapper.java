package br.com.lbr.beerApi.mapper;

import br.com.lbr.beerApi.dto.BeerTypeDTO;
import br.com.lbr.beerApi.entity.BeerType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BeerTypeMapper {

    BeerTypeMapper INSTANCE = Mappers.getMapper(BeerTypeMapper.class);

    @Mapping(target = "name", source = "name")
    BeerType toModel(BeerTypeDTO beerTypeDTO);

    BeerTypeDTO toDTO(BeerType beerType);
}
