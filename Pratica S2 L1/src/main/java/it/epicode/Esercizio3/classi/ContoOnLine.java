package it.epicode.Esercizio3.classi;

import it.epicode.Esercizio3.exceptions.BancaException;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContoOnLine extends ContoCorrente {
    private double maxPrelievo;

    // Costruttore
    public ContoOnLine(String titolare, double saldo, double maxP) {
        super(titolare, saldo); // Chiama il costruttore della superclasse
        this.maxPrelievo = maxP;
    }

    public void stampaSaldo() {
        System.out.println("Titolare: " + getTitolare() + " - Saldo: " + getSaldo()
                + " - Num movimenti: " + getNMovimenti()
                + " - Massimo movimenti: " + getMaxMovimenti()
                + " - Massimo prelievo possibile: " + maxPrelievo);
    }

    public void preleva(double x) throws BancaException {
        if (x > maxPrelievo) {
            throw new BancaException("Il prelievo non è disponibile");
        }
        super.preleva(x);
    }
}
