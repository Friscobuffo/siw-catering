package it.uniroma3.siw.catering.service.userdata;

import it.uniroma3.siw.catering.model.userdata.GoogleUser;
import it.uniroma3.siw.catering.repository.userdata.GoogleUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GoogleUserService {

    @Autowired
    protected GoogleUserRepository googleUserRepository;

    @Transactional
    public GoogleUser getGoogleUser(String email) {
        Optional<GoogleUser> result = this.googleUserRepository.findByEmail(email);
        return result.orElse(null);
    }

    @Transactional
    public GoogleUser getGoogleUser(Long id) {
        Optional<GoogleUser> result = this.googleUserRepository.findById(id);
        return result.orElse(null);
    }

    @Transactional
    public GoogleUser saveGoogleUser(GoogleUser googleUser) {
        return this.googleUserRepository.save(googleUser);
    }

    @Transactional
    public List<GoogleUser> getAllGoogleUsers() {
        List<GoogleUser> result = new ArrayList<>();
        Iterable<GoogleUser> iterable = this.googleUserRepository.findAll();
        for(GoogleUser googleUser : iterable)
            result.add(googleUser);
        return result;
    }
}
