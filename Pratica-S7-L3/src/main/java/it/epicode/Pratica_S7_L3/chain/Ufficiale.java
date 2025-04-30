package it.epicode.Pratica_S7_L3.chain;

public abstract class Ufficiale {

    protected Ufficiale supervisor; // Il responsabile (superiore gerarchico)
    protected int stipendio;
    protected String grado;

    public Ufficiale(Ufficiale responsabile, int stipendio, String grado) {
        this.supervisor = responsabile; // Assegna il responsabile superiore
        this.stipendio = stipendio;
        this.grado = grado;
    }

    public abstract void gestisciRichiesta(int importo); // Metodo da implementare nelle classi derivate

    public String getGrado() {
        return grado;
    }

    public int getStipendio() {
        return stipendio;
    }
}
