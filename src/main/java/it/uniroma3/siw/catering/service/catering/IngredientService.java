package it.uniroma3.siw.catering.service.catering;

import it.uniroma3.siw.catering.model.catering.Ingredient;
import it.uniroma3.siw.catering.repository.catering.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class IngredientService {
    @Autowired
    private IngredientRepository ingredientRepository;

    @Transactional
    public Ingredient saveIngredient(Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }

    @Transactional
    public Ingredient findById(Long id) {
        return ingredientRepository.findById(id).orElse(null);
    }

    @Transactional
    public List<Ingredient> searchIngredients(String name) {
        List<Ingredient> list = new ArrayList<>();
        Iterable<Ingredient> temp = ingredientRepository.findByNameLikeIgnoreCase("%"+name+"%");
        for (Ingredient ingredient : temp) {
            list.add(ingredient);
        }
        return list;
    }

    @Transactional
    public List<Ingredient> findAll() {
        List<Ingredient> list = new ArrayList<>();
        Iterable<Ingredient> temp = ingredientRepository.findAll();
        for (Ingredient ingredient : temp) {
            list.add(ingredient);
        }
        return list;
    }

    @Transactional
    public void delete(Long id) {
        ingredientRepository.deleteById(id);
    }

}
