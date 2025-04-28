package it.epicode.Pratica_S7_L1.viaggi;


import it.epicode.Pratica_S7_L1.common.CommonResponse;
import it.epicode.Pratica_S7_L1.prenotazioni.PrenotazioneService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/viaggi")
public class ViaggioController {

    @Autowired
    private ViaggioService viaggioService;

    @Autowired
    private PrenotazioneService prenotazioneService;

    // get tutti i viaggi
    // hasRole - USER fa si che il metodo sia accessibile solo da user
    @PreAuthorize("hasRole('USER')")
    @GetMapping
    public List<ViaggioResponse> findAll() {
        return viaggioService.findAll();
    }

    // get singolo viaggio con id
    @GetMapping("/{id}")
    public ViaggioResponse find(@PathVariable Long id) {
        return viaggioService.findById(id);
    }

    // post creazione nuovo viaggio
    // IS AUTHENTICATED fa si che il metodo sia accessibile da tutti quelli che sono autenticati
    @PreAuthorize("isAuthenticated()")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ViaggioResponse save(@RequestBody @Valid ViaggioRequest request) {
        return viaggioService.save(request);
    }

    // put modifico viaggio con id
    @PutMapping("/{id}")
    public ViaggioResponse update(@PathVariable Long id, @RequestBody ViaggioRequest request) {
        return viaggioService.update(id, request);
    }

    // delete elimino viaggio con id
    // hasRole - ROLE_ADMIN fa si che il metodo sia accessibile solo da admin
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public CommonResponse delete(@PathVariable Long id) {
        viaggioService.delete(id);
        return new CommonResponse(id);
    }

    // patch aggiorno lo stato del viaggio
    @PatchMapping("/{id}/stato")
    public ViaggioResponse updateStato(@PathVariable Long id, @RequestParam StatoViaggio stato) {
        viaggioService.aggiornaStato(id, stato);
        return viaggioService.findById(id);
    }

}