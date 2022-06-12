package it.uniroma3.siw.catering.repository.catering;

import it.uniroma3.siw.catering.model.catering.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, Long> {

    Iterable<Ingredient> findByNameLikeIgnoreCase(String name);
}
