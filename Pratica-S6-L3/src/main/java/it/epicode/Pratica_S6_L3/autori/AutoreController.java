package it.epicode.Pratica_S6_L3.autori;

import it.epicode.Pratica_S6_L3.common.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import jakarta.validation.Valid;


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

}
