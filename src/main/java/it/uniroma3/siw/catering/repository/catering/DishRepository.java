package it.uniroma3.siw.catering.repository.catering;

import it.uniroma3.siw.catering.model.catering.Dish;
import org.springframework.data.repository.CrudRepository;

public interface DishRepository extends CrudRepository<Dish, Long> {
    void deleteById(Long id);
}
