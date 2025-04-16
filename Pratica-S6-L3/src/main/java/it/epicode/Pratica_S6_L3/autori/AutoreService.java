package it.epicode.Pratica_S6_L3.autori;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
public class AutoreService {

    @Autowired
    private AutoreRepository autoreRepository;

    // find all
    public List<AutoreResponse> findAllAutori() {

        List<Autore> autori = autoreRepository.findAll();
        return autori.stream()
                .map(autore -> new AutoreResponse(autore.getId(), autore.getNome() + " " + autore.getCognome()))
                .toList();
    }

    // find by id
    public AutoreResponse findById(Long id) {
        Autore autore = autoreRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Autore non trovato"));
        return new AutoreResponse(autore.getId(), autore.getNome() + " " + autore.getCognome());
    }

    // update
    public AutoreResponse update(Long id, AutoreRequest autoreRequest) {
        Autore autore = autoreRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Autore non trovato"));
        autore.setNome(autoreRequest.getNome());
        autore.setCognome(autoreRequest.getCognome());
        autore.setEmail(autoreRequest.getEmail());
        autore.setAvatar(autoreRequest.getAvatar());
        autoreRepository.save(autore);
        return new AutoreResponse(autore.getId(), autore.getNome() + " " + autore.getCognome());
    }

    // delete
    public void deleteById(Long id) {
        Autore autore = autoreRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Autore non trovato"));

        autoreRepository.delete(autore);
    }

    // save
    public AutoreResponse save( @Valid AutoreRequest autoreRequest) {
        Autore autore = new Autore();
        autore.setNome(autoreRequest.getNome());
        autore.setCognome(autoreRequest.getCognome());
        autore.setEmail(autoreRequest.getEmail());
        autore.setAvatar(autoreRequest.getAvatar());
        autoreRepository.save(autore);
        return new AutoreResponse(autore.getId(), autore.getNome() + " " + autore.getCognome());
    }

}
