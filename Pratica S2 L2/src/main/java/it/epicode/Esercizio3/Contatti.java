package it.epicode.Esercizio3;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Contatti {

    private String nome;

    @Getter
    private String numero;

    // Costruttore
    public Contatti(String nome, String numero) {
        this.nome = nome;
        this.numero = numero;
    }

    @Override
    public String toString() {
        return nome + ": " + numero;
    }
}
