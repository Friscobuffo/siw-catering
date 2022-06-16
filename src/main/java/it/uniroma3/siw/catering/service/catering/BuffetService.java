package it.uniroma3.siw.catering.service.catering;

import it.uniroma3.siw.catering.model.catering.Buffet;
import it.uniroma3.siw.catering.model.catering.Chef;
import it.uniroma3.siw.catering.repository.catering.BuffetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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

    @Transactional
    public void delete(Long id) {
        buffetRepository.deleteById(id);
    }

    @Transactional
    public List<Buffet> findAll() {
        List<Buffet> list = new ArrayList<>();
        Iterable<Buffet> temp = buffetRepository.findAll();
        for (Buffet buffet : temp) {
            list.add(buffet);
        }
        return list;
    }
}
