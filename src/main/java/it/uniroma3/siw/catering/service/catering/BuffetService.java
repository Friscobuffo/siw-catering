package it.uniroma3.siw.catering.service.catering;

import it.uniroma3.siw.catering.model.catering.Buffet;
import it.uniroma3.siw.catering.repository.catering.BuffetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BuffetService {

    @Autowired
    private BuffetRepository buffetRepository;

    @Transactional
    public Buffet findById(Long id) {
        return buffetRepository.findById(id).orElse(null);
    }

    @Transactional
    public void saveBuffet(Buffet buffet) {
        buffetRepository.save(buffet);
    }
}
