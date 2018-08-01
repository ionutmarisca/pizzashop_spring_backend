package web.dto;

import core.model.Ingredient;
import lombok.*;

import java.util.Set;

/**
 * Created by Ionut on 20/6/2017.
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class PizzaDto extends BaseDto {
    private String name;
    private String description;
    private float price;
    private Set<String> ingredients;
}