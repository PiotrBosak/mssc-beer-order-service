package guru.sfg.beer.order.service.services.model;

import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public interface BeerServiceService {
    BeerDto getInfoById(UUID id);
}
