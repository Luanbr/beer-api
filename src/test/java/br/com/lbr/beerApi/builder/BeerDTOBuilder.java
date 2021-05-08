package br.com.lbr.beerApi.builder;

import br.com.lbr.beerApi.entity.BeerType;
import br.com.lbr.beerApi.entity.Brewery;
import lombok.Builder;
import br.com.lbr.beerApi.dto.BeerDTO;

@Builder
public class BeerDTOBuilder {

    @Builder.Default
    private final Long id = 1L;

    @Builder.Default
    private final String name = "Brahma";

    @Builder.Default
    private final String brand = "Ambev";

    @Builder.Default
    private final int quantity = 10;

    @Builder.Default
    private final BeerType type = new BeerType(null, "Porter");

    @Builder.Default
    private final Brewery brewery = new Brewery(null, "Ambev");

    public BeerDTO toBeerDTO() {
        return new BeerDTO(id,
                name,
                brand,
                quantity,
                type,
                brewery
        );
    }
}
