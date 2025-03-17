package it.epicode.Esercizio2;

public class Main {
    public static void main(String[] args) {
        // Creazione dei dipendenti
        Dipendente2[] dipendenti = creaDipendenti();

        // Calcolo e stampa degli stipendi
        for (int i = 0; i < dipendenti.length; i++) {
            System.out.println("Stipendio Dipendente " + dipendenti[i].getMatricola() + ": " + dipendenti[i].calculateSalary());
        }
    }

    private static Dipendente2[] creaDipendenti() {
        DipendentePartTime dipendentePartTime1 = new DipendentePartTime(1, 2000.50, Dipartimento2.PRODUZIONE, 8);
        DipendentePartTime dipendentePartTime2 = new DipendentePartTime(2, 2000.50, Dipartimento2.AMMINISTRAZIONE, 6);
        DipendentePartTime dipendentePartTime3 = new DipendentePartTime(3, 2000.50, Dipartimento2.VENDITE, 4);

        DipendenteFullTime dipendenteFullTime1 = new DipendenteFullTime(4, 2500.75, Dipartimento2.PRODUZIONE);
        DipendenteFullTime dipendenteFullTime2 = new DipendenteFullTime(5, 2500.75, Dipartimento2.AMMINISTRAZIONE);
        DipendenteFullTime dipendenteFullTime3 = new DipendenteFullTime(6, 2500.75, Dipartimento2.VENDITE);

        Dirigente dirigente1 = new Dirigente(7, 4000.00, Dipartimento2.PRODUZIONE);
        Dirigente dirigente2 = new Dirigente(8, 4000.00, Dipartimento2.AMMINISTRAZIONE);

        return new Dipendente2[] {dipendentePartTime1, dipendentePartTime2, dipendentePartTime3,
                dipendenteFullTime1, dipendenteFullTime2, dipendenteFullTime3,
                dirigente1, dirigente2};
    }
}


