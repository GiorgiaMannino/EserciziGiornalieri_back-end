package it.epicode.Pratica_S7_L3.composite.Libri;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Pagina implements ElementoLibro {
    private String contenuto;

    @Override
    public void stampa() {
        System.out.println("Pagina: " + contenuto);
    }

    @Override
    public int getNumeroPagine() {
        return 1;
    }
}
