package it.uniroma3.siw.catering.model.catering;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity @Getter @Setter
public class Ingredient {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @Column(length = 2000)
    private String description;

    private String origin;

    @ManyToMany(mappedBy = "ingredients")
    private List<Dish> dishes;
}
