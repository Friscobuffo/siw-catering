package it.uniroma3.siw.catering.controller;

import it.uniroma3.siw.catering.controller.validator.catering.ChefValidator;
import it.uniroma3.siw.catering.model.catering.Chef;
import it.uniroma3.siw.catering.service.catering.ChefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AdminController {
    @Autowired
    private ChefService chefService;

    @Autowired
    private ChefValidator chefValidator;

    @RequestMapping(value = "admin/chefs", method = RequestMethod.GET)
    public String getChefs(Model model) {
        List<Chef> chefs = chefService.findAll();
        model.addAttribute("chefs", chefs);
        return "admin/chefs";
    }

    @RequestMapping(value = "admin/aggiungiChef", method = RequestMethod.GET)
    public String addChef (Model model) {
        model.addAttribute("chef", new Chef());
        return "admin/chefForm";
    }

    @RequestMapping(value = { "/admin/aggiungiChef" }, method = RequestMethod.POST)
    public String registerUser(@ModelAttribute("chef") Chef chef, BindingResult bindingResult, Model model) {
        this.chefValidator.validate(chef, bindingResult);

        if (!bindingResult.hasErrors()) {
            chefService.saveChef(chef);
            return "admin/home";
        }
        return "admin/aggiungiChef";
    }

    @RequestMapping(value = "admin/chef/{id}", method = RequestMethod.GET)
    public String getChef(Model model, @PathVariable("id") Long id) {
        Chef chef = chefService.findById(id);
        model.addAttribute("chef", chef);
        return "admin/chef";
    }

    @RequestMapping(value = "admin/deleteChef/{id}", method = RequestMethod.GET)
    public String deleteChef(Model model, @PathVariable("id") Long id) {
        chefService.delete(id);
        return "admin/chefs";
    }

    @RequestMapping(value = "admin/modifyChef/{id}", method = RequestMethod.GET)
    public String modifyChef(@PathVariable("id") Long id, Model model) {
        Chef chef = chefService.findById(id);
        model.addAttribute("chef", chef);
        return "/admin/modifyChef";
    }

    @RequestMapping(value = "admin/confermaModifica", method = RequestMethod.POST)
    public String confirmModify(@ModelAttribute("chef") Chef chef, Model model) {
        chefService.saveChef(chef);
        return getChefs(model);
    }
}