package core.model;

import lombok.*;

import javax.persistence.*;

/**
 * Created by Ionut on 20/6/2017.
 */

@javax.persistence.Entity
@Table(name = "ingredient")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ingredient extends BaseEntity<Long> {
    @Column(name = "ingredient_name")
    private String ingredient_name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pizza_id")
    private Pizza pizza;
}