package guru.sfg.beer.order.service.services.model;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Service
@Primary
@Configuration
public class BeerServiceServiceImpl implements BeerServiceService {
    private final String SERVICE_PATH = "api/v1/beer/{beerId}";
    private final RestTemplate template;
    private String beerServiceHost;

    public BeerServiceServiceImpl(RestTemplateBuilder builder) {
        this.template = builder.build();
    }

    public void setBeerServiceHost(String beerServiceHost) {
        this.beerServiceHost = beerServiceHost;
    }

    @Override
    public BeerDto getInfoById(UUID id) {
        return template.getForObject(beerServiceHost + SERVICE_PATH + id.toString(), BeerDto.class);
    }
}
