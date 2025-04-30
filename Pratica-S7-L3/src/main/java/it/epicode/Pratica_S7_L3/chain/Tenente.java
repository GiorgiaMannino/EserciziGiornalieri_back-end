package it.epicode.Pratica_S7_L3.chain;

public class Tenente extends Ufficiale {

    public Tenente(Ufficiale responsabile) {
        super(responsabile, 1000, "Tenente");
    }

    @Override
    public void gestisciRichiesta(int importo) {
        if (importo <= stipendio) {
            System.out.println("Il Tenente può gestire la richiesta di " + importo + "€");
        } else if (supervisor != null) {
            System.out.println("Il Tenente non può gestire la richiesta di " + importo + "€, la passa al superiore.");
            supervisor.gestisciRichiesta(importo); // Passa la richiesta al superiore
        }
    }
}
