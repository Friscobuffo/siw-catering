package it.uniroma3.siw.catering.controller;

import it.uniroma3.siw.catering.model.catering.Buffet;
import it.uniroma3.siw.catering.model.catering.Chef;
import it.uniroma3.siw.catering.service.catering.ChefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("admin/chef/")
public class ChefController {
    @Autowired
    private ChefService chefService;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String getChefs(Model model) {
        List<Chef> chefs = chefService.findAll();
        model.addAttribute("chefs", chefs);
        return "admin/chef/list";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String addChef (Model model) {
        model.addAttribute("chef", new Chef());
        return "admin/chef/form";
    }

    @RequestMapping(value = { "add" }, method = RequestMethod.POST)
    public String registerUser(@ModelAttribute("chef") Chef chef, Model model) {
        chefService.saveChef(chef);
        model.addAttribute("chef", chef);
        return "admin/chef/added";
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String deleteChef(Model model, @PathVariable("id") Long id) {
        chefService.delete(id);
        return getChefs(model);
    }

    @RequestMapping(value = "modify/{id}", method = RequestMethod.GET)
    public String modifyChef(@PathVariable("id") Long id, Model model) {
        Chef chef = chefService.findById(id);
        List<Buffet> buffets = chef.getBuffets();
        model.addAttribute("chef", chef);
        model.addAttribute("buffets", buffets);
        return "admin/chef/modify";
    }

    @RequestMapping(value = "modify/confirm", method = RequestMethod.POST)
    public String modifyChef(@ModelAttribute("chef") Chef chef, Model model) {
        chefService.saveChef(chef);
        return getChefs(model);
    }

    @RequestMapping(value = "{id}/add-buffet", method = RequestMethod.GET)
    public String addBuffet(@PathVariable("id") Long id, Model model) {
        Chef chef = chefService.findById(id);
        Buffet buffet = new Buffet();
        buffet.setChef(chef);
        model.addAttribute("buffet", buffet);
        return "admin/buffet/form";
    }
}