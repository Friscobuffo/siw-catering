package it.uniroma3.siw.catering.controller;

import it.uniroma3.siw.catering.model.catering.Buffet;
import it.uniroma3.siw.catering.model.catering.Chef;
import it.uniroma3.siw.catering.model.catering.Dish;
import it.uniroma3.siw.catering.service.catering.BuffetService;
import it.uniroma3.siw.catering.service.catering.ChefService;
import it.uniroma3.siw.catering.service.catering.DishService;
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
}
