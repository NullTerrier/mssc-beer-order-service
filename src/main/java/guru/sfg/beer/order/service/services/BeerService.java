package guru.sfg.beer.order.service.services;

import guru.sfg.beer.order.service.domain.BeerDto;

import java.util.Optional;

public interface BeerService {
    Optional<BeerDto> getBeerByUpc(String upc);
}
