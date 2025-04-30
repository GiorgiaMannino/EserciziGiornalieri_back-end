package it.epicode.Pratica_S7_L3.composite.Libri;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Sezione implements ElementoLibro {
    private String titolo;
    private List<ElementoLibro> sottoElementi;

    public Sezione(String titolo) {
        this.titolo = titolo;
        this.sottoElementi = new ArrayList<>();
    }

    public void aggiungiElemento(ElementoLibro elemento) {
        sottoElementi.add(elemento);
    }

    @Override
    public void stampa() {
        System.out.println("Sezione: " + titolo);
        sottoElementi.forEach(ElementoLibro::stampa);
    }

    @Override
    public int getNumeroPagine() {
        return sottoElementi.stream()
                .mapToInt(ElementoLibro::getNumeroPagine)
                .sum();
    }
}
