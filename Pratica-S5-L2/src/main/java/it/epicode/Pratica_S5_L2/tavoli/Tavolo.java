package it.epicode.Pratica_S5_L2.tavoli;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tavolo {

    private int numeroTavolo;
    private int numeroCopertiMax;

    private StatoTavolo stato= StatoTavolo.LIBERO;

    public Tavolo(int numeroCopertiMax, int numeroTavolo) {
        this.numeroCopertiMax = numeroCopertiMax;
        this.numeroTavolo = numeroTavolo;
    }
}
