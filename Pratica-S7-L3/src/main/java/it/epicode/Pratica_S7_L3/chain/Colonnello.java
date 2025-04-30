package it.epicode.Pratica_S7_L3.chain;

public class Colonnello extends Ufficiale {

    public Colonnello(Ufficiale responsabile) {
        super(responsabile, 4000, "Colonnello");
    }

    @Override
    public void gestisciRichiesta(int importo) {
        if (importo <= stipendio) {
            System.out.println("Il Colonnello può gestire la richiesta di " + importo + "€");
        } else if (supervisor != null) {
            System.out.println("Il Colonnello non può gestire la richiesta di " + importo + "€, la passa al superiore.");
            supervisor.gestisciRichiesta(importo); // Passa la richiesta al superiore
        }
    }
}
