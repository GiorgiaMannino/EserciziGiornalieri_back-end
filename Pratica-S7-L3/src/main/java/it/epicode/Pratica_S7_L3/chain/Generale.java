package it.epicode.Pratica_S7_L3.chain;

public class Generale extends Ufficiale {

    public Generale() {
        super(null, 5000, "Generale"); // Il Generale non ha un superiore
    }

    @Override
    public void gestisciRichiesta(int importo) {
        if (importo <= stipendio) {
            System.out.println("Il Generale può gestire la richiesta di " + importo + "€");
        } else {
            System.out.println("Il Generale non può gestire la richiesta di " + importo + "€");
        }
    }
}
