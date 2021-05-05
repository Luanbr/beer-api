package br.com.lbr.beerApi.mapper;

import br.com.lbr.beerApi.dto.BreweryDTO;
import br.com.lbr.beerApi.entity.Brewery;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BreweryMapper {

    BreweryMapper INSTANCE = Mappers.getMapper(BreweryMapper.class);

    @Mapping(target = "name", source = "name")
    Brewery toModel(BreweryDTO breweryDTO);

    BreweryDTO toDTO(Brewery brewery);
}
