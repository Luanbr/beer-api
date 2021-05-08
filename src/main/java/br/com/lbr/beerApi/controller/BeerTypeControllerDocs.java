package br.com.lbr.beerApi.controller;

import br.com.lbr.beerApi.dto.BeerTypeDTO;
import br.com.lbr.beerApi.exception.BeerTypeAlreadyRegisteredException;
import br.com.lbr.beerApi.exception.BeerTypeNotFoundException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

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

    @ApiOperation(value = "Returns a list of all beer types registered in the system")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "List of all beer types registered in the system"),
    })
    List<BeerTypeDTO> listBeerTypes();

    @ApiOperation(value = "Delete a beer type found by a given valid Id")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Success beer type deleted in the system"),
            @ApiResponse(code = 404, message = "Beer type with given id not found.")
    })
    void deleteById(@PathVariable Long id) throws BeerTypeNotFoundException;
}
