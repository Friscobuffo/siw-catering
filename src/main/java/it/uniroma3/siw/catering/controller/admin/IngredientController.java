package it.uniroma3.siw.catering.controller.admin;

import it.uniroma3.siw.catering.model.SearchIngredient;
import it.uniroma3.siw.catering.model.catering.Ingredient;
import it.uniroma3.siw.catering.service.catering.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("admin/ingredient/")
public class IngredientController {

    @Autowired
    private IngredientService ingredientService;

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String addIngredient (Model model) {
        model.addAttribute("ingredient", new Ingredient());
        return "admin/ingredient/form";
    }

    @RequestMapping(value = { "search" }, method = RequestMethod.GET)
    public String searchIngredient(Model model, @ModelAttribute("searchIngredient") SearchIngredient si) {
        List<Ingredient> results = this.ingredientService.searchIngredients(si.getNameToSearch());
        model.addAttribute("results", results);
        model.addAttribute("si", si);
        return "admin/ingredient/select";
    }

    @RequestMapping(value = { "add" }, method = RequestMethod.POST)
    public String addIngredient(@ModelAttribute("ingredient") Ingredient ingredient, Model model) {
        ingredientService.saveIngredient(ingredient);
        return getIngredients(model);
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String getIngredients(Model model) {
        List<Ingredient> ingredients = ingredientService.findAll();
        model.addAttribute("ingredients", ingredients);
        return "admin/ingredient/list";
    }

    @RequestMapping(value = "{id}/delete", method = RequestMethod.GET)
    public String deleteIngredient(Model model, @PathVariable("id") Long id) {
        ingredientService.delete(id);
        return getIngredients(model);
    }

    @RequestMapping(value = "{id}/modify", method = RequestMethod.GET)
    public String modifyIngredient(@PathVariable("id") Long id, Model model) {
        Ingredient ingredient = ingredientService.findById(id);
        model.addAttribute("ingredient", ingredient);
        return "admin/ingredient/modify";
    }

    @RequestMapping(value = "modify/confirm", method = RequestMethod.POST)
    public String modifyChef(@ModelAttribute("ingredient") Ingredient ingredient, Model model) {
        ingredientService.saveIngredient(ingredient);
        return getIngredients(model);
    }
}
