package br.com.lbr.beerApi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class BeerAlreadyRegisteredException extends ResponseStatusException {

    public BeerAlreadyRegisteredException(String beerName) {
        super(HttpStatus.BAD_REQUEST, String.format("Beer with name %s already registered in the system.", beerName));
    }
}
