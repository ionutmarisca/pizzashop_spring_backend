package core.repository;

import core.model.Pizza;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Ionut on 20/6/2017.
 */
public interface PizzaRepository extends BaseRepository<Pizza, Long> {
    @Query("select distinct p from Pizza p")
    @EntityGraph(value = "pizzaWithIngredients", type = EntityGraph.EntityGraphType.LOAD)
    List<Pizza> getAll();

    @Query("select p from Pizza p where p.id = ?1")
    @EntityGraph(value = "pizzaWithIngredients", type = EntityGraph.EntityGraphType.LOAD)
    Pizza findOne(Long pizzaId);

    @Query("update Pizza set price = price + :increaseV")
    @Modifying
    @Transactional
    void updateAllPizzas(@Param("increaseV") float price);
}
