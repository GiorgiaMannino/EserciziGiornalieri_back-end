package it.epicode.Pratica_S5_L1.toppings;

import it.epicode.Pratica_S5_L1.menu.RigaMenu;
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

    private String nome;
    private String descrizione;
    private double prezzo;
    private int calorie;

}
