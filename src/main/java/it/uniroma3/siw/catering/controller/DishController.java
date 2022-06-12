package it.uniroma3.siw.catering.controller;

import it.uniroma3.siw.catering.model.SearchIngredient;
import it.uniroma3.siw.catering.model.catering.Dish;
import it.uniroma3.siw.catering.model.catering.Ingredient;
import it.uniroma3.siw.catering.service.catering.DishService;
import it.uniroma3.siw.catering.service.catering.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("admin/dish/")
public class DishController {
    @Autowired
    private DishService dishService;

    @Autowired
    private IngredientService ingredientService;

    @RequestMapping(value = "modify/{id}", method = RequestMethod.GET)
    public String editBuffet(Model model, @PathVariable("id") Long id) {
        Dish dish = dishService.findById(id);
        model.addAttribute("dish", dish);
        return "admin/dish/modify";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String addDish(@ModelAttribute("dish") Dish dish) {
        dishService.saveDish(dish);
        return "admin/home";
    }

    @RequestMapping(value = "modify/confirm", method = RequestMethod.POST)
    public String modifyDish(@ModelAttribute("buffet") Dish dish) {
        dishService.saveDish(dish);
        return "admin/home";
    }

    @RequestMapping(value = "{id}/add-ingredient", method = RequestMethod.GET)
    public String addIngredient(@PathVariable("id") Long id, Model model) {
        SearchIngredient si = new SearchIngredient();
        si.setIdDish(id);
        model.addAttribute("searchIngredient", si);
        return "admin/dish/add-ingredient";
    }

    @RequestMapping(value = "{idDish}/add-ingredient/{idIngredient}", method = RequestMethod.POST)
    public String addIngredient(@PathVariable("idDish") Long idDish, Model model, @PathVariable Long idIngredient) {
        Dish dish = dishService.findById(idDish);
        Ingredient ingredient = ingredientService.findById(idIngredient);
        this.dishService.addIngredient(dish, ingredient);
        model.addAttribute("dish", dish);
        return "admin/dish/modify";
    }

    @RequestMapping(value = "{idDish}/remove-ingredient/{idIngredient}", method = RequestMethod.POST)
    public String removeIngredient(@PathVariable("idDish") Long idDish, Model model, @PathVariable Long idIngredient) {
        Dish dish = dishService.findById(idDish);
        Ingredient ingredient = ingredientService.findById(idIngredient);
        this.dishService.removeIngredient(dish, ingredient);
        model.addAttribute("dish", dish);
        return "admin/dish/modify";
    }
}
