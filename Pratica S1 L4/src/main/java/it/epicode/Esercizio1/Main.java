package it.epicode.Esercizio1;

public class Main {
    public static void main(String[] args) {
        // Creazione dei dipendenti con Dipartimento
        Dipendente dipendente1 = new Dipendente(1, 2000.50, Dipartimento.PRODUZIONE);
        Dipendente dipendente2 = new Dipendente(2, 2500.75, Dipartimento.AMMINISTRAZIONE);
        Dipendente dipendente3 = new Dipendente(3, 1800.00, Dipartimento.VENDITE);

        // Array di dipendenti
        Dipendente[] dipendenti = {dipendente1, dipendente2, dipendente3};

        // Iterazione sui dipendenti e stampa delle matricole
        for (Dipendente dip : dipendenti) {
            System.out.println("Matricola Dipendente: " + dip.getMatricola());
        }
    }
}
