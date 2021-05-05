package br.com.lbr.beerApi.repository;

import br.com.lbr.beerApi.entity.Brewery;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BreweryRepository extends JpaRepository<Brewery, Long> {

    Optional<Brewery> findByName(String name);
}
