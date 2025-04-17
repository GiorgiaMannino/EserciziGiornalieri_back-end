package it.epicode.Pratica_S6_L4.autori;

import it.epicode.Pratica_S6_L4.common.CommonResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@RestController
@RequestMapping("/autori")
public class AutoreController {

    @Autowired
    private AutoreService autoreService;

    // get lista di autori
    @GetMapping
    public List<AutoreResponse> find() {
        return autoreService.findAllAutori();
    }

    // get autore con id
    @GetMapping("/{id}")
    public AutoreResponse find(@PathVariable Long id) {
        return autoreService.findById(id);
    }

    // modifico autore con id
    @PutMapping("/{id}")
    public AutoreResponse update(@PathVariable Long id, @RequestBody AutoreRequest autoreRequest) {
        return autoreService.update(id, autoreRequest);
    }

    // delete autore con id
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public CommonResponse delete(@PathVariable Long id) {
        autoreService.deleteById(id);
        return new CommonResponse(id);
    }

    // post creo autore
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AutoreResponse save( @RequestBody @Valid AutoreRequest autoreRequest) {
        return autoreService.save(autoreRequest);
    }

    // Creazione autore con upload imagine
    @PostMapping(path = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public AutoreResponse saveWithAvatar(
            @RequestPart("nome") String nome,
            @RequestPart("cognome") String cognome,
            @RequestPart("email") String email,
            @RequestPart("dataDiNascita") String dataDiNascita,
            @RequestPart("avatar") MultipartFile avatarFile
    ) {
        return autoreService.saveWithAvatar(nome, cognome, email, dataDiNascita, avatarFile);
    }




}
