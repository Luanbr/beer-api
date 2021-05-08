package br.com.lbr.beerApi.controller;

import br.com.lbr.beerApi.dto.BreweryDTO;
import br.com.lbr.beerApi.exception.BreweryAlreadyRegisteredException;
import br.com.lbr.beerApi.exception.BreweryNotFoundException;
import br.com.lbr.beerApi.service.BreweryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/breweries")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class BreweryController implements BreweryControllerDocs {

    private final BreweryService breweryService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BreweryDTO createBrewery(@RequestBody @Valid BreweryDTO breweryDTO) throws BreweryAlreadyRegisteredException {
        return breweryService.createBrewery(breweryDTO);
    }

    @GetMapping("/{name}")
    public BreweryDTO findByName(@PathVariable String name) throws BreweryNotFoundException {
        return breweryService.findByName(name);
    }

    @GetMapping
    public List<BreweryDTO> listBreweries() {
        return breweryService.listAll();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws BreweryNotFoundException {
        breweryService.deleteById(id);
    }
}
