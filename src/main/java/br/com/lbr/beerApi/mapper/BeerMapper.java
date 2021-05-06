package br.com.lbr.beerApi.mapper;

import br.com.lbr.beerApi.dto.BeerDTO;
import br.com.lbr.beerApi.entity.Beer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BeerMapper {

    BeerMapper INSTANCE = Mappers.getMapper(BeerMapper.class);

    @Mapping(target = "name", source = "name")
    @Mapping(target = "brand", source = "brand")
    @Mapping(target = "max", source = "max")
    @Mapping(target = "quantity", source = "quantity")
    Beer toModel(BeerDTO beerDTO);

    BeerDTO toDTO(Beer beer);
}
