package br.com.lbr.beerApi.service;

import br.com.lbr.beerApi.exception.*;
import lombok.AllArgsConstructor;
import br.com.lbr.beerApi.dto.BeerDTO;
import br.com.lbr.beerApi.entity.Beer;
import br.com.lbr.beerApi.mapper.BeerMapper;
import br.com.lbr.beerApi.repository.BeerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class BeerService {

    private final BeerRepository beerRepository;
    private final BeerMapper beerMapper = BeerMapper.INSTANCE;
    private final BreweryService breweryService;
    private final BeerTypeService beerTypeService;

    public BeerDTO createBeer(BeerDTO beerDTO) throws BeerAlreadyRegisteredException, BreweryNotFoundException, BeerTypeNotFoundException {
        verifyIfCanCreate(beerDTO);
        final var breweryName = beerDTO.getBrewery().getName();
        final var beerTypeName = beerDTO.getType().getName();
        beerDTO.getBrewery().setId(breweryService.findByName(breweryName).getId());
        beerDTO.getType().setId(beerTypeService.findByName(beerTypeName).getId());
        final var beer = beerMapper.toModel(beerDTO);
        return beerMapper.toDTO(beerRepository.save(beer));
    }

    private void verifyIfCanCreate(BeerDTO beerDTO) throws BreweryNotFoundException, BeerAlreadyRegisteredException, BeerTypeNotFoundException {
        verifyIfIsAlreadyRegistered(beerDTO.getName());
        breweryService.findByName(beerDTO.getBrewery().getName());
        beerTypeService.findByName(beerDTO.getType().getName());
    }

    public BeerDTO findByName(String name) throws BeerNotFoundException {
        Beer foundBeer = beerRepository.findByName(name)
                .orElseThrow(() -> new BeerNotFoundException(name));
        return beerMapper.toDTO(foundBeer);
    }

    public List<BeerDTO> listAll() {
        return beerRepository.findAll()
                .stream()
                .map(beerMapper::toDTO)
                .collect(Collectors.toList());
    }

    public void deleteById(Long id) throws BeerNotFoundException {
        verifyIfExists(id);
        beerRepository.deleteById(id);
    }

    private void verifyIfIsAlreadyRegistered(String name) throws BeerAlreadyRegisteredException {
        Optional<Beer> optSavedBeer = beerRepository.findByName(name);
        if (optSavedBeer.isPresent()) {
            throw new BeerAlreadyRegisteredException(name);
        }
    }

    private Beer verifyIfExists(Long id) throws BeerNotFoundException {
        return beerRepository.findById(id)
                .orElseThrow(() -> new BeerNotFoundException(id));
    }

    public BeerDTO increment(Long id, int quantityToIncrement) throws BeerNotFoundException, BeerStockExceededException {
        Beer beerToIncrementStock = verifyIfExists(id);
        int quantityAfterIncrement = quantityToIncrement + beerToIncrementStock.getQuantity();
        if (quantityAfterIncrement <= beerToIncrementStock.getMax()) {
            beerToIncrementStock.setQuantity(beerToIncrementStock.getQuantity() + quantityToIncrement);
            Beer incrementedBeerStock = beerRepository.save(beerToIncrementStock);
            return beerMapper.toDTO(incrementedBeerStock);
        }
        throw new BeerStockExceededException(id, quantityToIncrement);
    }
}
