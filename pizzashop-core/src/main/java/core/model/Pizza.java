package core.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Ionut on 20/6/2017.
 */
@javax.persistence.Entity
@Table(name = "pizza")
@NamedEntityGraphs({
        @NamedEntityGraph(name = "pizzaWithIngredients", attributeNodes = {
                @NamedAttributeNode(value = "ingredients", subgraph = "ingredientsGraph")
        }, subgraphs = {
                @NamedSubgraph(name = "ingredientsGraph", attributeNodes = {
                        @NamedAttributeNode(value = "pizza")
                })
        }
        )
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pizza extends BaseEntity<Long> {
    @Column(name = "name", nullable = false, unique = true)
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "price", nullable = false)
    private float price;
    @OneToMany(mappedBy = "pizza", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Ingredient> ingredients;
}
