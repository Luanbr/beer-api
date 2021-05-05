package br.com.lbr.beerApi.mapper;

import br.com.lbr.beerApi.dto.BreweryDTO;
import br.com.lbr.beerApi.dto.BreweryDTO.BreweryDTOBuilder;
import br.com.lbr.beerApi.entity.Beer;
import br.com.lbr.beerApi.entity.Brewery;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-05-05T03:35:25-0300",
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
        Set<Beer> set = breweryDTO.getBeers();
        if ( set != null ) {
            brewery.setBeers( new HashSet<Beer>( set ) );
        }

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
        Set<Beer> set = brewery.getBeers();
        if ( set != null ) {
            breweryDTO.beers( new HashSet<Beer>( set ) );
        }

        return breweryDTO.build();
    }
}
