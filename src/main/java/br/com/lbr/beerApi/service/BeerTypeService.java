package br.com.lbr.beerApi.service;

import br.com.lbr.beerApi.dto.BeerTypeDTO;
import br.com.lbr.beerApi.entity.BeerType;
import br.com.lbr.beerApi.exception.BeerTypeAlreadyRegisteredException;
import br.com.lbr.beerApi.exception.BeerTypeNotFoundException;
import br.com.lbr.beerApi.mapper.BeerTypeMapper;
import br.com.lbr.beerApi.repository.BeerTypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class BeerTypeService {

    private final BeerTypeRepository beerTypeRepository;
    private final BeerTypeMapper beerTypeMapper = BeerTypeMapper.INSTANCE;

    public BeerTypeDTO createBeerType(BeerTypeDTO beerTypeDTO) throws BeerTypeAlreadyRegisteredException {
        verifyIfIsAlreadyRegistered(beerTypeDTO.getName());
        final var beerType = beerTypeMapper.toModel(beerTypeDTO);
        return beerTypeMapper.toDTO(beerTypeRepository.save(beerType));
    }

    private void verifyIfIsAlreadyRegistered(String name) throws BeerTypeAlreadyRegisteredException {
        Optional<BeerType> optSavedBeerType = beerTypeRepository.findByName(name);
        if (optSavedBeerType.isPresent()) {
            throw new BeerTypeAlreadyRegisteredException(name);
        }
    }

    public BeerTypeDTO findByName(final String name) throws BeerTypeNotFoundException {
        Optional<BeerType> optSavedBeerType = beerTypeRepository.findByName(name);
        if (optSavedBeerType.isEmpty())
            throw new BeerTypeNotFoundException(name);
        return beerTypeMapper.toDTO(optSavedBeerType.get());
    }
}
