package it.epicode.Esercizio1;

public class Main {
    public static void main(String[] args) {
        // Creo dipendenti
        Dipendente dipendente1 = new Dipendente(1, 2000.50, Dipartimento.PRODUZIONE);
        Dipendente dipendente2 = new Dipendente(2, 2500.75, Dipartimento.AMMINISTRAZIONE);
        Dipendente dipendente3 = new Dipendente(3, 1800.00, Dipartimento.VENDITE);

        Dipendente[] dipendenti = {dipendente1, dipendente2, dipendente3};

        // Iterazione dipendente e stampa della matricola
        for (int i = 0; i < dipendenti.length; i++) {
            System.out.println("Matricola Dipendente" + (i + 1) + ": " + dipendenti[i].getMatricola());
        }
    }
}
