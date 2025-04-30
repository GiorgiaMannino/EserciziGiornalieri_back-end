package it.epicode.Pratica_S7_L3.chain;

public class Maggiore extends Ufficiale {

    public Maggiore(Ufficiale responsabile) {
        super(responsabile, 3000, "Maggiore");
    }

    @Override
    public void gestisciRichiesta(int importo) {
        if (importo <= stipendio) {
            System.out.println("Il Maggiore può gestire la richiesta di " + importo + "€");
        } else if (supervisor != null) {
            System.out.println("Il Maggiore non può gestire la richiesta di " + importo + "€, la passa al superiore.");
            supervisor.gestisciRichiesta(importo); // Passa la richiesta al superiore
        }
    }
}
