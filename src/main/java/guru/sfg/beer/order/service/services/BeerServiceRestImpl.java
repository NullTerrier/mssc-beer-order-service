package guru.sfg.beer.order.service.services;

import guru.sfg.beer.order.service.domain.BeerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Slf4j
@Component
public class BeerServiceRestImpl implements BeerService{

    private final RestTemplate beerRestTemplate;


    public BeerServiceRestImpl(@Value("${com.mm.beer-service.api-host}") String beerServiceAddress,
                               @Value("${com.mm.beer-service.api-address}") String beerServiceUrl,
                               RestTemplateBuilder builder) {
        beerRestTemplate = builder.rootUri(beerServiceAddress + beerServiceUrl)
                                  .build();
    }

    @Override
    public Optional<BeerDto> getBeerByUpc(String upc) {
        BeerDto beerDto = beerRestTemplate.exchange("/beerUpc/{upc}", HttpMethod.GET, null, BeerDto.class, upc)
                                          .getBody();
        return Optional.ofNullable(beerDto);
    }
}
