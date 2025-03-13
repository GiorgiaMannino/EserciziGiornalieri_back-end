package it.epicode.Esercizio2;

public class DipendentePartTime extends Dipendente2 {

    private final int oreLavorative;

    public DipendentePartTime(int matricola, double stipendio, Dipartimento2 dipartimento, int oreLavorative) {
        super(matricola, stipendio, dipartimento);
        this.oreLavorative = oreLavorative;
    }

    @Override
    public double calculateSalary() {
        return getStipendio() / 160 * oreLavorative;  // Supponiamo 160 ore al mese come riferimento
    }
}
