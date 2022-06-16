package it.uniroma3.siw.catering.controller.admin;

import it.uniroma3.siw.catering.model.catering.Buffet;
import it.uniroma3.siw.catering.model.catering.Chef;
import it.uniroma3.siw.catering.model.catering.Dish;
import it.uniroma3.siw.catering.service.catering.BuffetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
        return "admin/buffet/modify";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String addBuffet(@ModelAttribute("buffet") Buffet buffet, Model model) {
        buffetService.saveBuffet(buffet);
        Chef chef = buffet.getChef();
        model.addAttribute("chef", chef);
        return "admin/chef/modify";
    }

    @RequestMapping(value = "modify/confirm", method = RequestMethod.POST)
    public String modifyBuffet(@ModelAttribute("buffet") Buffet buffet, Model model) {
        buffetService.saveBuffet(buffet);
        Chef chef = buffet.getChef();
        model.addAttribute("chef", chef);
        return "admin/chef/modify";
    }

    @RequestMapping(value = "{id}/add-dish", method = RequestMethod.GET)
    public String addDish(@PathVariable("id") Long id, Model model) {
        Buffet buffet = buffetService.findById(id);
        Dish dish = new Dish();
        dish.setBuffet(buffet);
        model.addAttribute("dish", dish);
        return "admin/dish/form";
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String deleteBuffet(Model model, @PathVariable("id") Long id) {
        Chef chef = buffetService.findById(id).getChef();
        model.addAttribute("chef", chef);
        buffetService.delete(id);
        return "admin/chef/modify";
    }

    @RequestMapping(value = "/default", method = RequestMethod.GET)
    public String home() {
        return "admin/home";
    }
}
