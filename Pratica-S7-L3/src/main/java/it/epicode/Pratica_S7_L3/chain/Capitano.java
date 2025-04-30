package it.epicode.Pratica_S7_L3.chain;

public class Capitano extends Ufficiale {

    public Capitano(Ufficiale responsabile) {
        super(responsabile, 2000, "Capitano");
    }

    @Override
    public void gestisciRichiesta(int importo) {
        if (importo <= stipendio) {
            System.out.println("Il Capitano può gestire la richiesta di " + importo + "€");
        } else if (supervisor != null) {
            System.out.println("Il Capitano non può gestire la richiesta di " + importo + "€, la passa al superiore.");
            supervisor.gestisciRichiesta(importo); // Passa la richiesta al superiore
        }
    }
}
