package br.com.lbr.beerApi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BreweryNotFoundException extends Exception {

    public BreweryNotFoundException(String breweryName) {
        super(String.format("Brewery with name %s not found in the system.", breweryName));
    }

    public BreweryNotFoundException(Long id) {
        super(String.format("Brewery with id %s not found in the system.", id));
    }
}
