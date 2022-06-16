package it.uniroma3.siw.catering.controller;

import it.uniroma3.siw.catering.model.catering.Buffet;
import it.uniroma3.siw.catering.model.catering.Chef;
import it.uniroma3.siw.catering.model.catering.Dish;
import it.uniroma3.siw.catering.model.catering.Ingredient;
import it.uniroma3.siw.catering.service.catering.BuffetService;
import it.uniroma3.siw.catering.service.catering.ChefService;
import it.uniroma3.siw.catering.service.catering.DishService;
import it.uniroma3.siw.catering.service.catering.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@Controller
public class MainController {
    @Autowired
    private ChefService chefService;

    @Autowired
    private BuffetService buffetService;

    @Autowired
    private DishService dishService;

    @Autowired
    private IngredientService ingredientService;

    @RequestMapping(value = "chef/data/{id}", method = RequestMethod.GET)
    public String getChef(Model model, @PathVariable("id") Long id) {
        Chef chef = chefService.findById(id);
        List<Buffet> buffets = chef.getBuffets();
        model.addAttribute("chef", chef);
        model.addAttribute("buffets", buffets);
        return "chef/data";
    }

    @RequestMapping(value = "buffet/data/{id}", method = RequestMethod.GET)
    public String getBuffet(Model model, @PathVariable("id") Long id) {
        Buffet buffet = buffetService.findById(id);
        model.addAttribute("buffet", buffet);
        return "buffet/data";
    }

    @RequestMapping(value = "dish/data/{id}", method = RequestMethod.GET)
    public String getDish(Model model, @PathVariable("id") Long id) {
        Dish dish = dishService.findById(id);
        model.addAttribute("dish", dish);
        return "dish/data";
    }

    @RequestMapping(value = "chef/list", method = RequestMethod.GET)
    public String getChefs(Model model) {
        List<Chef> chefs = chefService.findAll();
        model.addAttribute("chefs", chefs);
        return "user/chefList";
    }

    @RequestMapping(value = "chef/{id}", method = RequestMethod.GET)
    public String chef(@PathVariable("id") Long id, Model model) {
        Chef chef = chefService.findById(id);
        model.addAttribute("chef", chef);
        return "user/chef";
    }

    @RequestMapping(value = "buffet/{id}", method = RequestMethod.GET)
    public String buffet(Model model, @PathVariable("id") Long id) {
        Buffet buffet = buffetService.findById(id);
        model.addAttribute("buffet", buffet);
        return "user/buffet";
    }

    @RequestMapping(value = "dish/{id}", method = RequestMethod.GET)
    public String dish(Model model, @PathVariable("id") Long id) {
        Dish dish = dishService.findById(id);
        model.addAttribute("dish", dish);
        return "user/dish";
    }

    @RequestMapping(value = "ingredient/{id}", method = RequestMethod.GET)
    public String ingredient(Model model, @PathVariable("id") Long id) {
        Ingredient ingredient = ingredientService.findById(id);
        model.addAttribute("ingredient", ingredient);
        return "user/ingredient";
    }

    @RequestMapping(value = "buffet/list", method = RequestMethod.GET)
    public String buffets(Model model) {
        List<Buffet> buffets = buffetService.findAll();
        model.addAttribute("buffets", buffets);
        return "user/buffetList";
    }
}
