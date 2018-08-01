package core.service;

import core.model.Pizza;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by Ionut on 20/6/2017.
 */
public interface PizzaService {
    List<Pizza> findAllWithIngredientsGraph();
    Pizza findOne(Long id);
    Pizza updatePizza(Long id, String name, String description, float price);
    void updateAll(float additionalPrice);
}