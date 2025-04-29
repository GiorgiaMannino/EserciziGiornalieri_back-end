package it.epicode.Pratica_S7_L2.prenotazioni;

import it.epicode.Pratica_S7_L2.auth.AppUser;
import it.epicode.Pratica_S7_L2.auth.Role;
import it.epicode.Pratica_S7_L2.dipendenti.DipendenteService;
import it.epicode.Pratica_S7_L2.viaggi.ViaggioService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
public class PrenotazioneService {

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    @Autowired
    private ViaggioService viaggioService;

    @Autowired
    private DipendenteService dipendenteService;

    public List<PrenotazioneResponse> findAll() {
        return prenotazioneRepository.findAll().stream()
                .map(p -> new PrenotazioneResponse(
                        p.getId(),
                        p.getViaggio().getDestinazione(),
                        p.getDipendente().getUsername(),
                        p.getDataRichiesta(),
                        p.getPreferenze()))
                .toList();
    }

    public PrenotazioneResponse findById(Long id) {
        Prenotazione p = prenotazioneRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Prenotazione con id " + id + " non trovata"));
        return new PrenotazioneResponse(
                p.getId(),
                p.getViaggio().getDestinazione(),
                p.getDipendente().getUsername(),
                p.getDataRichiesta(),
                p.getPreferenze());
    }

    public PrenotazioneResponse save(@Valid PrenotazioneRequest request) {
        if (prenotazioneRepository.existsByDipendenteIdAndDataRichiesta(
                request.getDipendenteId(), request.getDataRichiesta())) {
            throw new IllegalStateException("Dipendente già prenotato per quella data");
        }

        Prenotazione p = new Prenotazione();
        p.setViaggio(viaggioService.getEntityById(request.getViaggioId()));
        p.setDipendente(dipendenteService.getEntityById(request.getDipendenteId()));
        p.setDataRichiesta(request.getDataRichiesta());
        p.setPreferenze(request.getPreferenze());
        prenotazioneRepository.save(p);

        return new PrenotazioneResponse(
                p.getId(),
                p.getViaggio().getDestinazione(),
                p.getDipendente().getUsername(),
                p.getDataRichiesta(),
                p.getPreferenze());
    }

    public void delete(Long id) {
        Prenotazione p = prenotazioneRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Prenotazione con id " + id + " non trovata"));
        prenotazioneRepository.delete(p);
    }


    public PrenotazioneResponse update(Long id, @Valid PrenotazioneRequest request, AppUser utenteLoggato) {
        Prenotazione p = prenotazioneRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Prenotazione con id " + id + " non trovata"));

        // Verifica se l'utente è un admin o il proprietario della prenotazione
        boolean isAuthorized = utenteLoggato.getRoles().contains(Role.ROLE_ADMIN) ||
                p.getDipendente().getAppUser().getId().equals(utenteLoggato.getId());
        if (!isAuthorized) {
            throw new IllegalArgumentException("Non sei autorizzato a modificare questa prenotazione");
        }
        // Verifica se la data richiesta è già prenotata da un altro dipendente
        if (prenotazioneRepository.existsByDipendenteIdAndDataRichiesta(request.getDipendenteId(), request.getDataRichiesta()) &&
                !p.getDipendente().getId().equals(request.getDipendenteId()) &&
                !p.getDataRichiesta().equals(request.getDataRichiesta())) {
            throw new IllegalStateException("Dipendente già prenotato per quella data");
        }
        // Aggiornamento dei dati della prenotazione
        p.setViaggio(viaggioService.getEntityById(request.getViaggioId()));
        p.setDipendente(dipendenteService.getEntityById(request.getDipendenteId()));
        p.setDataRichiesta(request.getDataRichiesta());
        p.setPreferenze(request.getPreferenze());
        prenotazioneRepository.save(p);

        return new PrenotazioneResponse(
                p.getId(),
                p.getViaggio().getDestinazione(),
                p.getDipendente().getUsername(),
                p.getDataRichiesta(),
                p.getPreferenze());
    }

}
