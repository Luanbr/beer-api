package br.com.lbr.beerApi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BeerTypeNotFoundException extends Exception {

    public BeerTypeNotFoundException(String beerTypeName) {
        super(String.format("BeerType with name %s not found in the system.", beerTypeName));
    }

    public BeerTypeNotFoundException(Long id) {
        super(String.format("BeerType with id %s not found in the system.", id));
    }
}
