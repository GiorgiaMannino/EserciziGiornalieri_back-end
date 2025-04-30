package it.epicode.Pratica_S7_L3.composite.autori;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Autore {
    private String nome;
    private String cognome;

    @Override
    public String toString() {
        return nome + " " + cognome;
    }
}
