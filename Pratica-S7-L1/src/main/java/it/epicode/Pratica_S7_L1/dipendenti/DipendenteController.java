package it.epicode.Pratica_S7_L1.dipendenti;


import it.epicode.Pratica_S7_L1.common.CommonResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/dipendenti")
public class DipendenteController {

    @Autowired
    private DipendenteService dipendenteService;

    // get tutti i dipendenti
    // hasRole - USER fa si che il metodo sia accessibile solo da user
    @PreAuthorize("hasRole('USER')")
    public List<DipendenteResponse> findAll() {
        return dipendenteService.findAll();
    }

    // get singolo dipendente con id
    @GetMapping("/{id}")
    public DipendenteResponse find(@PathVariable Long id) {
        return dipendenteService.findById(id);
    }

    // post creazione nuovo dipendente
    // IS AUTHENTICATED fa si che il metodo sia accessibile da tutti quelli che sono autenticati
    @PreAuthorize("isAuthenticated()")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DipendenteResponse save(@RequestBody @Valid DipendenteRequest request) {
        return dipendenteService.save(request);
    }

    // put modifico dipendente con id
    @PutMapping("/{id}")
    public DipendenteResponse update(@PathVariable Long id, @RequestBody DipendenteRequest request) {
        return dipendenteService.update(id, request);
    }

    // delete elimino dipendente con id
    // hasRole - ROLE_ADMIN fa si che il metodo sia accessibile solo da admin
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public CommonResponse delete(@PathVariable Long id) {
        dipendenteService.delete(id);
        return new CommonResponse(id);
    }

    @PatchMapping(value = "/{id}/immagine", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> uploadImmagineProfilo(
            @PathVariable Long id,
            @RequestPart("file") MultipartFile file) {

        dipendenteService.uploadImmagineProfilo(id, file);
        return ResponseEntity.noContent().build();
    }

}