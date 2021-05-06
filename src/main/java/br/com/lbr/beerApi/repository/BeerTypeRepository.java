package br.com.lbr.beerApi.repository;

import br.com.lbr.beerApi.entity.BeerType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BeerTypeRepository extends JpaRepository<BeerType, Long> {

    Optional<BeerType> findByName(String name);
}
