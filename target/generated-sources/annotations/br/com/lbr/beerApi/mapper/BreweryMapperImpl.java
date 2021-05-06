package br.com.lbr.beerApi.mapper;

import br.com.lbr.beerApi.dto.BreweryDTO;
import br.com.lbr.beerApi.dto.BreweryDTO.BreweryDTOBuilder;
import br.com.lbr.beerApi.entity.Brewery;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-05-05T23:16:45-0300",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 16.0.1 (Oracle Corporation)"
)
public class BreweryMapperImpl implements BreweryMapper {

    @Override
    public Brewery toModel(BreweryDTO breweryDTO) {
        if ( breweryDTO == null ) {
            return null;
        }

        Brewery brewery = new Brewery();

        brewery.setName( breweryDTO.getName() );
        brewery.setId( breweryDTO.getId() );

        return brewery;
    }

    @Override
    public BreweryDTO toDTO(Brewery brewery) {
        if ( brewery == null ) {
            return null;
        }

        BreweryDTOBuilder breweryDTO = BreweryDTO.builder();

        breweryDTO.id( brewery.getId() );
        breweryDTO.name( brewery.getName() );

        return breweryDTO.build();
    }
}
