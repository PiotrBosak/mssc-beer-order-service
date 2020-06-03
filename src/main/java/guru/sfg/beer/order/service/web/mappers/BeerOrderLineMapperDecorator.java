package guru.sfg.beer.order.service.web.mappers;

import guru.sfg.beer.order.service.domain.BeerOrderLine;
import guru.sfg.beer.order.service.services.model.BeerServiceService;
import guru.sfg.beer.order.service.web.model.BeerOrderLineDto;
import org.springframework.beans.factory.annotation.Autowired;

public class BeerOrderLineMapperDecorator implements BeerOrderLineMapper {
    BeerOrderLineMapper mapper;
    BeerServiceService service;

    @Autowired
    public void setService(BeerServiceService service) {
        this.service = service;
    }

    @Autowired
    public void setMapper(BeerOrderLineMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public BeerOrderLineDto beerOrderLineToDto(BeerOrderLine line) {
        var dto = mapper.beerOrderLineToDto(line);
        var name = service.getInfoById(dto.getBeerId());
        dto.setBeerName(name.getBeerName());
        return dto;
    }

    @Override
    public BeerOrderLine dtoToBeerOrderLine(BeerOrderLineDto dto) {
        return mapper.dtoToBeerOrderLine(dto);
    }
}
