package it.epicode.Esercizio1;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class Dipendente {
    private int matricola;
    private double stipendio;
    private Dipartimento dipartimento;  // Questo campo può essere modificato tramite il setter

    // Costruttore con Dipartimento
    public Dipendente(int matricola, double stipendio, Dipartimento dipartimento) {
        this.matricola = matricola;
        this.stipendio = stipendio;
        this.dipartimento = dipartimento;
    }
}
