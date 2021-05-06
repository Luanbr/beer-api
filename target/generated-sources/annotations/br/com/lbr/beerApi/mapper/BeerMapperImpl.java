package br.com.lbr.beerApi.mapper;

import br.com.lbr.beerApi.dto.BeerDTO;
import br.com.lbr.beerApi.dto.BeerDTO.BeerDTOBuilder;
import br.com.lbr.beerApi.entity.Beer;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-05-05T23:16:45-0300",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 16.0.1 (Oracle Corporation)"
)
public class BeerMapperImpl implements BeerMapper {

    @Override
    public Beer toModel(BeerDTO beerDTO) {
        if ( beerDTO == null ) {
            return null;
        }

        Beer beer = new Beer();

        beer.setName( beerDTO.getName() );
        beer.setBrand( beerDTO.getBrand() );
        if ( beerDTO.getMax() != null ) {
            beer.setMax( beerDTO.getMax() );
        }
        if ( beerDTO.getQuantity() != null ) {
            beer.setQuantity( beerDTO.getQuantity() );
        }
        beer.setId( beerDTO.getId() );
        beer.setType( beerDTO.getType() );
        beer.setBrewery( beerDTO.getBrewery() );

        return beer;
    }

    @Override
    public BeerDTO toDTO(Beer beer) {
        if ( beer == null ) {
            return null;
        }

        BeerDTOBuilder beerDTO = BeerDTO.builder();

        beerDTO.id( beer.getId() );
        beerDTO.name( beer.getName() );
        beerDTO.brand( beer.getBrand() );
        beerDTO.max( beer.getMax() );
        beerDTO.quantity( beer.getQuantity() );
        beerDTO.type( beer.getType() );
        beerDTO.brewery( beer.getBrewery() );

        return beerDTO.build();
    }
}
