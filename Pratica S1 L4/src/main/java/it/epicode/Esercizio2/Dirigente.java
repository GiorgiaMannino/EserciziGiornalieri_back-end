package it.epicode.Esercizio2;

public class Dirigente extends Dipendente2 {

    public Dirigente(int matricola, double stipendio, Dipartimento2 dipartimento) {
        super(matricola, stipendio, dipartimento);
    }

    @Override
    public double calculateSalary() {
        return getStipendio() * 2; // Ipotizzo che lo stipendio  siaraddoppiato per i dirigenti
    }
}
