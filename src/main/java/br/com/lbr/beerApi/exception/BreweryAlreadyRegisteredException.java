package br.com.lbr.beerApi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class BreweryAlreadyRegisteredException extends ResponseStatusException {

    public BreweryAlreadyRegisteredException(String breweryName) {
        super(HttpStatus.BAD_REQUEST, String.format("Brewery with name %s already registered in the system.", breweryName));
    }
}
