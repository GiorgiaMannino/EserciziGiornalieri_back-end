package it.epicode.Esercizio3;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Articolo {
    private long codice;
    private String descrizione;
    private double prezzo;
    private int pezziInMagazzino;
}
