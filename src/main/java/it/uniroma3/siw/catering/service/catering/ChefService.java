package it.uniroma3.siw.catering.service.catering;

import it.uniroma3.siw.catering.model.catering.Chef;
import it.uniroma3.siw.catering.repository.catering.ChefRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChefService {
    @Autowired
    private ChefRepository chefRepository;

    @Transactional
    public Chef saveChef(Chef chef) {
        return chefRepository.save(chef);
    }

    @Transactional
    public Chef findById(Long id) {
        return chefRepository.findById(id).orElse(null);
    }

    @Transactional
    public List<Chef> findAll() {
        List<Chef> list = new ArrayList<>();
        Iterable<Chef> temp = chefRepository.findAll();
        for (Chef chef : temp) {
            list.add(chef);
        }
        return list;
    }

    @Transactional
    public void delete(Long id) {
        chefRepository.deleteById(id);
    }
}
