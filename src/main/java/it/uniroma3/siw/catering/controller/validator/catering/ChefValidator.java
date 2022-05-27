package it.uniroma3.siw.catering.controller.validator.catering;

import it.uniroma3.siw.catering.model.catering.Chef;
import it.uniroma3.siw.catering.service.catering.ChefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ChefValidator implements Validator {
    @Autowired
    private ChefService chefService;

    @Override
    public void validate(Object o, Errors errors) {
        Chef chef = (Chef) o;
        String nome = chef.getNome().trim();
        String cognome = chef.getCognome().trim();
        String nazionalita = chef.getNazionalita().trim();

        if (nome.isEmpty())
            errors.rejectValue("nome", "required");

        if (cognome.isEmpty())
            errors.rejectValue("cognome", "required");

        if (nazionalita.isEmpty())
            errors.rejectValue("nazionalita", "required");

        if (chefService.exists(nome, cognome))
            errors.rejectValue("data", "duplicate");
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Chef.class.equals(clazz);
    }
}
