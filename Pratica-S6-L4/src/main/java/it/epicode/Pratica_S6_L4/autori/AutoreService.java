package it.epicode.Pratica_S6_L4.autori;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import it.epicode.Pratica_S6_L4.email.EmailService;
import jakarta.mail.MessagingException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Service
@Validated
public class AutoreService {

    @Autowired
    private AutoreRepository autoreRepository;

    @Autowired
    private Cloudinary cloudinary;

    @Autowired
    private EmailService emailService;  // Iniezione di EmailService

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
    public AutoreResponse save(@Valid AutoreRequest autoreRequest) {
        Autore autore = new Autore();
        autore.setNome(autoreRequest.getNome());
        autore.setCognome(autoreRequest.getCognome());
        autore.setEmail(autoreRequest.getEmail());
        autore.setAvatar(autoreRequest.getAvatar());
        autoreRepository.save(autore);

        // Invia l'email di conferma
        try {
            emailService.sendEmail(
                    autore.getEmail(),
                    "Conferma creazione autore",
                    "Caro " + autore.getNome() + ", la tua registrazione come autore è stata completata con successo!"
            );
        } catch (MessagingException e) {
            throw new RuntimeException("Errore durante l'invio dell'email di conferma", e);
        }

        return new AutoreResponse(autore.getId(), autore.getNome() + " " + autore.getCognome());
    }

    // Upload su Cloudinary + salvataggio autore
    public AutoreResponse saveWithAvatar(String nome, String cognome, String email, String dataDiNascita, MultipartFile avatarFile) {
        try {
            // Effettua l'upload su Cloudinary e salva il nuovo autore
            Map uploadResult = cloudinary.uploader().upload(avatarFile.getBytes(),
                    ObjectUtils.asMap(
                            "folder", "Epicode",
                            "public_id", avatarFile.getOriginalFilename()
                    ));

            System.out.println("Upload result: " + uploadResult);  // Per debugging

            String avatarUrl = uploadResult.get("secure_url").toString();  // URL dell'immagine caricata

            Autore autore = new Autore();
            autore.setNome(nome);
            autore.setCognome(cognome);
            autore.setEmail(email);
            autore.setDataDiNascita(LocalDate.parse(dataDiNascita));
            autore.setAvatar(avatarUrl);

            autoreRepository.save(autore);

            // Invio email a giorgiamannino@hotmail.com con l'immagine
            emailService.sendEmail(
                    "giorgiamannino@hotmail.com",  // Tuo indirizzo email
                    "Immagine salvata con successo",
                    "<h3>Immagine salvata</h3><p>Abbiamo salvato questa immagine:</p><img src='" + avatarUrl + "' alt='Avatar' />"
            );

            return new AutoreResponse(autore.getId(), autore.getNome() + " " + autore.getCognome());

        } catch (IOException | MessagingException e) {
            throw new RuntimeException("Errore durante l'upload dell'immagine su Cloudinary o l'invio dell'email", e);
        }
    }


}
