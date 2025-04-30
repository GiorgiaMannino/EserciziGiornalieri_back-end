package it.epicode.Pratica_S7_L3.composite.Libri;

import it.epicode.Pratica_S7_L3.composite.autori.Autore;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Libro {
    private String titolo;
    private double prezzo;
    private List<Autore> autori;
    private List<ElementoLibro> contenuti;

    // Costruttore personalizzato
    public Libro(String titolo, double prezzo) {
        this.titolo = titolo;
        this.prezzo = prezzo;
        this.autori = new ArrayList<>();
        this.contenuti = new ArrayList<>();
    }

    public void aggiungiAutore(Autore autore) {
        autori.add(autore);
    }

    public void aggiungiContenuto(ElementoLibro contenuto) {
        contenuti.add(contenuto);
    }

    public void stampa() {
        System.out.println("Libro: " + titolo);
        System.out.println("Autori:");
        autori.forEach(a -> System.out.println("- " + a));
        System.out.println("Prezzo: " + prezzo + "€");
        contenuti.forEach(ElementoLibro::stampa);
    }

    public int getNumeroTotalePagine() {
        return contenuti.stream()
                .mapToInt(ElementoLibro::getNumeroPagine)
                .sum();
    }
}
