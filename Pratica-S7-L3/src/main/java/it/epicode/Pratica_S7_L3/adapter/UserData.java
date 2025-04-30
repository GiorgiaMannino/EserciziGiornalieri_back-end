package it.epicode.Pratica_S7_L3.adapter;

public class UserData {
    private String nomeCompleto;
    private int eta;

    public void getData(DataSource ds) {
        nomeCompleto = ds.getNomeCompleto(); // Recupero il nome completo tramite DataSource
        eta = ds.getEta(); // Recupero l'età tramite DataSource
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public int getEta() {
        return eta;
    }
}
