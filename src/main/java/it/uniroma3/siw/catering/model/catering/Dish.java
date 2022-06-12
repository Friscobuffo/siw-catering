package it.uniroma3.siw.catering.model.catering;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity @Getter @Setter
public class Dish {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @Column(length = 2000)
    private String description;

    @ManyToOne
    private Buffet buffet;

    @ManyToMany
    private List<Ingredient> ingredients;

    public void addIngredient(Ingredient ingredient) {
        this.ingredients.add(ingredient);
    }

    public boolean removeIngredient(Ingredient ingredient) {
        return this.ingredients.remove(ingredient);
    }
}
