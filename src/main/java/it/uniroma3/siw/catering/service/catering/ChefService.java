package it.uniroma3.siw.catering.service.catering;

import it.uniroma3.siw.catering.model.catering.Chef;
import it.uniroma3.siw.catering.repository.catering.ChefRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ChefService {
    @Autowired
    private ChefRepository chefRepository;

    @Transactional
    public Chef saveChef(Chef chef) {
        return chefRepository.save(chef);
    }
}
