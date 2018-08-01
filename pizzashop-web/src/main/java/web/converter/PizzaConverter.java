package web.converter;

import core.model.Pizza;
import org.springframework.stereotype.Component;
import web.dto.PizzaDto;

import java.util.stream.Collectors;

/**
 * Created by Ionut on 20/6/2017.
 */
@Component
public class PizzaConverter extends BaseConverter<Pizza, PizzaDto> {
    @Override
    public Pizza convertDtoToModel(PizzaDto pizzaDto) {
        Pizza now = Pizza.builder()
                .name(pizzaDto.getName())
                .description(pizzaDto.getDescription())
                .price(pizzaDto.getPrice())
                .build();
        now.setId(pizzaDto.getId());
        return now;
    }

    @Override
    public PizzaDto convertModelToDto(Pizza pizza) {
        PizzaDto nowDto = PizzaDto.builder()
                .name(pizza.getName())
                .description(pizza.getDescription())
                .price(pizza.getPrice())
                .build();
        nowDto.setId(pizza.getId());
        nowDto.setIngredients(pizza.getIngredients().stream()
                .map(d -> d.getIngredient_name())
                .collect(Collectors.toSet()));
        return nowDto;
    }
}