package it.uniroma3.siw.catering.service.catering;

import it.uniroma3.siw.catering.model.catering.Dish;
import it.uniroma3.siw.catering.model.catering.Ingredient;
import it.uniroma3.siw.catering.repository.catering.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DishService {

    @Autowired
    private DishRepository dishRepository;

    @Transactional
    public Dish saveDish(Dish dish) {
        return dishRepository.save(dish);
    }

    @Transactional
    public Dish findById(Long id) {
        return dishRepository.findById(id).orElse(null);
    }

    @Transactional
    public void addIngredient(Dish dish, Ingredient ingredient) {
        dish.addIngredient(ingredient);
        this.dishRepository.save(dish);
    }

    @Transactional
    public boolean removeIngredient(Dish dish, Ingredient ingredient) {
        boolean result = dish.removeIngredient(ingredient);
        this.dishRepository.save(dish);
        return result;
    }
}
