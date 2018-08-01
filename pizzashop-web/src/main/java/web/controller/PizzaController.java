package web.controller;

import core.model.Pizza;
import core.service.PizzaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import web.converter.PizzaConverter;
import web.dto.EmptyJsonResponse;
import web.dto.PizzaDto;
import web.dto.PizzasDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Ionut on 20/6/2017.
 */
@RestController
public class PizzaController {
    @Autowired
    private PizzaService pizzaService;
    @Autowired
    private PizzaConverter pizzaConverter;

    private static final Logger log = LoggerFactory.getLogger(PizzaController.class);

    @RequestMapping(value = "/pizza/{pizzaId}", method = RequestMethod.GET)
    public PizzaDto getPizza(@PathVariable final Long pizzaId) {
        log.trace("getPizza");

        Pizza pizza = pizzaService.findOne(pizzaId);

        log.trace("getPizza: pizza={}", pizza);

        return pizzaConverter.convertModelToDto(pizza);
    }

    @RequestMapping(value = "/pizza/{pizzaId}", method = RequestMethod.PUT)
    public Map<String, PizzaDto> updatePizza(
            @PathVariable final Long pizzaId,
            @RequestBody final Map<String, PizzaDto> pizzaDtoMap) {
        log.trace("updatePizza: pizzaId={}, pizzaDtoMap={}", pizzaId, pizzaDtoMap);

        PizzaDto pizzaDto = pizzaDtoMap.get("pizza");
        log.trace("*****Pizza*****: pizza to update", pizzaId, pizzaDto.getName(), pizzaDto.getDescription(), pizzaDto.getPrice());
        Pizza pizza = pizzaService.updatePizza(pizzaId, pizzaDto.getName(), pizzaDto.getDescription(), pizzaDto.getPrice());

        Map<String, PizzaDto> result = new HashMap<>();
        result.put("pizza", pizzaConverter.convertModelToDto(pizza));

        log.trace("updatePizza: result={}", result);

        return result;
    }

    @RequestMapping(value = "/pizzaupdate/{value}", method = RequestMethod.GET)
    public EmptyJsonResponse updatePizza(@PathVariable final float value) {
        pizzaService.updateAll(value);
        return new EmptyJsonResponse();
    }

    @RequestMapping(value = "/pizzas", method = RequestMethod.GET)
    public PizzasDto getPizzas() {
        log.trace("getPizzas");

        List<Pizza> pizzas = pizzaService.findAllWithIngredientsGraph();

        log.trace("getPizzas: pizzas={}", pizzas);

        return new PizzasDto(pizzaConverter.convertModelsToDtos(pizzas));
    }
}