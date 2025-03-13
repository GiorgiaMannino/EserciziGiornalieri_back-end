package it.epicode.Esercizio2;

public class DipendenteFullTime extends Dipendente2 {

    public DipendenteFullTime(int matricola, double stipendio, Dipartimento2 dipartimento) {
        super(matricola, stipendio, dipartimento);
    }

    @Override
    public double calculateSalary() {
        return getStipendio(); // Lo stipendio rimane fisso per i dipendenti full-time
    }
}
