package br.com.lbr.beerApi.mapper;

import br.com.lbr.beerApi.dto.BeerTypeDTO;
import br.com.lbr.beerApi.dto.BeerTypeDTO.BeerTypeDTOBuilder;
import br.com.lbr.beerApi.entity.BeerType;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-05-05T23:16:44-0300",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 16.0.1 (Oracle Corporation)"
)
public class BeerTypeMapperImpl implements BeerTypeMapper {

    @Override
    public BeerType toModel(BeerTypeDTO beerTypeDTO) {
        if ( beerTypeDTO == null ) {
            return null;
        }

        BeerType beerType = new BeerType();

        beerType.setName( beerTypeDTO.getName() );
        beerType.setId( beerTypeDTO.getId() );

        return beerType;
    }

    @Override
    public BeerTypeDTO toDTO(BeerType beerType) {
        if ( beerType == null ) {
            return null;
        }

        BeerTypeDTOBuilder beerTypeDTO = BeerTypeDTO.builder();

        beerTypeDTO.id( beerType.getId() );
        beerTypeDTO.name( beerType.getName() );

        return beerTypeDTO.build();
    }
}
