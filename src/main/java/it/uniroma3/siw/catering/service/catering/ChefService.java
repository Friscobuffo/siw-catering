package it.uniroma3.siw.catering.service.catering;

import it.uniroma3.siw.catering.model.catering.Chef;
import it.uniroma3.siw.catering.repository.catering.ChefRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        Optional<Chef> result = chefRepository.findById(id);
        return result.orElse(null);
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
    public boolean exists(String nome, String cognome) {
        return chefRepository.existsByNomeAndCognome(nome, cognome);
    }

    @Transactional
    public void delete(Long id) {
        chefRepository.deleteById(id);
    }
}
