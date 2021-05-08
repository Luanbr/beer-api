package br.com.lbr.beerApi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BeerStockMinExceededException extends Exception {

    public BeerStockMinExceededException(Long id, int quantityToDecrement, int actualStockQuantity) {
        super(String.format("Beers with %s ID to decrement informed %s exceeds the stock capacity. Actual stock available %d", id, quantityToDecrement, actualStockQuantity));
    }
}
