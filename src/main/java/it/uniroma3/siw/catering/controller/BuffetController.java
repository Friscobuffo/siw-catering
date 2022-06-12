package it.uniroma3.siw.catering.controller;

import it.uniroma3.siw.catering.model.catering.Buffet;
import it.uniroma3.siw.catering.model.catering.Dish;
import it.uniroma3.siw.catering.service.catering.BuffetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("admin/buffet/")
public class BuffetController {
    @Autowired
    private BuffetService buffetService;

    @RequestMapping(value = "modify/{id}", method = RequestMethod.GET)
    public String editBuffet(Model model, @PathVariable("id") Long id) {
        Buffet buffet = buffetService.findById(id);
        model.addAttribute("buffet", buffet);
        model.addAttribute("dishes", buffet.getDishes());
        return "admin/buffet/modify";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String addBuffet(@ModelAttribute("buffet") Buffet buffet, BindingResult bindingResult) {
        buffetService.saveBuffet(buffet);
        return "admin/home";
    }

    @RequestMapping(value = "modify/confirm", method = RequestMethod.POST)
    public String modifyChef(@ModelAttribute("buffet") Buffet buffet, BindingResult bindingResult, Model model) {
        buffetService.saveBuffet(buffet);
        return "admin/home";
    }

    @RequestMapping(value = "{id}/add-dish", method = RequestMethod.GET)
    public String addDish(@PathVariable("id") Long id, Model model) {
        Buffet buffet = buffetService.findById(id);
        Dish dish = new Dish();
        dish.setBuffet(buffet);
        model.addAttribute("dish", dish);
        return "admin/dish/form";
    }
}
