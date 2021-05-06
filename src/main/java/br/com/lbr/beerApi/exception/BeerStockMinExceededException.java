package br.com.lbr.beerApi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BeerStockExceededException extends Exception {

    public BeerStockExceededException(Long id, int quantityToDecrement) {
        super(String.format("Beers with %s ID to decrement informed exceeds the stock capacity: %s", id, quantityToDecrement));
    }
}
