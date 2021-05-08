package br.com.lbr.beerApi.service;

import br.com.lbr.beerApi.dto.BreweryDTO;
import br.com.lbr.beerApi.entity.Brewery;
import br.com.lbr.beerApi.exception.BreweryAlreadyRegisteredException;
import br.com.lbr.beerApi.exception.BreweryNotFoundException;
import br.com.lbr.beerApi.mapper.BreweryMapper;
import br.com.lbr.beerApi.repository.BreweryRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class BreweryService {

    private final BreweryRepository breweryRepository;
    private final BreweryMapper breweryMapper = BreweryMapper.INSTANCE;

    public BreweryDTO createBrewery(BreweryDTO breweryDTO) throws BreweryAlreadyRegisteredException {
        verifyIfIsAlreadyRegistered(breweryDTO.getName());
        final var brewery = breweryMapper.toModel(breweryDTO);
        return breweryMapper.toDTO(breweryRepository.save(brewery));
    }

    private void verifyIfIsAlreadyRegistered(String name) throws BreweryAlreadyRegisteredException {
        Optional<Brewery> optSavedBrewery = breweryRepository.findByName(name);
        if (optSavedBrewery.isPresent()) {
            throw new BreweryAlreadyRegisteredException(name);
        }
    }

    public BreweryDTO findByName(final String name) throws BreweryNotFoundException {
        Optional<Brewery> optSavedBrewery = breweryRepository.findByName(name);
        if (optSavedBrewery.isEmpty())
            throw new BreweryNotFoundException(name);
        return breweryMapper.toDTO(optSavedBrewery.get());
    }

    private Brewery verifyIfExists(Long id) throws BreweryNotFoundException {
        return breweryRepository.findById(id)
                .orElseThrow(() -> new BreweryNotFoundException(id));
    }

    public List<BreweryDTO> listAll() {
        return breweryRepository.findAll()
                .stream()
                .map(breweryMapper::toDTO)
                .collect(Collectors.toList());
    }

    public void deleteById(Long id) throws BreweryNotFoundException {
        verifyIfExists(id);
        breweryRepository.deleteById(id);
    }
}
