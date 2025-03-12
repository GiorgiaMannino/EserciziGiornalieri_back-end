package it.epicode.Esercizio2;

public class Main {
    public static void main(String[] args) {
        // Creazione SIM
        SIM sim = new SIM();
        sim.setNumero(3809086543L);
        sim.setCredito(10);

        // Creazione delle chiamate
        Chiamate chiamata0 = new Chiamate(3809900543L, 1);
        Chiamate chiamata1 = new Chiamate(3809472943L, 1);
        Chiamate chiamata2 = new Chiamate(3898700543L, 1);
        Chiamate chiamata3 = new Chiamate(3812300543L, 0.30);
        Chiamate chiamata4 = new Chiamate(3809901134L, 1);

        // Assegnazione delle chiamate alla SIM
        sim.getChiamate()[0] = chiamata0;
        sim.getChiamate()[1] = chiamata1;
        sim.getChiamate()[2] = chiamata2;
        sim.getChiamate()[3] = chiamata3;
        sim.getChiamate()[4] = chiamata4;

        // Stampare i dati della SIM
        sim.stampaDatiSIM();
    }
}
