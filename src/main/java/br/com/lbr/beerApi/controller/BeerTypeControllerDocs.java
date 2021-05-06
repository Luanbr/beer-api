package br.com.lbr.beerApi.controller;

import br.com.lbr.beerApi.dto.BeerTypeDTO;
import br.com.lbr.beerApi.exception.BeerTypeAlreadyRegisteredException;
import br.com.lbr.beerApi.exception.BeerTypeNotFoundException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.PathVariable;

@Api("Manages beer stock")
public interface BeerTypeControllerDocs {

    @ApiOperation(value = "BeerType creation operation")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Success brewery creation"),
            @ApiResponse(code = 400, message = "Missing required fields or wrong field range value.")
    })
    BeerTypeDTO createBeerType(BeerTypeDTO beerTypeDTO) throws BeerTypeAlreadyRegisteredException;

    @ApiOperation(value = "Returns beerTypeDTO found by a given name")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success beerTypeDTO found in the system"),
            @ApiResponse(code = 404, message = "BeerType with given name not found.")
    })
    BeerTypeDTO findByName(@PathVariable String name) throws BeerTypeNotFoundException;

}
