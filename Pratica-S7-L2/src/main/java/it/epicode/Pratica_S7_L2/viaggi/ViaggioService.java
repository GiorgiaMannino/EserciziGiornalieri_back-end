package it.epicode.Pratica_S7_L2.viaggi;


import it.epicode.Pratica_S7_L2.auth.AppUser;
import it.epicode.Pratica_S7_L2.auth.Role;
import it.epicode.Pratica_S7_L2.prenotazioni.PrenotazioneRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
public class ViaggioService {

    @Autowired
    private ViaggioRepository viaggioRepository;

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    public List<ViaggioResponse> findAll() {
        return viaggioRepository.findAll().stream()
                .map(viaggio -> new ViaggioResponse(
                        viaggio.getId(),
                        viaggio.getDestinazione(),
                        viaggio.getData(),
                        viaggio.getStato()))
                .toList();
    }

    public ViaggioResponse findById(Long id) {
        Viaggio viaggio = viaggioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Viaggio non trovato con id: " + id));
        return new ViaggioResponse(
                viaggio.getId(),
                viaggio.getDestinazione(),
                viaggio.getData(),
                viaggio.getStato());
    }

    public ViaggioResponse save(@Valid ViaggioRequest request) {
        Viaggio viaggio = new Viaggio();
        viaggio.setDestinazione(request.getDestinazione());
        viaggio.setData(request.getData());
        viaggio.setStato(StatoViaggio.IN_PROGRAMMA);

        viaggioRepository.save(viaggio);

        return new ViaggioResponse(
                viaggio.getId(),
                viaggio.getDestinazione(),
                viaggio.getData(),
                viaggio.getStato());
    }

    public ViaggioResponse update(Long id, @Valid ViaggioRequest request, AppUser utenteLoggato) {
        Viaggio viaggio = viaggioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Viaggio non trovato con id: " + id));

        // se volessi abilitare anche l'utente amministratore a modificare qualsiasi viaggio
        // posso controllare il ruolo dell'utente loggato per verificare che sia un admin
        boolean isAdmin = utenteLoggato.getRoles().contains(Role.ROLE_ADMIN);

        // consento la modifica solo se l'utente loggato è il proprietario del viaggio
        // oppure se è un amministratore
        if (viaggio.getAppUser().getId().equals(utenteLoggato.getId()) || isAdmin) {
            // uso BeanUtils per copiare automaticamente i dati dalla request all'entità
            BeanUtils.copyProperties(request, viaggio);
        } else {
            throw new IllegalArgumentException("Non sei autorizzato a modificare questo viaggio");
        }

        viaggioRepository.save(viaggio);

        return new ViaggioResponse(
                viaggio.getId(),
                viaggio.getDestinazione(),
                viaggio.getData(),
                viaggio.getStato());
    }

    @Transactional
    public void delete(Long id) {
        Viaggio viaggio = viaggioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Viaggio non trovato con id: " + id));

        prenotazioneRepository.deleteAllByViaggioId(id);
        viaggioRepository.delete(viaggio);
    }

    public void aggiornaStato(Long id, StatoViaggio stato, AppUser utenteLoggato) {
        Viaggio viaggio = viaggioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Viaggio non trovato con id: " + id));

        boolean isAdmin = utenteLoggato.getRoles().contains(Role.ROLE_ADMIN);

        if (viaggio.getAppUser().getId().equals(utenteLoggato.getId()) || isAdmin) {
            viaggio.setStato(stato);
            viaggioRepository.save(viaggio);
        } else {
            throw new IllegalArgumentException("Non sei autorizzato a modificare questo viaggio");
        }
    }


    public Viaggio getEntityById(Long id) {
        return viaggioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Viaggio non trovato con id: " + id));
    }
}
