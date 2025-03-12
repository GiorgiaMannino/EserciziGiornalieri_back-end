package it.epicode.Esercizio3;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Carrello {
    private Cliente clienteAssociato;
    private Articolo[] articoli = new Articolo[5];
    private double costoArticoli;
}
