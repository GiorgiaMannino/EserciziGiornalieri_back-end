package it.epicode.Pratica_S7_L2.dipendenti;

import it.epicode.Pratica_S7_L2.auth.AppUser;
import it.epicode.Pratica_S7_L2.auth.Role;
import it.epicode.Pratica_S7_L2.cloudinary.CloudinaryService;
import it.epicode.Pratica_S7_L2.prenotazioni.PrenotazioneRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@Validated
public class DipendenteService {

    @Autowired
    private DipendenteRepository dipendenteRepository;

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    @Autowired
    private CloudinaryService cloudinaryService;

    public List<DipendenteResponse> findAll() {
        return dipendenteRepository.findAll().stream()
                .map(d -> new DipendenteResponse(d.getId(),  d.getNome(), d.getCognome(), d.getEmail(), d.getImmagineProfilo()))
                .toList();
    }

    public DipendenteResponse findById(Long id) {
        Dipendente d = dipendenteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Dipendente non trovato con id: " + id));
        return new DipendenteResponse(d.getId(),  d.getNome(), d.getCognome(), d.getEmail(), d.getImmagineProfilo());
    }


    public DipendenteResponse save(@Valid DipendenteRequest request) {
        Dipendente d = new Dipendente();
        d.setNome(request.getNome());
        d.setCognome(request.getCognome());
        d.setEmail(request.getEmail());
        dipendenteRepository.save(d);
        return new DipendenteResponse(d.getId(),  d.getNome(), d.getCognome(), d.getEmail(), d.getImmagineProfilo());
    }

    // Bcrypto -> protezione della password durante l'update dell'utente
    public DipendenteResponse update(Long id, DipendenteRequest request, AppUser utenteLoggato) {
        Dipendente dipendente = dipendenteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Dipendente non trovato con id: " + id));

        boolean isAdmin = utenteLoggato.getRoles().contains(Role.ROLE_ADMIN);

        if (dipendente.getAppUser().getId().equals(utenteLoggato.getId()) || isAdmin) {
            BeanUtils.copyProperties(request, dipendente);
        } else {
            throw new IllegalArgumentException("Non sei autorizzato a modificare questo dipendente");
        }

        Dipendente updated = dipendenteRepository.save(dipendente);

        return new DipendenteResponse(updated);
    }




    @Transactional
    public void delete(Long id) {
        Dipendente d = dipendenteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Dipendente non trovato"));

        prenotazioneRepository.deleteAllByDipendenteId(id);

        dipendenteRepository.delete(d);
    }

    public Dipendente getEntityById(Long id) {
        return dipendenteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Dipendente non trovato"));
    }

    @Transactional
    public void uploadImmagineProfilo(Long dipendenteId, MultipartFile file) {
        Dipendente dipendente = dipendenteRepository.findById(dipendenteId)
                .orElseThrow(() -> new EntityNotFoundException("Dipendente non trovato con ID: " + dipendenteId));

        String imageUrl = cloudinaryService.uploadImage(file);
        dipendente.setImmagineProfilo(imageUrl);

        dipendenteRepository.save(dipendente);
    }

}
