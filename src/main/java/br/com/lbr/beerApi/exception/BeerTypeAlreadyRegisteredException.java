package br.com.lbr.beerApi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class BeerTypeAlreadyRegisteredException extends ResponseStatusException {

    public BeerTypeAlreadyRegisteredException(String beerTypeName) {
        super(HttpStatus.BAD_REQUEST, String.format("BeerType with name %s already registered in the system.", beerTypeName));
    }
}
