package br.com.lbr.beerApi.dto;

import br.com.lbr.beerApi.entity.Beer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BreweryDTO {
    private Long id;

    @NotNull
    @Size(min = 1, max = 200)
    private String name;

    private Set<Beer> beers;
}
