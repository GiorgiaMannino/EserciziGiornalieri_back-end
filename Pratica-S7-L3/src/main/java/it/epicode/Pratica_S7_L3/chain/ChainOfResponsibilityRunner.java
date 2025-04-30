package it.epicode.Pratica_S7_L3.chain;

public class ChainOfResponsibilityRunner {

    public static void main(String[] args) {

        Generale generale = new Generale();
        Colonnello colonnello = new Colonnello(generale);
        Maggiore maggiore = new Maggiore(colonnello);
        Capitano capitano = new Capitano(maggiore);
        Tenente tenente = new Tenente(capitano);

        // Chiediamo una gestione della richiesta per un importo
        int importoRichiesto = 3500;
        tenente.gestisciRichiesta(importoRichiesto);
    }
}
