package it.epicode.Esercizio2;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Dipendente2 {
    private final int matricola;
    private final double stipendio;
    private Dipartimento2 dipartimento;

    public Dipendente2(int matricola, double stipendio, Dipartimento2 dipartimento) {
        this.matricola = matricola;
        this.stipendio = stipendio;
        this.dipartimento = dipartimento;
    }

    public abstract double calculateSalary();
}

