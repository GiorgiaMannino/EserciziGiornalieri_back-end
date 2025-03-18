package it.epicode.Esercizio3.classi;

import it.epicode.Esercizio3.exceptions.BancaException;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContoCorrente {
    private String titolare;
    private int nMovimenti;
    private final int maxMovimenti = 50;
    private double saldo;

    // Costruttore
    public ContoCorrente(String titolare, double saldo) {
        this.titolare = titolare;
        this.saldo = saldo;
        this.nMovimenti = 0;
    }

    // Metodo per prelevare denaro
    public void preleva(double x) throws BancaException {
        if (nMovimenti < maxMovimenti)
            saldo = saldo - x;
        else
            saldo = saldo - x - 0.5;

        nMovimenti++;

        // Se il saldo è zero o minore, lancio l'eccezione
        if (saldo <= 0) {
            throw new BancaException("Il conto è in rosso");
        }
    }

    // Metodo per restituire il saldo
    public double restituisciSaldo() {
        return saldo;
    }
}
