package it.epicode.Esercizio1;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Getter
public class abstract Dipendente {
    private int matricola;
    private double stipendio;
    @Setter
    private Dipartimento dipartimento;
}
