package br.com.lbr.beerApi.controller;

import br.com.lbr.beerApi.dto.BreweryDTO;
import br.com.lbr.beerApi.exception.BreweryAlreadyRegisteredException;
import br.com.lbr.beerApi.exception.BreweryNotFoundException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Api("Manages beer stock")
public interface BreweryControllerDocs {

    @ApiOperation(value = "Brewery creation operation")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Success brewery creation"),
            @ApiResponse(code = 400, message = "Missing required fields or wrong field range value.")
    })
    BreweryDTO createBrewery(BreweryDTO breweryDTO) throws BreweryAlreadyRegisteredException;

    @ApiOperation(value = "Returns breweryDTO found by a given name")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success breweryDTO found in the system"),
            @ApiResponse(code = 404, message = "Brewery with given name not found.")
    })
    BreweryDTO findByName(@PathVariable String name) throws BreweryNotFoundException;

    @ApiOperation(value = "Returns a list of all breweries registered in the system")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "List of all breweries registered in the system"),
    })
    List<BreweryDTO> listBreweries();

    @ApiOperation(value = "Delete a brewery found by a given valid Id")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Success brewery deleted in the system"),
            @ApiResponse(code = 404, message = "Brewery with given id not found.")
    })
    void deleteById(@PathVariable Long id) throws BreweryNotFoundException;
}
