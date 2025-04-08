package it.epicode.Pratica_S5_L2.toppings;

import it.epicode.Pratica_S5_L2.menu.RigaMenu;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Topping implements RigaMenu {

    public String descrizioneRiga() {
        return descrizione + " - " + prezzo + "€" + " - " + calorie + " kcal";
    }

    @Override
    public double prezzoTotale() {
        return prezzo;
    }

    private String nome;
    private String descrizione;
    private double prezzo;
    private int calorie;

}
