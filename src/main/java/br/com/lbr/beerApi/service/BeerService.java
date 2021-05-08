package br.com.lbr.beerApi.service;

import br.com.lbr.beerApi.exception.*;
import lombok.AllArgsConstructor;
import br.com.lbr.beerApi.dto.BeerDTO;
import br.com.lbr.beerApi.entity.Beer;
import br.com.lbr.beerApi.mapper.BeerMapper;
import br.com.lbr.beerApi.repository.BeerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class BeerService {
    private static final Logger logger = LoggerFactory.getLogger(BeerService.class);

    private final BeerRepository beerRepository;
    private final BeerMapper beerMapper = BeerMapper.INSTANCE;
    private final BreweryService breweryService;
    private final BeerTypeService beerTypeService;

    public BeerDTO createBeer(BeerDTO beerDTO) throws BeerAlreadyRegisteredException, BreweryNotFoundException, BeerTypeNotFoundException {
        logger.info("Creating Beer..." + beerDTO.getName());
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

    public BeerDTO increment(final Long id, final int quantityToIncrement) throws BeerNotFoundException {
        Beer beer = verifyIfExists(id);
        final var stockQuantity = beer.getQuantity();
        final var quantityAfterIncrement = quantityToIncrement + stockQuantity;
        beer.setQuantity(quantityAfterIncrement);
        beer = beerRepository.save(beer);
        return beerMapper.toDTO(beer);
    }

    public BeerDTO decrement(final Long id, final int quantityToDecrement) throws BeerNotFoundException, BeerStockMinExceededException {
        Beer beer = verifyIfExists(id);
        final var stockQuantity = beer.getQuantity();
        final var quantityAfterDecrement =  stockQuantity - quantityToDecrement;
        if (quantityAfterDecrement < 0)
            throw new BeerStockMinExceededException(id, quantityToDecrement, stockQuantity);
        beer.setQuantity(quantityAfterDecrement);
        beer = beerRepository.save(beer);
        return beerMapper.toDTO(beer);
    }
}
