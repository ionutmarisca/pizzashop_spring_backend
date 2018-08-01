package web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

/**
 * Created by Ionut on 20/6/2017.
 */
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class PizzasDto implements Serializable {
    private Set<PizzaDto> pizzas;
}