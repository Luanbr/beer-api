package br.com.lbr.beerApi.controller;

import br.com.lbr.beerApi.dto.BeerTypeDTO;
import br.com.lbr.beerApi.exception.BeerTypeAlreadyRegisteredException;
import br.com.lbr.beerApi.exception.BeerTypeNotFoundException;
import br.com.lbr.beerApi.service.BeerTypeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/beerTypes")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class BeerTypeController implements BeerTypeControllerDocs {

    private final BeerTypeService beerTypeService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BeerTypeDTO createBeerType(@RequestBody @Valid BeerTypeDTO beerTypeDTO) throws BeerTypeAlreadyRegisteredException {
        return beerTypeService.createBeerType(beerTypeDTO);
    }

    @GetMapping("/{name}")
    public BeerTypeDTO findByName(@PathVariable String name) throws BeerTypeNotFoundException {
        return beerTypeService.findByName(name);
    }
}
