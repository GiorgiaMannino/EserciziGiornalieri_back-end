package it.epicode.Esercizio2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SIM {
    private long numero;
    private double credito;
    private Chiamate[] chiamate = new Chiamate[5];

    public void stampaDatiSIM() {
        System.out.println("Numero di telefono: " + numero);
        System.out.println("Credito disponibile: " + credito + "€");
        System.out.println("Ultime 5 chiamate:");
        for (Chiamate chiamata : chiamate) {
            if (chiamata != null) {
                System.out.println("Numero chiamato: " + chiamata.getNumeroTelefono() +
                        ", Durata: " + chiamata.getDurataChiamata() + " min");
            }
        }
    }
}
