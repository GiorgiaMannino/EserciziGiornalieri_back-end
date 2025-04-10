package it.epicode.Pratica_S5_L4.pizze;

import it.epicode.Pratica_S5_L4.toppings.Topping;
import it.epicode.Pratica_S5_L4.menu.ElementoMenu;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Pizza extends ElementoMenu {

    public Pizza(String nome, String descrizione, double prezzo, int calorie) {
        setNome(nome);
        setDescrizione(descrizione);
        setPrezzo(prezzo);
        setCalorie(calorie);
    }

    @ManyToMany
    private List<Topping> toppings = new ArrayList<>();

    // Il prezzo totale è la somma del prezzo base e dei prezzi dei toppings
    @Override
    public double getPrezzo() {
        double tot = super.getPrezzo();
        if (toppings != null) {
            for (Topping t : toppings) {
                tot += t.getPrezzo();
            }
        }
        return tot;
    }

    // Le calorie totali sono la somma delle calorie base e di quelle dei toppings
    @Override
    public int getCalorie() {
        int tot = super.getCalorie();
        if (toppings != null) {
            for (Topping t : toppings) {
                tot += t.getCalorie();
            }
        }
        return tot;
    }
}