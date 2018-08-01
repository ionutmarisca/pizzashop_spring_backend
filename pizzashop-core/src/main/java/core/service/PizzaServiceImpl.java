package core.service;

import core.model.Pizza;
import core.repository.PizzaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

/**
 * Created by Ionut on 20/6/2017.
 */
@Service
public class PizzaServiceImpl implements PizzaService {
    @PersistenceContext
    private EntityManager entityManager;

    private static final Logger log = LoggerFactory.getLogger(PizzaServiceImpl.class);

    @Autowired
    private PizzaRepository pizzaRepository;

    @Override
    public List<Pizza> findAllWithIngredientsGraph() {
        log.trace("Service - get all pizzas");
        List<Pizza> pizzas = pizzaRepository.getAll();
        log.trace("Service - found all pizzas");

        return pizzas;
    }

    @Override
    public Pizza findOne(Long id) {
        log.trace("Service - get pizza with id {}", id);
        Pizza p = pizzaRepository.findOne(id);
        log.trace("Service - found pizza ");

        return p;
    }

    @Override
    @Transactional
    public Pizza updatePizza(Long id, String name, String description, float price) {
        Pizza currentPizza = pizzaRepository.getOne(id);
        pizzaRepository.findOne(id);
        currentPizza.setName(name);
        currentPizza.setDescription(description);
        currentPizza.setPrice(price);
        return currentPizza;
    }

    @Override
    public void updateAll(float additionalPrice) {
        log.trace("Service - increase price by {}", additionalPrice);
        pizzaRepository.updateAllPizzas(additionalPrice);
        log.trace("Service - increased all prices");
    }
}
